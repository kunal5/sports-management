package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;

public class Cricket extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cricket frame = new Cricket();
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
	public Cricket() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
	}
	public void createGui()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1920,1000);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(32820, 32794));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCricket = new JLabel("Cricket");
		lblCricket.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblCricket.setBounds(21, 436, 146, 41);
		contentPane.add(lblCricket);
		
		JTextArea txtcric = new JTextArea();
		txtcric.setBackground(Color.BLUE);
		txtcric.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 19));
		txtcric.setForeground(Color.GREEN);
		txtcric.setText("This is the Cricket Pitch which we have in our club. Our cricketing staff includes\r\n 6 coaches for each department.\r\n\r\nPrices are different for different types of training\r\n1)Novice Trainig-1500/- per month\r\n2)Intermediate Training-2500/- per month\r\n3)Proffessional Training-4000/- per month");
		txtcric.setBounds(0, 474, 718, 181);
		contentPane.add(txtcric);
		
		JTextArea txtcric_2 = new JTextArea();
		txtcric_2.setForeground(Color.GREEN);
		txtcric_2.setBackground(Color.BLUE);
		txtcric_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		txtcric_2.setText("*It is requested to members to bring their respective kit before coming to play");
		txtcric_2.setBounds(0, 651, 554, 22);
		contentPane.add(txtcric_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\cricket-banner.jpg"));
		label.setBounds(0, 11, 1380, 362);
		contentPane.add(label);
	}

}
