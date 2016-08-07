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

public class Squash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Squash frame = new Squash();
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
	public Squash() {
		createGui();
	}
	public void createGui()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new LineBorder(Color.CYAN, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSquashImg = new JLabel("");
		lblSquashImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\squash (2).jpg"));
		lblSquashImg.setBounds(10, 11, 1334, 427);
		contentPane.add(lblSquashImg);
		
		JLabel lblSquash = new JLabel("Squash");
		lblSquash.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblSquash.setBounds(178, 402, 138, 36);
		contentPane.add(lblSquash);
		
		JTextArea txtSquash = new JTextArea();
		txtSquash.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtSquash.setText("We also have a huge four-walled room for squash. It's a fun game only for Platinum Plan\r\nmembers.\r\nIts charges are Rs.3000/- per month");
		txtSquash.setBounds(302, 450, 728, 226);
		contentPane.add(txtSquash);
	}
}
