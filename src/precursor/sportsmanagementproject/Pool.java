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
import java.awt.Rectangle;

public class Pool extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pool frame = new Pool();
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
	public Pool() {
		setBounds(new Rectangle(0, 0, 1360,725));
		createGui();
	}
	public void createGui()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,40,40);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new LineBorder(Color.CYAN, 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPoolImg = new JLabel("");
		lblPoolImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Billiards_table_2.JPG"));
		lblPoolImg.setBounds(158, 11, 1024, 329);
		contentPane.add(lblPoolImg);
		
		JLabel lblPool = new JLabel("Pool");
		lblPool.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblPool.setBounds(180, 344, 123, 39);
		contentPane.add(lblPool);
		
		JTextArea txtPool = new JTextArea();
		txtPool.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtPool.setText("We also have a pool table, so that the people could enjoy this fun game.\r\nIt's charges are as follows:\r\nRs.300/- per person for 1 hour\r\nRs.500/- per person for 2 hours\r\nRs.700/- per person for 3 hours ");
		txtPool.setBounds(284, 406, 728, 226);
		contentPane.add(txtPool);
	}
}
