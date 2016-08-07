package precursor.sportsmanagementproject;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import javax.swing.border.LineBorder;

public class Hello extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnLogin;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hello frame = new Hello();
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
	public Hello() {
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheSportsAnd = new JLabel("         SALGAOCAR  \r\n      ");
		lblTheSportsAnd.setFont(new Font("Imprint MT Shadow", Font.BOLD, 26));
		lblTheSportsAnd.setBounds(514, 105, 364, 75);
		contentPane.add(lblTheSportsAnd);
		
		JLabel lblManalisiyalhimachalPradesh = new JLabel("Salgaocar House,Box No-14,Vasco,Goa-403802");
		lblManalisiyalhimachalPradesh.setFont(new Font("Consolas", Font.BOLD, 18));
		lblManalisiyalhimachalPradesh.setBounds(518, 467, 444, 75);
		contentPane.add(lblManalisiyalhimachalPradesh);
		
		JLabel lblSportsClubGoa = new JLabel("       SPORTS CLUB GOA");
		lblSportsClubGoa.setFont(new Font("Imprint MT Shadow", Font.BOLD, 18));
		lblSportsClubGoa.setBounds(579, 402, 299, 40);
		contentPane.add(lblSportsClubGoa);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.RED);
		menuBar.setFont(new Font("Script MT Bold", Font.PLAIN, 12));
		menuBar.setBackground(Color.YELLOW);
		menuBar.setBounds(0, 0, 259, 21);
		contentPane.add(menuBar);
		
		JMenu mnGames = new JMenu("Games");
		menuBar.add(mnGames);
		
		JMenuItem mntmhoc = new JMenuItem("Hockey");
		mntmhoc.addActionListener(this);
		mnGames.add(mntmhoc);
		
		JMenuItem mntmcri = new JMenuItem("Cricket");
		mntmcri.addActionListener(this);
		mnGames.add(mntmcri);
		
		JMenuItem mntmfoot = new JMenuItem("Football");
		mntmfoot.addActionListener(this);
		mnGames.add(mntmfoot);
		
		JMenuItem mntmtt = new JMenuItem("Table Tennis");
		mntmtt.addActionListener(this);
		mnGames.add(mntmtt);
		
		JMenuItem mntmbad = new JMenuItem("Badminton");
		mntmbad.addActionListener(this);
		mnGames.add(mntmbad);
		
		JMenuItem mntmchess = new JMenuItem("Chess");
		mntmchess.addActionListener(this);
		mnGames.add(mntmchess);
		
		JMenuItem mntmpool = new JMenuItem("Pool");
		mntmpool.addActionListener(this);
		mnGames.add(mntmpool);
		
		JMenuItem mntmbill = new JMenuItem("Billiards");
		mntmbill.addActionListener(this);
		mnGames.add(mntmbill);
		
		JMenuItem mntmgym = new JMenuItem("Gym");
		mntmgym.addActionListener(this);
		mnGames.add(mntmgym);
		
		JMenuItem mntmswim = new JMenuItem("Swimming");
		mntmswim.addActionListener(this);
		mnGames.add(mntmswim);
		
		JMenuItem mntmsquash = new JMenuItem("Squash");
		mntmsquash.addActionListener(this);
		mnGames.add(mntmsquash);
		
		JMenuItem mntmwres = new JMenuItem("Wrestling");
		mntmwres.addActionListener(this);
		mnGames.add(mntmwres);
		
		JMenu mnFacilities = new JMenu("Plans");
		menuBar.add(mnFacilities);
		
		JMenuItem mntmsp = new JMenuItem("Silver Plan");
		mntmsp.addActionListener(this);
		mnFacilities.add(mntmsp);
		
		JMenuItem mntmgp = new JMenuItem("Gold Plan");
		mntmgp.addActionListener(this);
		mnFacilities.add(mntmgp);
		
		JMenuItem mntmpp = new JMenuItem("Platinum Plan");
		mntmpp.addActionListener(this);
		mnFacilities.add(mntmpp);
		
		JMenuItem mntmdp = new JMenuItem("Diamond Plan");
		mntmdp.addActionListener(this);
		mnFacilities.add(mntmdp);
		
		JLabel lblforOfficeUse = new JLabel("(for office use only)");
		lblforOfficeUse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblforOfficeUse.setBounds(1242, 90, 108, 14);
		contentPane.add(lblforOfficeUse);
		
	    btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setBackground(Color.CYAN);
	    btnLogin.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogin.setBounds(1250, 15,100,50);
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\virat.jpg"));
		lblNewLabel_2.setBounds(1054, 120, 136, 132);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\images.jpg"));
		lblNewLabel_1.setBounds(252, 133, 204, 107);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\download (1).jpg"));
		lblNewLabel_4.setBounds(292, 361, 164, 127);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\download (2).jpg"));
		lblNewLabel_3.setBounds(1054, 369, 192, 150);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Regent-Club-One-of-the-top-clubs-in-Bangalore-sports-club-in_3.jpg"));
		lblNewLabel.setBounds(549, 213, 326, 156);
		contentPane.add(lblNewLabel);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		if(caption.equals("Hockey"))		
		{
			Hockey h=new Hockey();
			h.setVisible(true);
		}
		if(caption.equals("Cricket"))		
		{
		 Cricket c=new Cricket();
			c.setVisible(true);
		}
		if(caption.equals("Football"))		
		{
		 Football f=new Football();
			f.setVisible(true);
		}
		if(caption.equals("Table Tennis"))		
		{
			Table_Tennis tt=new Table_Tennis();
			tt.setVisible(true);
		}
		if(caption.equals("Badminton"))		
		{
	        Badminton b=new Badminton();
			b.setVisible(true);
		}
		if(caption.equals("Chess"))		
		{
			Chess ch=new Chess();
			ch.setVisible(true);
		}
		if(caption.equals("Pool"))		
		{
		   Pool p=new Pool();
			p.setVisible(true);
		}
		if(caption.equals("Billiards"))		
		{
			Billiards bi=new Billiards();
			bi.setVisible(true);
		}
		if(caption.equals("Gym"))		
		{
			Gym g=new Gym();
			g.setVisible(true);
		}
		if(caption.equals("Swimming"))		
		{
			Swimming s=new Swimming();
			s.setVisible(true);
		}
		
		if(caption.equals("Squash"))		
		{
			Squash sq=new Squash();
			sq.setVisible(true);
		}
		if(caption.equals("Wrestling"))		
		{
			Wrestling w=new Wrestling();
			w.setVisible(true);
		}

		if(caption.equals("Silver Plan"))		
		{
			Facilities fs=new Facilities();
			fs.setVisible(true);
		}

		if(caption.equals("Gold Plan"))		
		{
			Facilities_Gold fg=new Facilities_Gold();
			fg.setVisible(true);
		}
		if(caption.equals("Platinum Plan"))		
		{
			Facilities_Platinum fp=new Facilities_Platinum();
			fp.setVisible(true);
		}
		if(caption.equals("Diamond Plan"))		
		{
			Facilities_Diamond fd=new Facilities_Diamond();
			fd.setVisible(true);
		}

	if (e.getSource()==btnLogin)
	{
		LoginDemo ld=new LoginDemo();
		ld.setVisible(true);
	
	}
	}
}
