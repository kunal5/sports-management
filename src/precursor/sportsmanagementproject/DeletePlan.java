package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import precursor.dbinfo.CrudOperation;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class DeletePlan extends JFrame implements ActionListener
{
	private Connection cn=null;
	private  PreparedStatement ps=null;
	private ResultSet rs=null;

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePlan frame = new DeletePlan();
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
	public DeletePlan() 
	{
		cn=CrudOperation.createConnection();
		
		createGui();
		populateCombo();
		
		
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
				
			String nm=rs.getString("planid");	
			comboBox.addItem(nm);
				
					
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
		setTitle("Delete Plan");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new LineBorder(Color.YELLOW, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setForeground(Color.MAGENTA);
		comboBox.setBackground(Color.ORANGE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select  Plan Id"}));
		comboBox.setBounds(551, 195, 157, 32);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(this);
		
		btnNewButton.setBounds(581, 396, 108, 40);
		contentPane.add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
			
	int option=	JOptionPane.showConfirmDialog(this, "are u sure");
	System.out.println(option);
			if(option==0)
			{
				
			String nm=(String)comboBox.getSelectedItem();
			//System.out.println(nm);
			String strdelete="delete from plans where planid=?";
				try{
				ps=cn.prepareStatement(strdelete);
				ps.setString(1, nm);
				int rw=	ps.executeUpdate();
				if(rw>0)
				{
		JOptionPane.showMessageDialog(this, "plan gets deleted","deletion",JOptionPane.ERROR_MESSAGE);
				comboBox.removeAllItems();
				comboBox.addItem("Select PlanId");
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
