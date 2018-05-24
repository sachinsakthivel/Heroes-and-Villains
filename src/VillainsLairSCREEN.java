import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This Class provides the GUI for the User to either enter the Villin's lair or to go back to 
 * the HomeBase
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 19th 2018
 *
 */

public class VillainsLairSCREEN {

	private JFrame frame;
	/**
	 * GameEnvironment variable to pass data on the current status of the game.
	 */
	private GameEnvironment game;

	
	/**
	 * Create the application.
	 * @param newGame Input variable 'newGame' of type GameEnvironment to pass data on to the 
	 * method of the current state of the game. 
	 */
	public VillainsLairSCREEN(GameEnvironment newGame) {
		game = newGame;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel screenTitle = new JLabel("Villain's Lair");
		screenTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		screenTitle.setBounds(334, 11, 164, 102);
		frame.getContentPane().add(screenTitle);
		
		JButton btnTravelHome = new JButton("Travel Back To Home Base");
		btnTravelHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow(true);
			}
		});
		btnTravelHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTravelHome.setBounds(281, 383, 264, 57);
		frame.getContentPane().add(btnTravelHome);
		
		JButton btnenterLair = new JButton("Enter the Lair");
		btnenterLair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(false);
				game.launchBattleSCREEN();
			}
		});
		btnenterLair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnenterLair.setBounds(281, 301, 264, 57);
		frame.getContentPane().add(btnenterLair);
	}
	
	/**
	 * Closes up the frame and clears up this instance of VillainLairSCREEN
	 */
	public void closeSCREEN() {
		frame.dispose();
	}
	
	/**
	 * This method calls closeVillainLairSCREEN of GameEnvironment class which closes  
	 * the GUI element VillainLairSCREEN currently being displayed. If the Boolean 'toHomeBase' 
	 * is true, the user's Homebase is subjected to a random event. Then the current 
	 * HomeBaseSCREEN is set to visible.
	 */
	public void finishedWindow(boolean toHomeBase) {
		game.closeVillainLairSCREEN(game.getHomeBase(),this, toHomeBase);
	}
	
}
