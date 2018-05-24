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

/**
 * This Class provides the GUI for the User to start a New Game or Quit Game. This will be the 
 * first window seen by the user when running the game.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 17th 2018
 *
 */

public class StartUpSCREEN {

	JFrame frame;
	/**
	 * GameEnvironment variable to pass data on the current status of the game.
	 */
	private GameEnvironment game;
	
	/**
	 * Create the application.
	 * @param newGame Input variable 'newGame' of type GameEnvironment to pass data on to the 
	 * method of the current state of the game.
	 */
	public StartUpSCREEN(GameEnvironment newGame) {
		initialize();
		game = newGame;
		frame.setVisible(true);
	}
	
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
	
	/**
	 * This method is used to smoothly scale Images
	 * @param ImgFile String variable referring to the location of the Image File
	 * @param width Integer variable referring to the desired scaled width
	 * @param height Integer variable referring to the desired scaled height
	 * @return Returns and ImageIcon that contains the scaled version of the original Image
	 */
	public ImageIcon scaleImg(String ImgFile, Integer width, Integer height) {
		ImageIcon cover = new ImageIcon(StartUpSCREEN.class.getResource(ImgFile));
		Image scaleImage = cover.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaleImage);
		return icon;
	}
	
	/**
	 * Closes up the frame and clears up this instance of StartUpScreen
	 */
	public void closeSCREEN() {
		frame.dispose();
	}
	
	/**
	 * This method calls closeMainScreen of GameEnvironment class which closes the 
	 * StartUpScreen and launches GameSetupSCREEN to start setting up the game.
	 */
	public void finishedWindow() {
		game.closeMainScreen(this);
	}
	
}
