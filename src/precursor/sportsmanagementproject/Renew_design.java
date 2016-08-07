package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;
import precursor.dbinfo.CrudOperation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Renew_design extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtmemid;
	private Connection cn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JDateChooser txtdomr=null;
	private JDateChooser txtdoer=null;
	private JButton btnrenew=null;
	private JComboBox planidcomboBox=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Renew_design frame = new Renew_design();
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
	public Renew_design() 
	{
		cn=CrudOperation.createConnection();
		createGui();
		populateCombo();
	}
	public void createGui()
	{
		setTitle("Renew Details");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemid = new JLabel("memid");
		lblMemid.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		lblMemid.setBounds(50, 159, 111, 38);
		contentPane.add(lblMemid);
		
		txtmemid = new JTextField();
		txtmemid.setBounds(326, 159, 119, 49);
		contentPane.add(txtmemid);
		txtmemid.setColumns(10);
		
		JLabel lblMembersName = new JLabel("plan Id");
		lblMembersName.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		lblMembersName.setBounds(50, 291, 141, 72);
		contentPane.add(lblMembersName);
		
		JLabel lblDateOfMembership = new JLabel("Date of membership renewed");
		lblDateOfMembership.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		lblDateOfMembership.setBounds(550, 148, 253, 65);
		contentPane.add(lblDateOfMembership);
		
		txtdomr = new JDateChooser();
		txtdomr.setBounds(888, 148, 131, 52);
		contentPane.add(txtdomr);
		
		JLabel lblDateOfExpiry = new JLabel("Date of expiry renewed");
		lblDateOfExpiry.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		lblDateOfExpiry.setBounds(561, 291, 253, 83);
		contentPane.add(lblDateOfExpiry);
		
	    txtdoer = new JDateChooser();
		txtdoer.setBounds(888, 309, 131, 57);
		contentPane.add(txtdoer);
		
		 btnrenew = new JButton("Renew");
		 btnrenew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnrenew.setBounds(531, 479, 151, 49);
		btnrenew.addActionListener(this);
		contentPane.add(btnrenew);
		
		planidcomboBox = new JComboBox();
		planidcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select PlanId"}));
		planidcomboBox.setBounds(326, 300, 119, 49);
		contentPane.add(planidcomboBox);
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==btnrenew)
		{
		java.util.Date domr=txtdomr.getDate();
		java.util.Date doer=txtdoer.getDate();
		if(domr==null||doer==null)
		{
			JOptionPane.showMessageDialog(this, "date of membership and date of expiry required");
		}
		
		
		System.out.println(domr);
		System.out.println(doer);
	
		long l1=domr.getTime();
		long l2=doer.getTime();
		System.out.println(l1);
		System.out.println(l2);
		java.sql.Date sd1=new java.sql.Date(l1);
		java.sql.Date sd2=new java.sql.Date(l2);
		System.out.println(sd1);
		System.out.println(sd2);
		String id=txtmemid.getText().trim();
		String planid=(String)planidcomboBox.getSelectedItem();
		
		if(id.isEmpty()||planid.isEmpty()) 
		{
			JOptionPane.showMessageDialog(this, "pls enter data");
		}
		else
		{
			String strinsert="insert into renew(memid,planid,dateofMembership,dateofExpiry) values(?,?,?,?)";
		
			try
			{
				ps=cn.prepareStatement(strinsert);
				ps.setString(1,id);
				ps.setString(2,planid);
				ps.setDate(3,sd1);
				ps.setDate(4,sd2);
				
				int  rw=ps.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this, "data added");
					txtmemid.setText("");
					
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
