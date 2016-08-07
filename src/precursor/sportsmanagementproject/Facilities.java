package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;

public class Facilities extends JFrame {

	private JPanel contentPane;
	private JTextField txtgamesIncludedIn;
	private JTextField txtchargesForSilver;
	private JTextField txttimingForEach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facilities frame = new Facilities();
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
	public Facilities() {
		setTitle("Silver Facilities");
		setResizable(false);

		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacilities = new JLabel("Facilities for Silver Plan");
		lblFacilities.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblFacilities.setBounds(475, 11, 211, 29);
		contentPane.add(lblFacilities);
		
		txtgamesIncludedIn = new JTextField();
		txtgamesIncludedIn.setFont(new Font("Script MT Bold", Font.PLAIN, 19));
		txtgamesIncludedIn.setBackground(Color.GREEN);
		txtgamesIncludedIn.setText("Games included in Silver Plan are Cricket,Hockey and Footaball.");
		txtgamesIncludedIn.setBounds(336, 118, 646, 40);
		contentPane.add(txtgamesIncludedIn);
		txtgamesIncludedIn.setColumns(10);
		
		txtchargesForSilver = new JTextField();
		txtchargesForSilver.setBackground(Color.ORANGE);
		txtchargesForSilver.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtchargesForSilver.setText("Charges for silver plan membership is Rs 1500/- per month excluding games.");
		txtchargesForSilver.setBounds(336, 201, 646, 40);
		contentPane.add(txtchargesForSilver);
		txtchargesForSilver.setColumns(10);
		
		txttimingForEach = new JTextField();
		txttimingForEach.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txttimingForEach.setBackground(Color.MAGENTA);
		txttimingForEach.setText("Timing for each game for silver plan members is from 11:00am to 12:00pm");
		txttimingForEach.setBounds(336, 282, 646, 40);
		contentPane.add(txttimingForEach);
		txttimingForEach.setColumns(10);
		
		JTextArea txtrpeopleWhoWill = new JTextArea();
		txtrpeopleWhoWill.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrpeopleWhoWill.setBackground(Color.YELLOW);
		txtrpeopleWhoWill.setRows(1);
		txtrpeopleWhoWill.setText("People who take the mebership in silver plan would be allowed to play only\r\none game. If the member wants to play another game then he/she would have to\r\n change the current game of which they are a part of right now. ");
		txtrpeopleWhoWill.setBounds(336, 353, 646, 92);
		contentPane.add(txtrpeopleWhoWill);
		
		JTextArea txtrIfA = new JTextArea();
		txtrIfA.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrIfA.setBackground(Color.PINK);
		txtrIfA.setText(" If a person wants to play more than one game then he/she would have to \r\nsubscribe to any other plan. ");
		txtrIfA.setBounds(336, 477, 636, 57);
		contentPane.add(txtrIfA);
	}
}
