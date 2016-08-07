package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;

import precursor.dbinfo.CrudOperation;
import java.sql.*;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Addmember extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JTextField txtid;
	private JComboBox gameidcomboBox=null;
	private JComboBox planidcomboBox=null;
	String p,g;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addmember frame = new Addmember();
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
	public Addmember() {
		cn=CrudOperation.createConnection();
	createGui();
	populateCombo();
	populateCombo1();
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
	setTitle("Add Members");
	setResizable(false);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(0, 0,1360,725);
	contentPane = new JPanel();
	contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
	contentPane.setForeground(Color.GRAY);
	contentPane.setBackground(Color.LIGHT_GRAY);
	contentPane.setBorder(new LineBorder(Color.YELLOW, 6));
	contentPane.setLayout(null);
	setContentPane(contentPane);
	
	JLabel lblid = new JLabel("memid");
	lblid.setForeground(Color.YELLOW);
	lblid.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblid.setBounds(22, 29, 74, 36);
	contentPane.add(lblid);
	
	txtid = new JTextField();
	txtid.setBounds(194, 28, 144, 42);
	contentPane.add(txtid);
	txtid.setColumns(10);

	
	JLabel lblName = new JLabel("  Name :");
	lblName.setForeground(Color.YELLOW);
	lblName.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblName.setBounds(10, 92, 86, 20);
	contentPane.add(lblName);
	
	txtname = new JTextField();
	txtname.setBounds(194, 83, 144, 42);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	JLabel lblEmail = new JLabel("Email :");
	lblEmail.setForeground(Color.YELLOW);
	lblEmail.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblEmail.setBounds(26, 177, 86, 20);
	contentPane.add(lblEmail);
	
	txtem = new JTextField();
	txtem.setBounds(194, 168, 144, 42);
	contentPane.add(txtem);
	txtem.setColumns(10);
	
	lblPhone = new JLabel("Phone :");
	lblPhone.setForeground(Color.YELLOW);
	lblPhone.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblPhone.setBounds(22, 263, 72, 20);
	contentPane.add(lblPhone);
	
	txtph = new JTextField();
	txtph.setBounds(194, 254, 144, 42);
	contentPane.add(txtph);
	txtph.setColumns(10);
	

	JLabel lblDob = new JLabel("Dob :");
	lblDob.setForeground(Color.YELLOW);
	lblDob.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblDob.setBounds(26, 345, 86, 20);
	contentPane.add(lblDob);
	
	 txtdob = new JDateChooser();
		txtdob.setBounds(194, 336, 144, 42);
		contentPane.add(txtdob);
		
	JLabel lblAddress = new JLabel("Address :");
	lblAddress.setForeground(Color.YELLOW);
	lblAddress.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblAddress.setBounds(26, 508, 124, 28);
	contentPane.add(lblAddress);
	
	txtaddr = new JTextField();
	txtaddr.setBounds(160, 493, 232, 62);
	contentPane.add(txtaddr);
	txtaddr.setColumns(10);
	
	JLabel lblDateofMem = new JLabel("Dateofmembership :");
	lblDateofMem.setForeground(Color.YELLOW);
	lblDateofMem.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblDateofMem.setBounds(447, 37, 207, 20);
	contentPane.add(lblDateofMem);

	 txtdom = new JDateChooser();
	txtdom.setBounds(687, 24, 145, 36);
	contentPane.add(txtdom);
	
	JLabel lblPlanid = new JLabel("Planid :");
	lblPlanid.setForeground(Color.YELLOW);
	lblPlanid.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblPlanid.setBounds(447, 92, 86, 20);
	contentPane.add(lblPlanid);
	
  planidcomboBox = new JComboBox();
  planidcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select PlanId"}));
	planidcomboBox.setBounds(687, 83, 144, 42);
	planidcomboBox.addActionListener(this);
	contentPane.add(planidcomboBox);
	
	JLabel lblDateofexpiry = new JLabel("DateofExpiry :");
	lblDateofexpiry.setForeground(Color.YELLOW);
	lblDateofexpiry.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblDateofexpiry.setBounds(447, 178, 180, 19);
	contentPane.add(lblDateofexpiry);

	 txtdoe = new JDateChooser();
		txtdoe.setBounds(688, 167, 144, 42);
		contentPane.add(txtdoe);
		
		JLabel lblGameid_2 = new JLabel("GameId :");
		lblGameid_2.setForeground(Color.YELLOW);
		lblGameid_2.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
		lblGameid_2.setBounds(447, 259, 118, 28);
		contentPane.add(lblGameid_2);
		
		 gameidcomboBox = new JComboBox();
		 gameidcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Game"}));
		gameidcomboBox.setBounds(688, 257, 144, 42);
		gameidcomboBox.addActionListener(this);
		contentPane.add(gameidcomboBox);
		
	JLabel lblOcc = new JLabel("Occuptn :");
	lblOcc.setForeground(Color.YELLOW);
	lblOcc.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 18));
	lblOcc.setBounds(447, 345, 105, 20);
	contentPane.add(lblOcc);
	
	txtocc = new JTextField();
	txtocc.setBounds(688, 336, 144, 42);
	contentPane.add(txtocc);
	txtocc.setColumns(10);
	
	 btnSubmit = new JButton("Submit");
	 btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnSubmit.setBounds(458, 589, 119, 42);
	btnSubmit.addActionListener(this);
	contentPane.add(btnSubmit);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSubmit)
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
		String id=txtid.getText().trim();
		String name=txtname.getText().trim();
		String em=txtem.getText().trim();
		String ph=txtph.getText().trim();
		String addr=txtaddr.getText().trim();
		String planid=(String)planidcomboBox.getSelectedItem();
		String gameid=(String)gameidcomboBox.getSelectedItem();
		String occ=txtocc.getText().trim();
		
		if(id.isEmpty()||name.isEmpty()||em.isEmpty()||ph.length()==0||addr.isEmpty()||occ.isEmpty()||planid.isEmpty()||gameid.isEmpty() )
		{
			JOptionPane.showMessageDialog(this, "pls enter data");
		}
		else
		{
			if((planid.equalsIgnoreCase("silver")&&(gameid.equals("hockey_novice")||gameid.equals("hockey_intermediate")||gameid.equals("hockey_proffesional")||gameid.equals("Cricket_novice")||gameid.equals("Cricket_intermediate")||gameid.equals("Cricket_professional")||gameid.equals("Football_novice")||gameid.equals("Football_inter")||gameid.equals("Football_prof")))||(planid.equalsIgnoreCase("gold")&&(gameid.equals("hockey_novice")||gameid.equals("hockey_intermediate")||gameid.equals("hockey_proffesional")||gameid.equals("Cricket_novice")||gameid.equals("Cricket_intermediate")||gameid.equals("Cricket_professional")||gameid.equals("Football_novice")||gameid.equals("Football_inter")||gameid.equals("Football_prof")||gameid.equals("TableTennis")||gameid.equals("Badminton_novice")||gameid.equals("Badminton_inter")||gameid.equals("Badminton_prof")||gameid.equals("Chess")||gameid.equals("Swimming")))||(planid.equalsIgnoreCase("platinum")&&(gameid.equals("hockey_novice")||gameid.equals("hockey_intermediate")||gameid.equals("hockey_proffesional")||gameid.equals("Cricket_novice")||gameid.equals("Cricket_intermediate")||gameid.equals("Cricket_professional")||gameid.equals("Football_novice")||gameid.equals("Football_inter")||gameid.equals("Football_prof")||gameid.equals("TableTennis")||gameid.equals("Badminton_novice")||gameid.equals("Badminton_inter")||gameid.equals("Badminton_prof")||gameid.equals("Chess")||gameid.equals("Swimming")||gameid.equals("Pool_1hr")||gameid.equals("Pool_2hr")||gameid.equals("Pool_3hr")||gameid.equals("Billiards_2members")||gameid.equals("Billiards_3members")||gameid.equals("Billiard_2or3members")||gameid.equals("squash")||gameid.equals("Gym_withoutinstruct")||gameid.equals("Gym_withinstruct")))||(planid.equalsIgnoreCase("diamond")&&(gameid.equals("hockey_novice")||gameid.equals("hockey_intermediate")||gameid.equals("hockey_proffesional")||gameid.equals("Cricket_novice")||gameid.equals("Cricket_intermediate")||gameid.equals("Cricket_professional")||gameid.equals("Football_novice")||gameid.equals("Football_inter")||gameid.equals("Football_prof")||gameid.equals("TableTennis")||gameid.equals("Badminton_novice")||gameid.equals("Badminton_inter")||gameid.equals("Badminton_prof")||gameid.equals("Chess")||gameid.equals("Swimming")||gameid.equals("Pool_1hr")||gameid.equals("Pool_2hr")||gameid.equals("Pool_3hr")||gameid.equals("Billiards_2members")||gameid.equals("Billiards_3members")||gameid.equals("Billiard_2or3members")||gameid.equals("squash")||gameid.equals("Gym_withoutinstruct")||gameid.equals("Gym_withinstruct")||gameid.equals("Wrestling"))))
			{
			String strinsert="insert into members(memid,memname,email,address,phoneno,dob,occupation,planId,dateofMembership,dateofExpiry,gameId) values(?,?,?,?,?,?,?,?,?,?,?)";
		
			try
			{
				ps=cn.prepareStatement(strinsert);
				ps.setString(1,id);
				ps.setString(2,name);
				ps.setString(3, em);
				ps.setString(4, addr);
				ps.setLong(5,Long.parseLong(ph));
				ps.setDate(6, sd);
				ps.setString(7,occ);
				ps.setString(8,planid);
				ps.setDate(9,sd1);
				ps.setDate(10,sd2);
				ps.setString(11, gameid);
				
				int  rw=ps.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this, "data added");
					txtid.setText("");
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