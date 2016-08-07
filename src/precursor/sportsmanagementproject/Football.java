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

public class Football extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Football frame = new Football();
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
	public Football() {
		createGui();
	}
	public void createGui()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new LineBorder(Color.CYAN, 6, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFootballImg = new JLabel("");
		lblFootballImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\IMG_6754.JPG"));
		lblFootballImg.setBounds(267, 46, 789, 170);
		contentPane.add(lblFootballImg);
		
		JLabel lblFootball = new JLabel("Football");
		lblFootball.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblFootball.setBounds(185, 303, 173, 36);
		contentPane.add(lblFootball);
		
		JTextArea txtFootball = new JTextArea();
		txtFootball.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtFootball.setText("We have a large  field along with two standard size goalpost. We also have 2 coaches.\r\n\r\nPrices are different for different types of training\r\n1)Novice Trainig-1500/- per month\r\n2)Intermediate Training-2500/- per month\r\n3)Proffessional Training-4000/- per month");
		txtFootball.setBounds(298, 373, 728, 156);
		contentPane.add(txtFootball);
	}
}
