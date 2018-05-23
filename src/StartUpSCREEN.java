import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartUpSCREEN {

	JFrame frame;
	
	/**
	 * Create the application.
	 */
	
	private GameEnvironment game;
	
	public StartUpSCREEN(GameEnvironment newGame) {
		initialize();
		game = newGame;
		frame.setVisible(true);
	}
	

	
	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUpSCREEN window = new StartUpSCREEN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("StartUpTest");
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSengAssignmentSimulator = new JLabel("SENG201 ASSIGNMENT SIMULATOR");
		lblSengAssignmentSimulator.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSengAssignmentSimulator.setBackground(Color.WHITE);
		lblSengAssignmentSimulator.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblSengAssignmentSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblSengAssignmentSimulator.setBounds(203, 10, 556, 82);
		frame.getContentPane().add(lblSengAssignmentSimulator);
		
		JButton btnNewGame = new JButton("NEW GAME");
		btnNewGame.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 finishedWindow();
			}
		});
		btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewGame.setToolTipText("Start a new game");
		btnNewGame.setForeground(Color.BLACK);
		btnNewGame.setBackground(Color.LIGHT_GRAY);
		btnNewGame.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnNewGame.setBounds(768, 535, 175, 60);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnNewButton =  new JButton("QUIT GAME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.launchExitSCREEN();
				closeSCREEN();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("Exit the game.");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnNewButton.setBounds(768, 643, 175, 60);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartUpSCREEN.class.getResource("/Images/startupbkg.jpg")));
		label.setBounds(0, 0, 968, 755);
		frame.getContentPane().add(label);
	}
	
	public ImageIcon scaleImg(String ImgFile, Integer width, Integer height) {
		ImageIcon cover = new ImageIcon(StartUpSCREEN.class.getResource(ImgFile));
		Image scaleImage = cover.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaleImage);
		return icon;
	}
	
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeMainScreen(this);
	}
	
}
