package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import precursor.sportsmanagementproject.Admin;
import precursor.dbinfo.CrudOperation;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JPasswordField;
public class LoginDemo extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;
	private Connection cn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	JComboBox usertypeCombo=null;
	JButton btnlogin=null;
	String ui,up,ut;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDemo frame = new LoginDemo();
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
	public LoginDemo() {
		cn=CrudOperation.createConnection();
		createGui();
	}
	public void createGui()
	{
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1360, 725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new LineBorder(Color.RED, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("User ID");
		lblUserid.setForeground(Color.BLACK);
		lblUserid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblUserid.setBounds(438, 171, 108, 34);
		contentPane.add(lblUserid);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtid.setBounds(724, 171, 108, 34);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblUserPassword = new JLabel("User Password");
		lblUserPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblUserPassword.setBounds(438, 274, 137, 34);
		contentPane.add(lblUserPassword);
		
		 btnlogin = new JButton("Login");
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnlogin.setForeground(Color.DARK_GRAY);
		btnlogin.setBounds(575, 457, 108, 34);
		btnlogin.addActionListener(this);
		contentPane.add(btnlogin);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(724, 277, 108, 34);
		contentPane.add(txtpass);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{ 
		String uid=txtid.getText().trim();
		char[] c=txtpass.getPassword();
		String pass=new String(c);
		if(uid.isEmpty()||pass.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "please fill the appropriate");
		}
		else
		{
			String strsql= "select * from login_1 where userid=? and userpass=?";
			try
			{
				ps=cn.prepareStatement(strsql);
				ps.setString(1,uid);
				ps.setString(2, pass);
				rs=ps.executeQuery();
				if(rs.next())
				{
					String utype=rs.getString("usertype");
					if(utype.equals("admin"))
					{
						Admin a = new Admin();
						a.setVisible(true);
						this.dispose();
						
					}
					
						if(utype.equalsIgnoreCase("clerk"))
						{
							Clerk cl = new Clerk();
							cl.setVisible(true);
							this.dispose();
						}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"invalid user id or pasword");
				}
			}
				catch(SQLException se)
			{
				System.out.println(se);
			}
		}		
		}
		
	

}
