package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Hockey extends JFrame {

	private JPanel contentPane;
	private JTextField txtHockey_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hockey frame = new Hockey();
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
	public Hockey() {
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
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new LineBorder(Color.CYAN, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHockeyImg = new JLabel("");
		lblHockeyImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Sydney_Olympic_Park_Hockey_Centre.jpg"));
		lblHockeyImg.setBounds(84, 11, 1312, 308);
		contentPane.add(lblHockeyImg);
		
		JLabel lblHockey = new JLabel("Hockey");
		lblHockey.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblHockey.setBounds(41, 354, 144, 60);
		contentPane.add(lblHockey);
		
		JTextArea txtHocket_1 = new JTextArea();
		txtHocket_1.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtHocket_1.setText("We also have a hockey field along with the coaches\r\n\r\nPrices are different for different types of training\r\n1)Novice Trainig-1000/- per month\r\n2)Intermediate Training-1800/- per month\r\n3)Proffessional Training-3000/- per month");
		txtHocket_1.setBounds(165, 425, 635, 153);
		contentPane.add(txtHocket_1);
		
		txtHockey_2 = new JTextField();
		txtHockey_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		txtHockey_2.setText("People are requested to bring their own hockey stick along with a synthetic ball.");
		txtHockey_2.setBounds(209, 634, 562, 39);
		contentPane.add(txtHockey_2);
		txtHockey_2.setColumns(10);
	}
}
