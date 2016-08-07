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
import javax.swing.JTextPane;
import java.awt.Frame;

public class Facilities_Diamond extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrmembersOfDiamond;
	private JTextArea txtrMembersOf;
	private JTextArea txtrapartFromAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facilities_Diamond frame = new Facilities_Diamond();
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
	public Facilities_Diamond() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Diamond Facilities");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacilities = new JLabel("Facilities for Diamond Plan");
		lblFacilities.setForeground(Color.ORANGE);
		lblFacilities.setToolTipText("");
		lblFacilities.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblFacilities.setBounds(381, 11, 235, 29);
		contentPane.add(lblFacilities);
		
		JTextArea txtrpeopleWhoWill = new JTextArea();
		txtrpeopleWhoWill.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrpeopleWhoWill.setBackground(Color.CYAN);
		txtrpeopleWhoWill.setRows(1);
		txtrpeopleWhoWill.setText("Timing for each game for Diamond plan members is flexible. They can choose the time\r\naccording to their own comfort but before 8:00pm and after 5:00am.");
		txtrpeopleWhoWill.setBounds(246, 430, 687, 77);
		contentPane.add(txtrpeopleWhoWill);
		
		JTextArea txtrApartFromThe = new JTextArea();
		txtrApartFromThe.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrApartFromThe.setBackground(Color.PINK);
		txtrApartFromThe.setText("This is the most luxurious plan of our club.");
		txtrApartFromThe.setBounds(246, 51, 687, 41);
		contentPane.add(txtrApartFromThe);
		
		txtrmembersOfDiamond = new JTextArea();
		txtrmembersOfDiamond.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrmembersOfDiamond.setBackground(Color.YELLOW);
		txtrmembersOfDiamond.setText("There is a huge wrestling arena inside our sports club especially for our Diamond\r\nmembers");
		txtrmembersOfDiamond.setBounds(246, 225, 687, 52);
		contentPane.add(txtrmembersOfDiamond);
		
		txtrMembersOf = new JTextArea();
		txtrMembersOf.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrMembersOf.setBackground(Color.ORANGE);
		txtrMembersOf.setText(" Members of Diamond Plan would also be provided with a well furnished centrally air \r\nconditioned rest room.");
		txtrMembersOf.setBounds(246, 556, 687, 72);
		contentPane.add(txtrMembersOf);
		
		JTextArea txtreachMemberOf = new JTextArea();
		txtreachMemberOf.setBackground(Color.MAGENTA);
		txtreachMemberOf.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtreachMemberOf.setText("Charges for Diamond plan membership is  Rs 7000/- per month excluding games.");
		txtreachMemberOf.setBounds(246, 331, 687, 41);
		contentPane.add(txtreachMemberOf);
		
		txtrapartFromAll = new JTextArea();
		txtrapartFromAll.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrapartFromAll.setBackground(Color.GREEN);
		txtrapartFromAll.setText("Apart from all the games of silver gold and platinum plans it  Polo,Golf,Squash,\r\nArchery and Wrestling.");
		txtrapartFromAll.setBounds(246, 132, 687, 54);
		contentPane.add(txtrapartFromAll);
	}
}
