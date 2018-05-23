
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
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class HomeBaseSCREEN {

	private JFrame frame;
	private City currentCity;
	private GameEnvironment game;
	private boolean  isFinal;
	private JButton btnNorth;
	private JButton btnEast;
	private JButton btnWest;
	private JButton btnSouth;
	private JTextArea outputBox;

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
		this.isFinal = isFinal;
		currentCity = new City(isFinal);
		game.setCityNum(game.getCityNum() -1);
		game.setCurrentCity(currentCity);
		if (game.getParty().typeCheck("Path Finder")) {
			for (Locations place: game.getCurrentCity().getplaces()) {
				place.travelledto();
			}
		}
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
		
		btnNorth = new JButton(currentCity.getplaces().get(0).getName());
		btnNorth.setToolTipText("Travel North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentCity.getplaces().get(0).travel(game);
			}
		});
		btnNorth.setBounds(555, 423, 182, 38);
		frame.getContentPane().add(btnNorth);
		
		btnEast = new JButton(currentCity.getplaces().get(1).getName());
		btnEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentCity.getplaces().get(1).travel(game);
			}
		});
		btnEast.setToolTipText("Travel East");
		btnEast.setBounds(766, 555, 182, 38);
		frame.getContentPane().add(btnEast);
		
		btnWest = new JButton(currentCity.getplaces().get(2).getName());
		btnWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentCity.getplaces().get(2).travel(game);
			}
		});
		btnWest.setToolTipText("Travel West");
		btnWest.setBounds(364, 555, 182, 38);
		frame.getContentPane().add(btnWest);
		
		btnSouth = new JButton(currentCity.getplaces().get(3).getName());
		btnSouth.setToolTipText("Travel South");
		btnSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentCity.getplaces().get(3).travel(game);
			}
		});
		btnSouth.setBounds(565, 689, 182, 38);
		frame.getContentPane().add(btnSouth);
		
		JLabel compass = new JLabel("");
		compass.setIcon(scaleImg("/Images/compass-3057603_960_720.png", 200, 200));
		compass.setBounds(555, 472, 206, 206);
		frame.getContentPane().add(compass);
		
		
		JButton btnQuitGame = new JButton("QUIT GAME");
		btnQuitGame.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				runAgain();
			}
		});
		btnQuitGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuitGame.setBounds(10, 684, 206, 57);
		frame.getContentPane().add(btnQuitGame);
		
		outputBox = new JTextArea("After the arduous journey to the Home Base of the City; the Heroes rested their minds and bodies.\r\n\r\nAs the Sun rose, the Heroes are ready for a new challenge! What would you like to do?");
		outputBox.setMargin(new Insets(10, 10, 10, 10));
		outputBox.setEditable(false);
		outputBox.setWrapStyleWord(true);
		outputBox.setLineWrap(true);
		outputBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		outputBox.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		outputBox.setBounds(249, 99, 608, 246);
		frame.getContentPane().add(outputBox);
		
		JButton btnNewButton = new JButton("Use a Map");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output  = currentCity.useMap(game.getParty());
				updateButton();
				outputBox.setText(output);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(31, 124, 266, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCheckTeamStatus = new JButton("Check Team Status");
		btnCheckTeamStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputBox.setText(game.getParty().toString());
			}
		});
		btnCheckTeamStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheckTeamStatus.setBounds(31, 225, 266, 43);
		frame.getContentPane().add(btnCheckTeamStatus);
		
		JButton btnUseAHeros = new JButton("Use a Hero's Ability");
		btnUseAHeros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUseAHeros.setBounds(31, 327, 266, 43);
		frame.getContentPane().add(btnUseAHeros);
		
		JScrollPane textPlane = new JScrollPane(outputBox);
		textPlane.setAutoscrolls(true);
		textPlane.setBounds(new Rectangle(318, 124, 630, 246));
		frame.getContentPane().add(textPlane);
	}
	
	public ImageIcon scaleImg(String ImgFile, Integer width, Integer height) {
		ImageIcon cover = new ImageIcon(HomeBaseSCREEN.class.getResource(ImgFile));
		Image scaleImg = cover.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaleImg);
		return icon;
	}
	
	public void runAgain() {
		if (game.getCityNum() > 1) {
			game.launchHomeBaseSCREEN(false);
		} else if (game.getCityNum() == 1) {
			game.launchHomeBaseSCREEN(true);
		}
	}
	
	public void updateButton() {
		btnNorth.setText(currentCity.getplaces().get(0).getName());
		btnEast.setText(currentCity.getplaces().get(1).getName());
		btnWest.setText(currentCity.getplaces().get(2).getName());
		btnSouth.setText(currentCity.getplaces().get(3).getName());
	}
	
	public void randomEvents() {
		outputBox.setText(game.getCurrentCity().randomEvent(game.getParty()));
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeHomeBaseSCREEN(this);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
