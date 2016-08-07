package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

import precursor.dbinfo.CrudOperation;
public class AddClerk extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtph;
	private Connection cn=null;
	private PreparedStatement ps=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClerk frame = new AddClerk();
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
	public AddClerk() {
		setTitle("Add Clerk");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setIgnoreRepaint(true);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new LineBorder(Color.BLUE, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.RED);
		lblName.setBackground(Color.ORANGE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblName.setBounds(463,160,108,34);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(681,170,108,34);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setForeground(Color.RED);
		lblEmail.setBackground(Color.RED);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblEmail.setBounds(463,258, 108, 34);
		contentPane.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setBounds(681, 266, 108, 24);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setForeground(Color.RED);
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblPhoneNo.setBounds(463,362,108, 34);
		contentPane.add(lblPhoneNo);
		
		txtph = new JTextField();
		txtph.setBounds(681,372, 108, 20);
		contentPane.add(txtph);
		txtph.setColumns(10);
		
		JButton btnadd = new JButton("Add Clerk");
		btnadd.setFont(new Font("Tahoma",Font.BOLD,12));
		btnadd.setForeground(Color.RED);
		btnadd.addActionListener(this);
		btnadd.setBounds(561,531, 108, 34);
		contentPane.add(btnadd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		cn=CrudOperation.createConnection();
		String name=txtname.getText().trim();
		String em=txtemail.getText().trim();
		String ph=txtph.getText().trim();
		if(name.isEmpty()||em.isEmpty()||ph.length()==0)
		{
			JOptionPane.showMessageDialog(this, "pls enter data");
		}
		else
		{
			String strinsert="insert into clerks(name,email,phone) values(?,?,?)";
		
			try
			{
				ps=cn.prepareStatement(strinsert);//compiling query
				ps.setString(1,name);
				ps.setString(2,em);
				ps.setLong(3,Long.parseLong(ph));
				int  rw=ps.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this, "data added");
					txtemail.setText("");
					txtname.setText("");
					txtph.setText("");
					
				}
	
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
			finally
			{
				if(ps!=null)
				{
					try{
						ps.close();
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					if(cn!=null)
					{
						try
						{
							cn.close();
						}
						catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
				}
				
			}
	}
	
}
}