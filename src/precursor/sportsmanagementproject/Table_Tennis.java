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

public class Table_Tennis extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table_Tennis frame = new Table_Tennis();
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
	public Table_Tennis() {
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
		
		JLabel lblTable_TennisImg = new JLabel("");
		lblTable_TennisImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\table-tennis-banner.jpg"));
		lblTable_TennisImg.setBounds(10, 11, 1345, 331);
		contentPane.add(lblTable_TennisImg);
		
		JLabel lblTable_Tennis = new JLabel("Table Tennis");
		lblTable_Tennis.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblTable_Tennis.setBounds(150, 393, 237, 41);
		contentPane.add(lblTable_Tennis);
		
		JTextArea txtTable_Tennis = new JTextArea();
		txtTable_Tennis.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtTable_Tennis.setText(" We also have a well-equipped and air-conditioned table tennis room, with two tables.\r\n\r\nCharges for Table Tennis is Rs3000/- per month");
		txtTable_Tennis.setBounds(290, 450, 728, 226);
		contentPane.add(txtTable_Tennis);
	}
}
