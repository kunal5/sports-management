package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;
import com.toedter.calendar.JDateChooser;

import precursor.dbinfo.CrudOperation;

import javax.swing.JButton;

import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
public class gamewiseMembers extends JFrame  implements ActionListener
{

	private JPanel contentPane;

	private JDateChooser dateChooser=null;
	private Connection cn=null;
	private PreparedStatement ps=null;
	
	private ResultSet rs=null;
	private JComboBox comboBox=null;
	JTable jt=null;
	JScrollPane jsp=null;
	
	String[]colname={"memid","memname"};
	Object[][]data=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamewiseMembers frame = new gamewiseMembers();
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
	public gamewiseMembers() {
		cn=CrudOperation.createConnection();
		
		createGui();
		populateCombo();
		
	}
	
	public void createGui()
	
	
	
	{
		
		setTitle("Game wise mrmbers");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1364, 725);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new LineBorder(Color.YELLOW, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(535, 298, 130, 38);
		contentPane.add(btnSubmit);
		
		 comboBox = new JComboBox();
		 comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select GameId"}));
		comboBox.setBounds(535, 131, 130, 56);
		contentPane.add(comboBox);
	}
	public void populateCombo()
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
		comboBox.addItem(p);
				
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
	public void actionPerformed(ActionEvent e)
	
	{
		
	
		fillData();
		
	jt=new JTable(data, colname);
	jsp=new JScrollPane(jt);
	jsp.setBounds(100, 150, 300,300);
	contentPane.add(jsp);
		
		
		
		
	}
	
	public void fillData()
	
	
	{
		
		
		
			int rowcnt=0;
		String strcount="select count(*) from members where gameId=?";
		try{
			
			ps=cn.prepareStatement(strcount);
			ps.setString(1,(String) comboBox.getSelectedItem());
			
			rs=ps.executeQuery();
			
			
			if(rs!=null &&rs.next())
			{
				
				rowcnt=	rs.getInt(1);
				data=new Object[rowcnt][2];//dd arrray create
				
				
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
			
			int row=0;
		String strsql="select memid,memname from members where gameId=?";
		try{
			
			ps=cn.prepareStatement(strsql);
			ps.setString(1, (String) comboBox.getSelectedItem());
			rs=ps.executeQuery();
			if(rs!=null)
			{
			while(rs.next())
			{
				
				data[row][0]=rs.getString("memid");
				data[row][1]=rs.getString("memname");
				row++;
				
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
}
