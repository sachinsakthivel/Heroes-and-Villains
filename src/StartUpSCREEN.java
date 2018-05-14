import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;

public class StartUpSCREEN {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public StartUpSCREEN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 851, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewGame.setBounds(344, 235, 126, 40);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnQuitGame.setBounds(344, 310, 126, 40);
		frame.getContentPane().add(btnQuitGame);
	}

}
