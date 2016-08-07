package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import precursor.dbinfo.CrudOperation;

import java.sql.*;
public class UpdateClerk extends JFrame implements ActionListener {

	private static final JComboBox ComboBox = null;
	private JPanel contentPane;
	private JTextField txtem;
	private JTextField txtph;
	private Connection cn=null;
	private PreparedStatement ps=null;
    private ResultSet rs=null;	
    private JComboBox comboBox=null;
    private JButton btnupdate=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClerk frame = new UpdateClerk();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateClerk() {
		cn=CrudOperation.createConnection();
		createGui();
	populateCombo();
		
	}
	public void createGui()
	{
		setTitle("Update Clerk");
	setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(Color.ORANGE, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 comboBox = new JComboBox<String>();
		 comboBox.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Id"}));
		comboBox.setBounds(562, 42, 109, 34);
        comboBox.addActionListener(this);
		contentPane.add(comboBox);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblEmail.setBounds(488, 167, 109, 34);
		contentPane.add(lblEmail);
		
		txtem = new JTextField();
		txtem.setBounds(741, 167, 109, 34);
		contentPane.add(txtem);
		txtem.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblPhoneNo.setBounds(488, 277, 109, 34);
		contentPane.add(lblPhoneNo);
		
		txtph = new JTextField();
		txtph.setBounds(741, 280, 109, 34);
		contentPane.add(txtph);
		txtph.setColumns(10);
		
		 btnupdate = new JButton("Update");
		 btnupdate.setFont(new Font("Tahoma", Font.BOLD, 14));
					btnupdate.setBounds(506, 427, 117, 49);
		btnupdate.addActionListener(this);
		contentPane.add(btnupdate);
	}
	public void populateCombo()
	{
		String strsql="select id from clerks";
		try
		{
			ps=cn.prepareStatement(strsql);//compile query
			rs=ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					int  nm=rs.getInt("id");
					comboBox.addItem(nm);
				}
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	   int index=comboBox.getSelectedIndex();
		if(index==0)
		{
			JOptionPane.showMessageDialog(this, "please select a valid id");
		}
		else
		{
			int cid=(int)comboBox.getSelectedItem();
			if(e.getSource()==comboBox)
			{
				String strsql="select email,phone from clerks where id=?";
				try 
				{
					ps=cn.prepareStatement(strsql);
					ps.setInt(1, cid);
					rs=ps.executeQuery();
					if(rs.next())
					{
						String email=rs.getString("email");
						long ph=rs.getLong("phone");
						txtem.setText(email);
						txtph.setText(String.valueOf(ph));
					}
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
			if(e.getSource()==btnupdate)
			{
				
				String em=txtem.getText().trim();
				String ph=txtph.getText().trim();
				if(em.isEmpty()||ph.length()==0)
				{
					JOptionPane.showMessageDialog(this, "pls enter data");
				}
				else
				{
				String strupdate="update clerks set email=?,phone=? where id=?";
				try
				{
					ps=cn.prepareStatement(strupdate);
					ps.setString(1, txtem.getText());
					ps.setLong(2,Long.parseLong(txtph.getText()));
					ps.setInt(3, cid);
					int rw=ps.executeUpdate();
					if(rw>0)
					{
						JOptionPane.showMessageDialog(this,"data updated");
						txtem.setText("");
						txtph.setText("");
					}
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
		}
	}
	}
}