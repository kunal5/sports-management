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
public class AddPlan extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private Connection cn=null;
	private PreparedStatement ps=null;
	private JTextField txtcharges;
	private JTextField txtduration;
	private JButton btnFacilities=null;
	private JButton btnadd=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlan frame = new AddPlan();
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
	public AddPlan() {
	createGui();	
	
	}
	public void createGui()
	{
		setTitle("Add Plan");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setIgnoreRepaint(true);
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new LineBorder(Color.GREEN, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("PlanId");
		lblId.setForeground(Color.BLUE);
		lblId.setBackground(Color.ORANGE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblId.setBounds(128, 169, 108, 34);
		contentPane.add(lblId);
		
		txtid = new JTextField();
		txtid.setBounds(413, 179, 108, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblName = new JLabel("Plan Name");
		lblName.setForeground(Color.BLUE);
		lblName.setBackground(Color.RED);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblName.setBounds(128, 265, 108, 34);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(413, 275, 108, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		
		JLabel lblCharges = new JLabel("Charge");
		lblCharges.setForeground(Color.BLUE);
		lblCharges.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblCharges.setBounds(665, 169, 108, 34);
		contentPane.add(lblCharges);
		
		txtcharges = new JTextField();
		txtcharges.setBounds(913, 179, 108, 20);
		contentPane.add(txtcharges);
		txtcharges.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.BLUE);
		lblDuration.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblDuration.setBounds(665, 265, 108, 34);
		contentPane.add(lblDuration);
		
		txtduration = new JTextField();
		txtduration.setBounds(913, 275, 108, 20);
		contentPane.add(txtduration);
		txtduration.setColumns(10);
		
		 btnFacilities = new JButton("Facilities");
		 btnFacilities.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		btnFacilities.setBounds(128, 392, 133, 39);
		btnFacilities.addActionListener(this);
		contentPane.add(btnFacilities);
		
		 btnadd = new JButton("Add Plan");
		 btnadd.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnadd.setForeground(Color.BLACK);
			btnadd.addActionListener(this);
			btnadd.setBounds(517, 490, 108, 34);
			contentPane.add(btnadd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		cn=CrudOperation.createConnection();
		String id=txtid.getText().trim();
		String name=txtname.getText().trim();
		String charges=txtcharges.getText().trim();
		String duration=txtduration.getText().trim();
		if(id.isEmpty()||name.isEmpty()||charges.isEmpty()||duration.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "pls enter data");
		}
		
		else
		{
			if(name.equalsIgnoreCase("Silver"))
			{
				if(e.getSource()==btnFacilities)
				{
				  Facilities f=new Facilities();
				  f.setVisible(true);
				 
				}

			}
			else
				if(name.equalsIgnoreCase("Gold"))
				{
					if(e.getSource()==btnFacilities)
					{
					  Facilities_Gold fg=new Facilities_Gold();
					  fg.setVisible(true);
					 
					}

				}
				else
					if(name.equalsIgnoreCase("Platinum"))
					{
						if(e.getSource()==btnFacilities)
						{
						  Facilities_Platinum  fp=new Facilities_Platinum();
						  fp.setVisible(true);
						 
						}

					}
					else
						if(name.equalsIgnoreCase("Diamond"))
						{
							if(e.getSource()==btnFacilities)
							{
							  Facilities fd=new Facilities();
							  fd.setVisible(true);
							 
							}

						}
			if(e.getSource()==btnadd)
			{
				String strinsert="insert into plans(planid,planname,charge,duration) values(?,?,?,?)";
				
				try
				{
					ps=cn.prepareStatement(strinsert);//compiling query
					ps.setString(1,id);
					ps.setString(2,name);
					ps.setString(3, charges);
					ps.setString(4, duration);
					int  rw=ps.executeUpdate();
					if(rw>0)
					{
						JOptionPane.showMessageDialog(this, "data added");
						txtid.setText("");
						txtname.setText("");
						txtcharges.setText("");
						txtduration.setText("");
						
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
}