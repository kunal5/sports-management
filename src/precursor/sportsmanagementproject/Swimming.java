package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Swimming extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swimming frame = new Swimming();
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
	public Swimming() {
		setResizable(false);
		createGui();
	}
	public void createGui()
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1360,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSwimmingImg = new JLabel("");
		lblSwimmingImg.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\aqua-point-banner.jpg"));
		lblSwimmingImg.setBounds(0, 11, 1380, 194);
		contentPane.add(lblSwimmingImg);
		
		JLabel lblSwimming = new JLabel("Swimming");
		lblSwimming.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		lblSwimming.setBounds(10, 166, 116, 24);
		contentPane.add(lblSwimming);
		
		JTextArea txtSwimming = new JTextArea();
		txtSwimming.setBackground(Color.CYAN);
		txtSwimming.setFont(new Font("Script MT Bold", Font.ITALIC, 19));
		txtSwimming.setText("Sports Club houses a huge swimming pool where coaching facilities are provided throughout the year. Not just that, we have smaller swimming pool for children\r\nalong with spring and diving boards respectively.\r\n We also have special trainers.\r\nCharges for Swimming is Rs 4000/- per month");
		txtSwimming.setBounds(50,304, 1235, 226);
		contentPane.add(txtSwimming);
		
		JLabel lblSwimmingPool = new JLabel("Swimming Pool");
		lblSwimmingPool.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 40));
		lblSwimmingPool.setBounds(0, 232, 404, 41);
		contentPane.add(lblSwimmingPool);
	}
}
