import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VillainsLairSCREEN {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VillainsLairSCREEN window = new VillainsLairSCREEN();
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
	public VillainsLairSCREEN(GameEnvironment newGame) {
		game = newGame;
		initialize();
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
		btnTravelHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTravelHome.setBounds(10, 508, 264, 57);
		frame.getContentPane().add(btnTravelHome);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeVillainLairSCREEN(this);
	}
}
