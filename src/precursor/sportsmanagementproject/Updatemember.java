package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import precursor.dbinfo.CrudOperation;

import java.sql.*;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
public class Updatemember extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtem;
	private JTextField txtaddr;
	private JLabel lblPhone;
	private JTextField txtph;

	private JTextField txtocc ;
	private JLabel lblDateofexp;
	private JLabel lblGameid_1;
	private Connection cn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JButton btnSubmit =null;
	private JDateChooser txtdob=null;
	private JDateChooser txtdom=null;
	private JDateChooser txtdoe=null;
	private JComboBox gameidcomboBox=null;
	private JComboBox planidcomboBox=null;
	private JComboBox comboBox=null;
	private JButton btnUpdate=null;
	String p,g;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatemember frame = new Updatemember();
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
	public Updatemember() {
		cn=CrudOperation.createConnection();
		createGui();
	populateCombo();
		populateCombo1();
		populateCombo3();
	}
	public void populateCombo()
	{

	String strsql="select planid from plans";

	try{
		
		ps=cn.prepareStatement(strsql);//complile
		
	rs=	ps.executeQuery();
	if(rs!=null)
	{
		while(rs.next())
		{
			
		String p=rs.getString("planid");
		planidcomboBox.addItem(p);
				
		}
	}

	}
	catch(SQLException se)
	{
		
	System.out.println(se);
	}

	finally{
		try{
			if(ps!=null)
				ps.close();
			if(rs!=null)
				rs.close();
			
		}
		catch(SQLException se)
		{
			
			System.out.println(se);
		}
		
		
	}

	}
	public void populateCombo1()
	{

	String strsql="select gameid from games";

	try{
		
		ps=cn.prepareStatement(strsql);//complile
		
	rs=	ps.executeQuery();
	if(rs!=null)
	{
		while(rs.next())
		{
			
		String p=rs.getString("gameid");
		gameidcomboBox.addItem(p);
				
		}
	}

	}
	catch(SQLException se)
	{
		
	System.out.println(se);
	}

	finally{
		try{
			if(ps!=null)
				ps.close();
			if(rs!=null)
				rs.close();
			
		}
		catch(SQLException se)
		{
			
			System.out.println(se);
		}
		
		
	}

	}

	public void createGui()
	{
		setTitle("Update Members");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1360, 725);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		JLabel lblName = new JLabel("  Name :");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblName.setBounds(24, 210, 86, 20);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(273, 212, 86, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.YELLOW);
		lblEmail.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblEmail.setBounds(24, 287, 86, 20);
		contentPane.add(lblEmail);
		
		txtem = new JTextField();
		txtem.setBounds(273, 289, 86, 20);
		contentPane.add(txtem);
		txtem.setColumns(10);
		
		lblPhone = new JLabel("Phone :");
		lblPhone.setForeground(Color.YELLOW);
		lblPhone.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblPhone.setBounds(24, 368, 72, 20);
		contentPane.add(lblPhone);
		
		txtph = new JTextField();
		txtph.setBounds(273, 370, 86, 20);
		contentPane.add(txtph);
		txtph.setColumns(10);
		

		JLabel lblDob = new JLabel("Dob :");
		lblDob.setForeground(Color.YELLOW);
		lblDob.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblDob.setBounds(22, 441, 86, 20);
		contentPane.add(lblDob);
		
		 txtdob = new JDateChooser();
			txtdob.setBounds(273, 441, 91, 20);
			contentPane.add(txtdob);
			
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(Color.YELLOW);
		lblAddress.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblAddress.setBounds(22, 531, 124, 28);
		contentPane.add(lblAddress);
		
		txtaddr = new JTextField();
		txtaddr.setBounds(204, 516, 232, 62);
		contentPane.add(txtaddr);
		txtaddr.setColumns(10);
		
		JLabel lblDateofMem = new JLabel("Dateofmembership :");
		lblDateofMem.setForeground(Color.YELLOW);
		lblDateofMem.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblDateofMem.setBounds(660, 210, 207, 20);
		contentPane.add(lblDateofMem);

		 txtdom = new JDateChooser();
		txtdom.setBounds(955, 210, 91, 20);
		contentPane.add(txtdom);
		
		JLabel lblPlanid = new JLabel("Planid :");
		lblPlanid.setForeground(Color.YELLOW);
		lblPlanid.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblPlanid.setBounds(668, 287, 86, 20);
		contentPane.add(lblPlanid);
		
	  planidcomboBox = new JComboBox();
	  planidcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select PlanId"}));
		planidcomboBox.setBounds(955, 285, 118, 28);
		planidcomboBox.addActionListener(this);
		contentPane.add(planidcomboBox);
		
		JLabel lblDateofexpiry = new JLabel("DateofExpiry :");
		lblDateofexpiry.setForeground(Color.YELLOW);
		lblDateofexpiry.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblDateofexpiry.setBounds(661, 369, 180, 19);
		contentPane.add(lblDateofexpiry);

		 txtdoe = new JDateChooser();
			txtdoe.setBounds(955, 368, 91, 20);
			contentPane.add(txtdoe);
			
			JLabel lblGameid_2 = new JLabel("GameId :");
			lblGameid_2.setForeground(Color.YELLOW);
			lblGameid_2.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
			lblGameid_2.setBounds(679, 437, 118, 28);
			contentPane.add(lblGameid_2);
			
			 gameidcomboBox = new JComboBox();
			 gameidcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Game"}));
			gameidcomboBox.setBounds(955, 435, 118, 36);
			gameidcomboBox.addActionListener(this);
			contentPane.add(gameidcomboBox);
			
		JLabel lblOcc = new JLabel("Occupation :");
		lblOcc.setForeground(Color.YELLOW);
		lblOcc.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblOcc.setBounds(679, 528, 131, 35);
		contentPane.add(lblOcc);
		
		txtocc = new JTextField();
		txtocc.setBounds(951, 533, 141, 45);
		contentPane.add(txtocc);
		txtocc.setColumns(10);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select MemberId"}));
		comboBox.setBounds(437, 112, 141, 54);
		comboBox.addActionListener(this);
		contentPane.add(comboBox);
		
		 btnUpdate = new JButton("Update");
		 btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(544, 633, 105, 36);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
	}

	public void populateCombo3()
	{
		String strsql="select memid from members";
		try
		{
			ps=cn.prepareStatement(strsql);//compile query
			rs=ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					String nm=rs.getString("memid");
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
			JOptionPane.showMessageDialog(this, "please select a valid memberId");
		}
		else
		{
			String cid=(String)comboBox.getSelectedItem();
			if(e.getSource()==comboBox)
			{
				String strsql="select memname,email,address,phoneno,dob,occupation,planId,dateofMembership,dateofExpiry,gameId from members where memid=?";
				try 
				{
					ps=cn.prepareStatement(strsql);
					ps.setString(1, cid);
					rs=ps.executeQuery();
					if(rs.next())
					{
						String name=rs.getString("memname");
						String em=rs.getString("email");
						String addr=rs.getString("address");
						long ph=rs.getLong("phoneno");
						Date d1=rs.getDate("dob");
						String occ=rs.getString("occupation");
						String plan=rs.getString("planId");
					    Date d2=rs.getDate("dateofMembership");
					    Date d3=rs.getDate("dateofExpiry");
					    String game=rs.getString("gameId");
						txtem.setText(em);
						txtname.setText(name);
						txtocc.setText(occ);
						txtaddr.setText(addr);
						 planidcomboBox.setSelectedItem(plan);
					     gameidcomboBox.setSelectedItem(game);
						txtph.setText(String.valueOf(ph));
						txtdob.setDate(d1);
						txtdom.setDate(d2);
						txtdoe.setDate(d3);

					}
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
			if(e.getSource()==btnUpdate)
			{
				
				java.util.Date dob=	txtdob.getDate();
				java.util.Date dom=	txtdom.getDate();
				java.util.Date doe=	txtdoe.getDate();
				if(dob==null||dom==null||doe==null)
				{
					//yr message 
				}
				
				
				System.out.println(dob);
				System.out.println(dom);
				System.out.println(doe);
					
				long l=dob.getTime();
				long l1=dom.getTime();
				long l2=doe.getTime();
				System.out.println(l);
				System.out.println(l1);
				System.out.println(l2);
				java.sql.Date sd=new java.sql.Date(l);
				java.sql.Date sd1=new java.sql.Date(l1);
				java.sql.Date sd2=new java.sql.Date(l2);
				System.out.println(sd);
				System.out.println(sd1);
				System.out.println(sd2);
				// TODO Auto-generated method stub
				cn=CrudOperation.createConnection();
				String n=txtname.getText().trim();
				String e1=txtem.getText().trim();
				String p=txtph.getText().trim();
				String add=txtaddr.getText().trim();
				String plani=(String)planidcomboBox.getSelectedItem();
				String gamei=(String)gameidcomboBox.getSelectedItem();
				String oc=txtocc.getText().trim();
				
				if(n.isEmpty()||e1.isEmpty()||p.length()==0||add.isEmpty()||oc.isEmpty()||plani.isEmpty()||gamei.isEmpty() )
				{
					JOptionPane.showMessageDialog(this, "pls enter data");
				}
				else 
				{
					
					if((plani.equalsIgnoreCase("silver")&&(gamei.equals("1")||gamei.equals("2")||gamei.equals("3")||gamei.equals("4")||gamei.equals("5")||gamei.equals("6")||gamei.equals("7")||gamei.equals("8")||gamei.equals("9")))||(plani.equalsIgnoreCase("gold")&&(gamei.equals("1")||gamei.equals("2")||gamei.equals("3")||gamei.equals("4")||gamei.equals("5")||gamei.equals("6")||gamei.equals("7")||gamei.equals("8")||gamei.equals("9")||gamei.equals("10")||gamei.equals("11")||gamei.equals("12")||gamei.equals("13")||gamei.equals("14")||gamei.equals("23")))||(plani.equalsIgnoreCase("platinum")&&(gamei.equals("1")||gamei.equals("2")||gamei.equals("3")||gamei.equals("4")||gamei.equals("5")||gamei.equals("6")||gamei.equals("7")||gamei.equals("8")||gamei.equals("9")||gamei.equals("10")||gamei.equals("11")||gamei.equals("12")||gamei.equals("13")||gamei.equals("14")||gamei.equals("23")||gamei.equals("15")||gamei.equals("16")||gamei.equals("17")||gamei.equals("18")||gamei.equals("19")||gamei.equals("20")||gamei.equals("21")||gamei.equals("22")||gamei.equals("24")))||(plani.equalsIgnoreCase("diamond")&&(gamei.equals("1")||gamei.equals("2")||gamei.equals("3")||gamei.equals("4")||gamei.equals("5")||gamei.equals("6")||gamei.equals("7")||gamei.equals("8")||gamei.equals("9")||gamei.equals("10")||gamei.equals("11")||gamei.equals("12")||gamei.equals("12")||gamei.equals("14")||gamei.equals("15")||gamei.equals("16")||gamei.equals("17")||gamei.equals("18")||gamei.equals("19")||gamei.equals("20")||gamei.equals("21")||gamei.equals("22")||gamei.equals("23")||gamei.equals("24")||gamei.equals("25"))))
					{
				String strupdate="update members set memname=?,email=?,address=?,phoneno=?,dob=?,occupation=?,planId=?,dateofMembership=?,dateofExpiry=?,gameId=? where memid=?";
				try
				{
					ps=cn.prepareStatement(strupdate);
					
					ps.setString(1,n);
					ps.setString(2, e1);
					ps.setString(3, add);
					ps.setLong(4,Long.parseLong(p));
					ps.setDate(5, sd);
					ps.setString(6,oc);
					ps.setString(7,plani);
					ps.setDate(8,sd1);
					ps.setDate(9,sd2);
					ps.setString(10, gamei);
					ps.setString(11,cid);
					int rw=ps.executeUpdate();
					if(rw>0)
					{
						JOptionPane.showMessageDialog(this,"data updated");
	
						txtem.setText("");
						txtname.setText("");
						txtocc.setText("");
						txtaddr.setText("");
						//txtpid.setText("");
						//txtgmid.setText("");
						txtph.setText("");

					}
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
					else
					{
						JOptionPane.showMessageDialog(this, "suitable plan is not selected for that game");
					}
					}
				}
				
		}
	}
	}
