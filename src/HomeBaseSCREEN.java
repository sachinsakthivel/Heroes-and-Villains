import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Component;

public class HomeBaseSCREEN {

	private JFrame frame;
	private City currentCity;
	private GameEnvironment game;
	private boolean  isFinal;
	private JButton btnNorth;
	private JButton btnEast;
	private JButton btnWest;
	private JButton btnSouth;
	
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
		
			JLabel lblhomeBase = new JLabel("Home Base");
		lblhomeBase.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblhomeBase.setBounds(382, 11, 164, 102);
		frame.getContentPane().add(lblhomeBase);
		
		btnNorth = new JButton("Destination: " +currentCity.getplaces().get(0).getName());
		btnNorth.setToolTipText("Travel North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNorth.setBounds(579, 423, 182, 38);
		frame.getContentPane().add(btnNorth);
		
		btnEast = new JButton("Destination: " +currentCity.getplaces().get(1).getName());
		btnEast.setToolTipText("Travel East");
		btnEast.setBounds(785, 555, 182, 38);
		frame.getContentPane().add(btnEast);
		
		btnWest = new JButton("Destination: " +currentCity.getplaces().get(2).getName());
		btnWest.setToolTipText("Travel West");
		btnWest.setBounds(377, 555, 182, 38);
		frame.getContentPane().add(btnWest);
		
		btnSouth = new JButton("Destination: " +currentCity.getplaces().get(3).getName());
		btnSouth.setToolTipText("Travel South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSouth.setBounds(579, 689, 182, 38);
		frame.getContentPane().add(btnSouth);
		
		JLabel lblNewLabel = new JLabel("This is the Final City: " + isFinal);
		lblNewLabel.setBounds(10, 23, 219, 90);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel compass = new JLabel("");
		compass.setIcon(scaleImg("/Images/compass-3057603_960_720.png", 200, 200));
		compass.setBounds(569, 472, 206, 206);
		frame.getContentPane().add(compass);
		
		
		JButton btnQuitGame = new JButton("QUIT GAME");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnQuitGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuitGame.setBounds(10, 684, 206, 57);
		frame.getContentPane().add(btnQuitGame);
		
		JTextArea outputBox = new JTextArea("After the arduous journey to the Home Base of the City; the Heroes rested their minds and bodies.\r\n\r\nAfter being fully rested, the Heroes are ready for a new challenge! What would you like to do?");
		outputBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		outputBox.setWrapStyleWord(true);
		outputBox.setLineWrap(true);
		outputBox.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		outputBox.setBounds(321, 124, 624, 246);
		frame.getContentPane().add(outputBox);
		
		JButton btnNewButton = new JButton("Use a Map");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output  = currentCity.useMap(game.getTeam());
				btnNorth.setText(currentCity.getplaces().get(0).getName());
				btnEast.setText(currentCity.getplaces().get(1).getName());
				btnWest.setText(currentCity.getplaces().get(2).getName());
				btnSouth.setText(currentCity.getplaces().get(3).getName());
				outputBox.setText(output);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(31, 124, 266, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCheckTeamStatus = new JButton("Check Team Status");
		btnCheckTeamStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheckTeamStatus.setBounds(31, 225, 266, 43);
		frame.getContentPane().add(btnCheckTeamStatus);
		
		JButton btnUseAHeros = new JButton("Use a Hero's Ability");
		btnUseAHeros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUseAHeros.setBounds(31, 327, 266, 43);
		frame.getContentPane().add(btnUseAHeros);
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
