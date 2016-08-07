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

public class Billiards extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billiards frame = new Billiards();
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
	public Billiards() {
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
		
		JLabel lblBilliardsImg = new JLabel("");
		lblBilliardsImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\billiards-banner.jpg"));
		lblBilliardsImg.setBounds(10, 11, 1324, 394);
		contentPane.add(lblBilliardsImg);
		
		JLabel lblBilliards = new JLabel("Billiards");
		lblBilliards.setForeground(Color.RED);
		lblBilliards.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblBilliards.setBounds(199, 416, 162, 42);
		contentPane.add(lblBilliards);
		
		JTextArea txtbilliards = new JTextArea();
		txtbilliards.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtbilliards.setText("Centrally air-conditioned Billiards room equipped with four Billiards tables\r\nIt's rate is as follows:\r\nRs. 500 for 2hrs (2 members)\r\nRs700 for 3 hrs(3 members)\r\nRs 1000 for 4 hours (2 or 3 members)");
		txtbilliards.setBounds(363, 462, 741, 156);
		contentPane.add(txtbilliards);
	}
}
