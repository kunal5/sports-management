package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;
import precursor.dbinfo.CrudOperation;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;
public class Renew extends JFrame implements ActionListener {

	private JPanel contentPane;
    private JComboBox comboBox=null;
    private Connection cn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private  Calendar c=null;
    private  Calendar c1=null;
    int option,option1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Renew frame = new Renew();
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
	public Renew() {
		cn=CrudOperation.createConnection();
		createGui();
		populateCombo();
	}
	public void createGui()
	{
		setTitle("Check Membership");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 comboBox = new JComboBox();
		 comboBox.setFont(new Font("Script MT Bold", Font.BOLD, 20));
		 comboBox.setForeground(Color.BLUE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select memId"}));
		comboBox.setBounds(502, 192, 183, 55);
		comboBox.addActionListener(this);
		contentPane.add(comboBox);
	}
	public void populateCombo()
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 int index=comboBox.getSelectedIndex();
			if(index==0)
			{
				JOptionPane.showMessageDialog(this, "please select a valid id");
			}
			else
			{
				String cid=(String)comboBox.getSelectedItem();
					String strsql="select dateofExpiry from members where memid=?";
					try 
					{
						ps=cn.prepareStatement(strsql);
						ps.setString(1, cid);
						rs=ps.executeQuery();
						if(rs.next())
						{	
							 Date d=rs.getDate("dateofExpiry");
							 System.out.println(d);
							 long l = d.getTime();
							 java.sql.Date sd=new java.sql.Date(l);
							 Calendar c=Calendar.getInstance();
							 Calendar c1=Calendar.getInstance();
							  c1.setTimeInMillis(l);
							  if(c1.compareTo(c)<0)
							  {
								  System.out.println("Expiry");
					 option=JOptionPane.showConfirmDialog(this,"Membership has expired. Do you want delete this member from database?");
					 
						}
							  else
							  {
								  JOptionPane.showMessageDialog(this, "Member isn't expired");
								  option=3;
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
							
							
						}
						catch(SQLException se)
						{
							
							System.out.println(se);
						}
					
						
					}
			}
			System.out.println(option);
					
							 
								if(option==0)
								{
									
								String nm=(String)comboBox.getSelectedItem();
								//System.out.println(nm);
								String strdelete="delete from members where memid=?";
									try{
									ps=cn.prepareStatement(strdelete);
									ps.setString(1, nm);
									int rw=	ps.executeUpdate();//
									if(rw>0)
									{
							JOptionPane.showMessageDialog(this, "member gets deleted","deletion",JOptionPane.ERROR_MESSAGE);
									comboBox.removeAllItems();
									comboBox.addItem("Select memId");
									populateCombo();
							
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
											
											
										}
										catch(SQLException se)
										{
											
											System.out.println(se);
										}
										
										
									}
									
								}
								else
								{
									if(option==1)
									{
										 option1=JOptionPane.showConfirmDialog(this,"Do you want to renew the membership?");
										 if(option1==0)
										 {
											 Renew_design r=new Renew_design();
											 r.setVisible(true);
										 }
									}
								}
								}
							 
						}
			
					