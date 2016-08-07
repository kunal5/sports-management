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

public class Chess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chess frame = new Chess();
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
	public Chess() {
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
		
		JLabel lblChessImg = new JLabel("");
		lblChessImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\8508870-Chess-game-battle-ready-for-play-on-wood-chess-board-Stock-Photo.jpg"));
		lblChessImg.setBounds(21, 11, 1313, 455);
		contentPane.add(lblChessImg);
		
		JLabel lblChess = new JLabel("Chess");
		lblChess.setForeground(Color.RED);
		lblChess.setFont(new Font("Script MT Bold", Font.ITALIC, 40));
		lblChess.setBounds(98, 513, 106, 44);
		contentPane.add(lblChess);
		
		JTextArea txtChess = new JTextArea();
		txtChess.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtChess.setText("Chess rates are Rs. 750/- per month");
		txtChess.setBounds(284, 545, 502, 54);
		contentPane.add(txtChess);
	}
}
