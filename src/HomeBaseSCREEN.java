import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		game = newGame;
		currentCity = new City(isFinal);
		this.isFinal = isFinal;
		initialize();
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
		btnNorth.setBounds(657, 423, 119, 38);
		frame.getContentPane().add(btnNorth);
		
		JLabel lblhomeBase = new JLabel("Home Base");
		lblhomeBase.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblhomeBase.setBounds(382, 11, 164, 102);
		frame.getContentPane().add(lblhomeBase);
		
		JButton btnTravelSouth = new JButton("Destination: " +currentCity.getplaces().get(3).getName());
		btnTravelSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTravelSouth.setBounds(657, 689, 119, 38);
		frame.getContentPane().add(btnTravelSouth);
		
		JLabel lblNewLabel = new JLabel("This is the Final City: " + isFinal);
		lblNewLabel.setBounds(69, 280, 219, 90);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnWest = new JButton("Travel West");
		btnWest.setBounds(477, 552, 119, 38);
		frame.getContentPane().add(btnWest);
		
		JLabel compass = new JLabel("");
		compass.setIcon(scaleImg("/Images/compass-3057603_960_720.png", 200, 200));
		compass.setBounds(614, 472, 206, 206);
		frame.getContentPane().add(compass);
		
		JButton btnEast = new JButton("Travel East");
		btnEast.setBounds(830, 552, 119, 38);
		frame.getContentPane().add(btnEast);
		
		JButton btnQuitGame = new JButton("QUIT GAME");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnQuitGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuitGame.setBounds(50, 663, 206, 57);
		frame.getContentPane().add(btnQuitGame);
	}
	
	public ImageIcon scaleImg(String ImgFile, Integer width, Integer height) {
		ImageIcon cover = new ImageIcon(HomeBaseSCREEN.class.getResource(ImgFile));
		Image scaleImg = cover.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaleImg);
		return icon;
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeHomeBaseScreen(this);
	}
}
