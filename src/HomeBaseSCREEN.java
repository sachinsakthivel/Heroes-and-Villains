import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class HomeBaseSCREEN {

	private JFrame frame;
	private City currentCity;
	private GameEnvironment game;
	private boolean  isFinal;
	
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
		this.isFinal = isFinal;
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
		
		JLabel lblNewLabel = new JLabel("This is the Final City: " + isFinal);
		lblNewLabel.setBounds(10, 651, 148, 90);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("Travel North");
		button.setBounds(142, 456, 119, 38);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(HomeBaseSCREEN.class.getResource("/Images/compass-3057603_960_720.png")));
		lblNewLabel_1.setBounds(55, 193, 762, 443);
		frame.getContentPane().add(lblNewLabel_1);
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
