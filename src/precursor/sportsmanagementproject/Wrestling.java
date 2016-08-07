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

public class Wrestling extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wrestling frame = new Wrestling();
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
	public Wrestling() {
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
		
		JLabel lblWrestlingImg =new JLabel("");
		lblWrestlingImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\wrestling.jpg"));
		lblWrestlingImg.setBounds(197, 11, 1324, 418);
		contentPane.add(lblWrestlingImg);
		
		JLabel lblWrestling = new JLabel("Wrestling");
		lblWrestling.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblWrestling.setBounds(209, 431, 177, 47);
		contentPane.add(lblWrestling);
		
		JTextArea txtWrestling = new JTextArea();
		txtWrestling.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtWrestling.setText("We also also have a huge wrestling arena for our Diamond Plan members who could sweat \r\nout and show their fighting skills ih the arena. We also have 3 Wrestling Trainers.\r\nCharges for Wrestling is Rs5000/- per month.\r\nPeople would also be provided energy drinks after every round.");
		txtWrestling.setBounds(300, 489, 728, 187);
		contentPane.add(txtWrestling);
	}
}
