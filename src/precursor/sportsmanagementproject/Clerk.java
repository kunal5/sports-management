package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Clerk extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMembership;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clerk frame = new Clerk();
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
	public Clerk() {
		setTitle("Clerk");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0, 1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(Color.YELLOW, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.YELLOW);
		menuBar.setBackground(Color.RED);
		menuBar.setBounds(10, 11, 248, 21);
		contentPane.add(menuBar);
		
		JMenu mnMembers = new JMenu("Members");
		mnMembers.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnMembers);
		
		JMenuItem mntmAddMembers = new JMenuItem("Add Members");
		mntmAddMembers.addActionListener(this);
		mnMembers.add(mntmAddMembers);
		
		JMenuItem mntmUpdateMembers = new JMenuItem("Update Members");
		mntmUpdateMembers.addActionListener(this);
		mnMembers.add(mntmUpdateMembers);
		
		JMenuItem mntmDeleteMembers = new JMenuItem("Delete Members");
		mntmDeleteMembers.addActionListener(this);
		mnMembers.add(mntmDeleteMembers);
		
		JMenu mnWatchMembers = new JMenu("Watch Members");
		mnWatchMembers.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnWatchMembers.setBackground(Color.BLACK);
		menuBar.add(mnWatchMembers);
		
		JMenuItem mntmWatchMembersPlan = new JMenuItem("Watch Members Plan wise");
		mntmWatchMembersPlan.addActionListener(this);
		mnWatchMembers.add(mntmWatchMembersPlan);
		
		JMenuItem mntmWatchMembersGame = new JMenuItem("Watch Members Game wise");
		mntmWatchMembersGame.addActionListener(this);
		mnWatchMembers.add(mntmWatchMembersGame);
		
		 btnMembership = new JButton("Membership Status");
		btnMembership.addActionListener(this);
		btnMembership.setBounds(447, 343, 190, 59);
		contentPane.add(btnMembership);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String caption=e.getActionCommand();
		if(caption.equals("Add Members"))		
		{
			Addmember am=new Addmember();
			am.setVisible(true);
		}
		if(caption.equals("Update Members"))		
		{
			Updatemember um=new Updatemember();
			um.setVisible(true);
		}
		if(caption.equals("Delete Members"))		
		{
			Deletemember dm=new Deletemember();
			dm.setVisible(true);
		}
		
		if(caption.equals("Watch Members Plan wise"))		
		{
			planwiseMembers pwm=new planwiseMembers();
			pwm.setVisible(true);
		}
		if(caption.equals("Watch Members Game wise"))		
		{
			gamewiseMembers gwm=new gamewiseMembers();
			gwm.setVisible(true);
		}
		if(e.getSource()==btnMembership)
		{
			Renew r=new Renew();
			r.setVisible(true);
		}
		
	}
}
