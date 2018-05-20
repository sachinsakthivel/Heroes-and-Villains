import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class HomeBaseSCREEN {

	private JFrame frame;
	private City currentCity;
	private GameEnvironment game;
	
	private static String DisplayText;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeBaseSCREEN window = new HomeBaseSCREEN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public HomeBaseSCREEN(GameEnvironment newGame, boolean isFinal) {
		initialize();
		game = newGame;
		currentCity = new City(isFinal);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNorth = new JButton("Travel North");
		btnNorth.setBounds(403, 300, 119, 38);
		frame.getContentPane().add(btnNorth);
		
		JLabel lblhomeBase = new JLabel("Home Base");
		lblhomeBase.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblhomeBase.setBounds(382, 11, 164, 102);
		frame.getContentPane().add(lblhomeBase);
		
		JButton btnTravelSouth = new JButton("Destination: ");
		btnTravelSouth.setBounds(403, 611, 119, 38);
		frame.getContentPane().add(btnTravelSouth);
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                          
	public String getDisplayText(){
		return DisplayText;
	}
	
	public static void setDisplayText(String NewDisplayText) {
		DisplayText = NewDisplayText; 
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeHomeBaseScreen(this);
	}
}
