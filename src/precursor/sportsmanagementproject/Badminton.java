package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Frame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Badminton extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Badminton frame = new Badminton();
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
	public Badminton() {
		setResizable(false);
		createGui();
	}
	public void createGui()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(Color.CYAN, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBadimg = new JLabel("");
		lblBadimg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\badminton-banner.jpg"));
		lblBadimg.setBounds(10, 11, 1324, 433);
		contentPane.add(lblBadimg);
		
		JLabel lblBadminton = new JLabel("Badminton");
		lblBadminton.setForeground(Color.RED);
		lblBadminton.setFont(new Font("Script MT Bold", Font.ITALIC, 25));
		lblBadminton.setBounds(162, 455, 146, 48);
		contentPane.add(lblBadminton);
		
		JTextArea txtbad = new JTextArea();
		txtbad.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtbad.setText("The Badminton Court at Sports Club is not less than a proffessionally prepared court,it is\r\nwell equipped and well lit for evening sessions too. So if you are bitten by a badminton \r\nbug you know where to come!!!!!\r\nNovice Training Rs.1000/- per month\r\nIntermediate Training Rs. 1500/- per month\r\nProfessional Trainig Rs.2500/- per month");
		txtbad.setBounds(311, 520, 741, 156);
		contentPane.add(txtbad);
	}
}
