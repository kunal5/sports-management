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

public class Facilities_Platinum extends JFrame {

	private JPanel contentPane;
	private JTextField txtchargesForSilver;
	private JTextArea txtrmembersOfPlatinum;
	private JTextArea txtrMembersOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facilities_Platinum frame = new Facilities_Platinum();
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
	public Facilities_Platinum() {
		setTitle("Platinum Facilities");
		setResizable(false);

		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1360, 725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacilities = new JLabel("Facilities for Platinum Plan");
		lblFacilities.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblFacilities.setBounds(472, 25, 290, 28);
		contentPane.add(lblFacilities);
		
		txtchargesForSilver = new JTextField();
		txtchargesForSilver.setBackground(Color.YELLOW);
		txtchargesForSilver.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtchargesForSilver.setText("Charges for Platinum plan membership  Rs 4000/- per month excluding games.");
		txtchargesForSilver.setBounds(291, 157, 687, 40);
		contentPane.add(txtchargesForSilver);
		txtchargesForSilver.setColumns(10);
		
		JTextArea txtrpeopleWhoWill = new JTextArea();
		txtrpeopleWhoWill.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrpeopleWhoWill.setBackground(Color.ORANGE);
		txtrpeopleWhoWill.setRows(1);
		txtrpeopleWhoWill.setText("Timing for each game for Platinum plan members is  6:00am to 9:00am");
		txtrpeopleWhoWill.setBounds(291, 420, 687, 52);
		contentPane.add(txtrpeopleWhoWill);
		
		JTextArea txtrApartFromThe = new JTextArea();
		txtrApartFromThe.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrApartFromThe.setBackground(Color.GRAY);
		txtrApartFromThe.setText(" Apart from the games included in Silver and Gold Plan pool,billiards,squash are also \r\navailable in Platinum Plan.\r\n");
		txtrApartFromThe.setBounds(291, 80, 687, 52);
		contentPane.add(txtrApartFromThe);
		
		txtrmembersOfPlatinum = new JTextArea();
		txtrmembersOfPlatinum.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrmembersOfPlatinum.setBackground(Color.CYAN);
		txtrmembersOfPlatinum.setText("Members of Platinum Plan also have a facility of gym @ Rs 3000/-per month.\r\n");
		txtrmembersOfPlatinum.setBounds(291, 230, 687, 52);
		contentPane.add(txtrmembersOfPlatinum);
		
		txtrMembersOf = new JTextArea();
		txtrMembersOf.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtrMembersOf.setBackground(Color.GREEN);
		txtrMembersOf.setText("  Members of Platinum Plan would also be provided one time meal.");
		txtrMembersOf.setBounds(291, 511, 687, 61);
		contentPane.add(txtrMembersOf);
		
		JTextArea txtreachMemberOf = new JTextArea();
		txtreachMemberOf.setBackground(Color.PINK);
		txtreachMemberOf.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtreachMemberOf.setText("Each member of Platinum Plan would also be provided a personal gym instructor who\r\nwould take care of their diet.");
		txtreachMemberOf.setBounds(291, 315, 687, 66);
		contentPane.add(txtreachMemberOf);
	}
}
