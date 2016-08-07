package precursor.sportsmanagementproject;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.border.LineBorder;

import precursor.sportsmanagementproject.AddClerk;
import precursor.sportsmanagementproject.UpdateClerk;
import precursor.sportsmanagementproject.DeleteClerk;

import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Admin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton btnClerk=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
	createGui();
	}
public void createGui()
{
	setTitle("Admin");
	setResizable(false);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(0,0,1360,725);
	contentPane = new JPanel();
	contentPane.setBackground(Color.GREEN);
	contentPane.setBorder(new LineBorder(new Color(255, 200, 0), 8, true));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JMenuBar menuBar = new JMenuBar();
	menuBar.setForeground(Color.BLACK);
	menuBar.setBounds(5,5, 445, 42);
	menuBar.setBorder(new LineBorder(Color.CYAN, 5, true));
	menuBar.setBackground(Color.YELLOW);
	contentPane.add(menuBar);
	
	JMenu mnAccount = new JMenu("Clerk's Account");
	mnAccount.setFont(new Font("Segoe UI", Font.BOLD, 14));
	mnAccount.setForeground(Color.BLUE);
	menuBar.add(mnAccount);
	
	JMenuItem mntmcreate = new JMenuItem("Create Account");
	mntmcreate.setForeground(Color.BLUE);
	mntmcreate.addActionListener(this);
	mnAccount.add(mntmcreate);
	JMenuItem mntmupdate = new JMenuItem("Update Account");
	mntmupdate.setForeground(Color.BLUE);
	mntmupdate.addActionListener(this);
	mnAccount.add(mntmupdate);
	
	JMenuItem mntmdelete = new JMenuItem("Delete Account");
	mntmdelete.setForeground(Color.BLUE);
	mntmdelete.addActionListener(this);
	mnAccount.add(mntmdelete);
	
	JMenu mnGames = new JMenu("Games");
	mnGames.setFont(new Font("Segoe UI", Font.BOLD, 14));
	mnGames.setForeground(Color.BLUE);
	menuBar.add(mnGames);
	
	JMenuItem mntmGames = new JMenuItem("Add Games");
	mntmGames.setForeground(Color.BLUE);
	mntmGames.addActionListener(this);
	mnGames.add(mntmGames);
	
	JMenu mnPlans = new JMenu("Plans");
	mnPlans.setFont(new Font("Segoe UI", Font.BOLD, 14));
	mnPlans.setForeground(Color.BLUE);
	menuBar.add(mnPlans);
	
	JMenuItem mntmAdd = new JMenuItem("Add");
	mntmAdd.setForeground(Color.BLUE);
	mntmAdd.addActionListener(this);
	mnPlans.add(mntmAdd);
	
	JMenuItem mntmUpdate = new JMenuItem("Update");
	mntmUpdate.setForeground(Color.BLUE);
	mntmUpdate.addActionListener(this);
	mnPlans.add(mntmUpdate);
	
	JMenuItem mntmDelete = new JMenuItem("Delete");
	mntmDelete.setForeground(Color.BLUE);
	mntmDelete.addActionListener(this);
	mnPlans.add(mntmDelete);
	
	 btnClerk = new JButton("Clerk's Section");
	btnClerk.addActionListener(this);
	btnClerk.setBounds(1033, 11, 122, 36);
	contentPane.add(btnClerk);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\admin.png"));
	label.setBounds(435, 228, 470, 183);
	contentPane.add(label);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		if(caption.equals("Create Account"))		
		{
			AddClerk ac=new AddClerk();
			ac.setVisible(true);
		}
		if(caption.equals("Update Account"))
		{
			UpdateClerk uc=new UpdateClerk();
			uc.setVisible(true);
		}
		if(caption.equals("Delete Account"))
		{
			DeleteClerk dc=new DeleteClerk();
			dc.setVisible(true);
		}
		if(caption.equals("Add"))		
		{
			AddPlan ap=new AddPlan();
			ap.setVisible(true);
		}
		if(caption.equals("Update"))		
		{
           UpdatePlan up=new UpdatePlan();
			up.setVisible(true);
		}
		if(caption.equals("Delete"))		
		{
			DeletePlan dp=new DeletePlan();
			dp.setVisible(true);
		}
		if(caption.equals("Add Games"))		
		{
			AddGame ag=new AddGame();
			ag.setVisible(true);
		}
		if(e.getSource()==btnClerk)
		{
			Clerk c = new Clerk();
			c.setVisible(true);
		}
	}
}
