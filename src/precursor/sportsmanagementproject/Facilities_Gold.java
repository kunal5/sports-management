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
import javax.swing.JToolBar;
import java.awt.Frame;

public class Facilities_Gold extends JFrame {

	private JPanel contentPane;
	private JTextField txtchargesForSilver;
	private JTextField txttimingForEach;
	private JTextArea txtrmembersOfGold;
	private JTextArea txtrMembersOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facilities_Gold frame = new Facilities_Gold();
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
	public Facilities_Gold() {
		setTitle("Gold Facilities");
		setResizable(false);

		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacilities = new JLabel("Facilities for Gold Plan");
		lblFacilities.setForeground(Color.RED);
		lblFacilities.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblFacilities.setBounds(363, 51, 259, 28);
		contentPane.add(lblFacilities);
		
		txtchargesForSilver = new JTextField();
		txtchargesForSilver.setBackground(Color.PINK);
		txtchargesForSilver.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtchargesForSilver.setText("Charges for Gold plan membership is Rs 2500/- per month excluding games.");
		txtchargesForSilver.setBounds(264, 212, 667, 40);
		contentPane.add(txtchargesForSilver);
		txtchargesForSilver.setColumns(10);
		
		txttimingForEach = new JTextField();
		txttimingForEach.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txttimingForEach.setBackground(Color.BLUE);
		txttimingForEach.setText("Timing of each game for gold plan members is  9:00am to 11:00am");
		txttimingForEach.setBounds(264, 380, 667, 40);
		contentPane.add(txttimingForEach);
		txttimingForEach.setColumns(10);
		
		JTextArea txtrpeopleWhoWill = new JTextArea();
		txtrpeopleWhoWill.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrpeopleWhoWill.setBackground(Color.LIGHT_GRAY);
		txtrpeopleWhoWill.setRows(1);
		txtrpeopleWhoWill.setText("Members of gold plan  can subscribe to more than one game.\r\n");
		txtrpeopleWhoWill.setBounds(264, 463, 667, 40);
		contentPane.add(txtrpeopleWhoWill);
		
		JTextArea txtrApartFromThe = new JTextArea();
		txtrApartFromThe.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrApartFromThe.setBackground(Color.GREEN);
		txtrApartFromThe.setText(" Apart from the games included in Silver Plan some indoor games like Table Tennis, \r\nBadminton and Chess are also availabe in Gold Plan.");
		txtrApartFromThe.setBounds(264, 125, 667, 52);
		contentPane.add(txtrApartFromThe);
		
		txtrmembersOfGold = new JTextArea();
		txtrmembersOfGold.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrmembersOfGold.setBackground(Color.YELLOW);
		txtrmembersOfGold.setText(")Members of Gold Plan would be provided with various energy drinks and soft drinks\r\nduring their playin hours.");
		txtrmembersOfGold.setBounds(264, 289, 667, 51);
		contentPane.add(txtrmembersOfGold);
		
		txtrMembersOf = new JTextArea();
		txtrMembersOf.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrMembersOf.setBackground(Color.MAGENTA);
		txtrMembersOf.setText(" Members of Gold Plan can also enjoy swimming @ Rs. 4000/- per month.");
		txtrMembersOf.setBounds(264, 545, 667, 52);
		contentPane.add(txtrMembersOf);
	}
}
