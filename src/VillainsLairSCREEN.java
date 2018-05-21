import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				finishedWindow();
			}
		});
		btnTravelHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTravelHome.setBounds(281, 383, 264, 57);
		frame.getContentPane().add(btnTravelHome);
		
		JButton btnenterLair = new JButton("Enter the Lair");
		btnenterLair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnenterLair.setBounds(281, 301, 264, 57);
		frame.getContentPane().add(btnenterLair);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeVillainLairSCREEN(game.getHomeBase(),this);
	}
}
