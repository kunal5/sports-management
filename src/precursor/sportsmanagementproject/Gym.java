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

public class Gym extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gym frame = new Gym();
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
	public Gym() {
		createGui();
	}
	public void createGui()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.CYAN, 6, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGymImg = new JLabel("");
		lblGymImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\body-zone-banner.jpg"));
		lblGymImg.setBounds(10, 11, 1345, 307);
		contentPane.add(lblGymImg);
		
		JLabel lblGym = new JLabel("Gym");
		lblGym.setForeground(Color.BLUE);
		lblGym.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblGym.setBounds(187, 329, 113, 50);
		contentPane.add(lblGym);
		
		JTextArea txtGym = new JTextArea();
		txtGym.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtGym.setText("We have incorporated a well equipped health club for fitness enthusiasts along with\r\n certified trainers who help to maintain a fit and healthy body. We also have facilities like\r\n aerobics, massage, acupressure.\r\nTimings are 06:00AM to 09:00PM\r\nFees for only Gym is 1500/- per month and if you want a instructor to help you out in\r\ndoing execises along with energy drinks then it's cost is Rs. 4000/- per month.\r\n\r\n");
		txtGym.setBounds(298, 409, 728, 226);
		contentPane.add(txtGym);
	}
}
