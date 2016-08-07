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
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
public class UpdatePlan extends JFrame implements ActionListener {

	private static final JComboBox ComboBox = null;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtcharge;
	private Connection cn=null;
	private PreparedStatement ps=null;
    private ResultSet rs=null;	
    private JComboBox comboBox=null;
    private JButton btnupdate=null;
    private JLabel lblDuration;
    private JTextField txtduration;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePlan frame = new UpdatePlan();
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
	public UpdatePlan() {
		cn=CrudOperation.createConnection();
		createGui();
	populateCombo();
		
	}
	public void createGui()
	{
		setTitle("Update Plan");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(Color.ORANGE, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 comboBox = new JComboBox<String>();
		 comboBox.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 20));
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select PlanId"}));
		comboBox.setBounds(528, 30, 175, 52);
        comboBox.addActionListener(this);
		contentPane.add(comboBox);
		
		JLabel lblName = new JLabel("Plan Name");
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblName.setBounds(440, 108, 109, 34);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(721, 111, 109, 34);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblCharge = new JLabel("Charge");
		lblCharge.setForeground(Color.DARK_GRAY);
		lblCharge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblCharge.setBounds(440, 198, 109, 37);
		contentPane.add(lblCharge);
		
		txtcharge = new JTextField();
		txtcharge.setBounds(721, 198, 109, 34);
		contentPane.add(txtcharge);
		txtcharge.setColumns(10);
		
		lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.DARK_GRAY);
		lblDuration.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblDuration.setBounds(440, 299, 109, 37);
		contentPane.add(lblDuration);
		
		txtduration = new JTextField();
		txtduration.setBounds(721, 303, 109, 34);
		contentPane.add(txtduration);
		txtduration.setColumns(10);
		
		 btnupdate = new JButton("Update");
		 btnupdate.setFont(new Font("Tahoma", Font.BOLD, 14));
					btnupdate.setBounds(619, 452, 109, 46);
		btnupdate.addActionListener(this);
		contentPane.add(btnupdate);
		
		
	}
	public void populateCombo()
	{
		String strsql="select planid from plans";
		try
		{
			ps=cn.prepareStatement(strsql);//compile query
			rs=ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					String nm=rs.getString("planid");
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
			JOptionPane.showMessageDialog(this, "please select a valid planid");
		}
		else
		{
			String cid=(String)comboBox.getSelectedItem();
			if(e.getSource()==comboBox)
			{
				String strsql="select planname,charge,duration from plans where planid=?";
				try 
				{
					ps=cn.prepareStatement(strsql);
					ps.setString(1, cid);
					rs=ps.executeQuery();
					if(rs.next())
					{
						String name=rs.getString("planname");
						String charges=rs.getString("charge");
						String dur=rs.getString("duration");
						txtname.setText(name);
						txtcharge.setText(charges);
						txtduration.setText(dur);
					}
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
			if(e.getSource()==btnupdate)
			{
				
				String name=txtname.getText().trim();
				String charge=txtcharge.getText().trim();
				String duration=txtduration.getText().trim();
				if(name.isEmpty()||charge.isEmpty()||duration.isEmpty())
				{
					JOptionPane.showMessageDialog(this, "pls enter data");
				}
				else
				{
				String strupdate="update plans set planname=?,charge=?,duration=? where planid=?";
				try
				{
					ps=cn.prepareStatement(strupdate);
					ps.setString(1, txtname.getText());
					ps.setString(2,txtcharge.getText());
					ps.setString(3, txtduration.getText());
					ps.setString(4, cid);
					int rw=ps.executeUpdate();
					if(rw>0)
					{
						JOptionPane.showMessageDialog(this,"data updated");
						txtname.setText("");
						txtcharge.setText("");
						txtduration.setText("");
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