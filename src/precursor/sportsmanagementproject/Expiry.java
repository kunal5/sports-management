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
public class Expiry extends JFrame implements ActionListener {

	private JPanel contentPane;
    private JComboBox comboBox=null;
    private Connection cn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private  Calendar c=null;
    private  Calendar c1=null;
    int option;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Expiry frame = new Expiry();
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
	public Expiry() {
		cn=CrudOperation.createConnection();
		createGui();
		populateCombo();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 779, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select memId"}));
		comboBox.setBounds(286, 76, 130, 55);
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
					
							 
								if(option!=0)
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
								}
							 
						}
			
					