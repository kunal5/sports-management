package precursor.sportsmanagementproject;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

import precursor.dbinfo.CrudOperation;
public class AddGame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtgame;
	 private JTextField txtcharge;
	private Connection cn=null;
	private PreparedStatement ps=null;
    private JButton btngame=null;
    private JTextField txtgameId;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGame frame = new AddGame();
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
	public AddGame() {
		createGui();
			}
public void createGui()
{
	setTitle("Add Game");
	setResizable(false);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(0, 0,1360,725);
	contentPane = new JPanel();
	contentPane.setBackground(Color.CYAN);
	contentPane.setIgnoreRepaint(true);
	contentPane.setForeground(Color.RED);
	contentPane.setBorder(new LineBorder(Color.RED, 6));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblGame = new JLabel("GAME");
	lblGame.setForeground(Color.BLACK);
	lblGame.setBackground(Color.ORANGE);
	lblGame.setFont(new Font("Times New Roman", Font.BOLD, 19));
	lblGame.setBounds(378, 172, 108, 34);
	contentPane.add(lblGame);
	
	txtgame = new JTextField();
	txtgame.setBounds(651, 170, 108, 45);
	contentPane.add(txtgame);
	txtgame.setColumns(10);
	
	JLabel lblCharges = new JLabel("CHARGES");
	lblCharges.setForeground(Color.BLACK);
	lblCharges.setFont(new Font("Times New Roman", Font.BOLD, 19));
	lblCharges.setBounds(378, 295, 108, 34);
	contentPane.add(lblCharges);
	
	txtcharge = new JTextField();
	txtcharge.setBounds(651, 293, 108, 45);
	contentPane.add(txtcharge);
	txtcharge.setColumns(10);

	 btngame = new JButton("Add Game");
	 btngame.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btngame.setBounds(582, 438, 108, 34);
	btngame.addActionListener(this);
	contentPane.add(btngame);
	
	JLabel lblGameId = new JLabel("Game Id");
	lblGameId.setFont(new Font("Times New Roman", Font.BOLD, 19));
	lblGameId.setBounds(378, 74, 108, 34);
	contentPane.add(lblGameId);
	
	txtgameId = new JTextField();
	txtgameId.setBounds(651, 74, 108, 45);
	contentPane.add(txtgameId);
	txtgameId.setColumns(10);
	
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		cn=CrudOperation.createConnection();
		String gameid=txtgameId.getText().trim();
		String game=txtgame.getText().trim();
		String charge=txtcharge.getText().trim();
		if(gameid.isEmpty()||game.isEmpty()||charge.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "pls enter a game to be added");
		}
		else
		{
			String strinsert="insert into games(gameid,gamename,charges) values(?,?,?)";
		
			try
			{
				ps=cn.prepareStatement(strinsert);//compiling query
				ps.setString(1,gameid);
				ps.setString(2,game);
				ps.setInt(3,Integer.parseInt(charge));
				int  rw=ps.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this, "game added");
					txtgame.setText("");
					txtcharge.setText("");
					
				}
	
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
			finally
			{
				if(ps!=null)
				{
					try{
						ps.close();
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					if(cn!=null)
					{
						try
						{
							cn.close();
						}
						catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
				}
				
			}
		}
	}
}
