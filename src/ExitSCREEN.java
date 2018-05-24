import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This is GUI class was built as the last window a User would see when exiting the game due to 
 * quitting, finishing or being defeated by the game.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 22nd 2018
 *
 */

public class ExitSCREEN {

	JFrame frame;

	
	/**
	 * Launch the application.
	 * @param args Array of String Arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExitSCREEN window = new ExitSCREEN();
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
	public ExitSCREEN() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Exit Screen");
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblExit = new JLabel("Thank you for playing");
		lblExit.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExit.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblExit.setBounds(385, 332, 299, 33);
		frame.getContentPane().add(lblExit);
	}
	
}
