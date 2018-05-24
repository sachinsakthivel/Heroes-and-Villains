import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Point;
import java.awt.Insets;

/**
 * This Class provides the GUI for the User setup the Team by inputing Hero Names 
 * and Hero Types for each Hero in the Team.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 18th 2018
 *
 */

public class HeroSetupSCREEN {
	
	JFrame frame;
	private JTextField textField;
	/**
	 * GameEnvironment variable to pass data on the current status of the game.
	 */
	private GameEnvironment game;
	/**
	 * Variable 'heroName' of Type String refers to User's preferred Hero Name for 
	 * the Hero in Creation.
	 */
	private String heroName = "";
	/**
	 * Variable 'typePick' of Type Integer refers to User's preferred Hero Type for 
	 * the Hero in Creation.
	 */
	private int typePick = -1;


	/**
	 * Getter for frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	 
	/**
	 * setter for frame
	 * @param newframe Varaible 'newframe' of type Jframe
	 */
	public void setFrame(JFrame newframe)  {
		frame = newframe;
	}
	

	/**
	 * Create the application.
	 * @param newGame Input variable 'newGame' of type GameEnvironment to pass data on to the 
	 * method of the current state of the game.
	 */
	public HeroSetupSCREEN(GameEnvironment newGame) {
		initialize();
		game = newGame;
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frames.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setDisabledTextColor(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setToolTipText("Enter a team name");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(299, 118, 388, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblType = new JLabel("Hero Types");
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblType.setBounds(406, 200, 132, 33);
		frame.getContentPane().add(lblType);
		
		JLabel lblTeam = new JLabel("Hero Name:");
		lblTeam.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblTeam.setBounds(160, 126, 136, 33);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblerror = new JLabel("Incorrect Input, Please Select A Hero Type");
		lblerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror.setHorizontalTextPosition(SwingConstants.CENTER);
		lblerror.setForeground(Color.RED);
		lblerror.setVisible(false);
		lblerror.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblerror.setBounds(225, 628, 539, 40);
		frame.getContentPane().add(lblerror);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heroName = textField.getText();
				if (heroName.length() < 1) {
					lblerror.setText("Please Enter a Hero Name");
					lblerror.setVisible(true);
				} else if (typePick == -1) {
					lblerror.setText("Incorrect Input, Please Select A Hero Type");
					lblerror.setVisible(true);
				} else if (game.getParty().nameCheck(heroName)) {
					lblerror.setText("Hero Name is already taken. Enter another Name");
					lblerror.setVisible(true);
				}else {
					game.getParty().setTeamLength(game.getParty().getTeamLength() - 1);
					createHero();
					finishedWindow();
					runAgain();
				}
			}
		});
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setToolTipText("Confirm your selections");
		btnConfirm.setBackground(SystemColor.textHighlight);
		btnConfirm.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnConfirm.setBounds(396, 679, 175, 60);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblHeroCreation = new JLabel("Create Your Hero");
		lblHeroCreation.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblHeroCreation.setBounds(364, 22, 243, 85);
		frame.getContentPane().add(lblHeroCreation);
		
		JTextArea textArea = new JTextArea("Select a Hero Class");
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(160, 412, 624, 181);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Guardian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Guardian.background() + "\n\n" + Guardian.getStats());
				typePick = 1;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(225, 326, 149, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnKnight = new JButton("Knight");
		btnKnight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Knight.background() + "\n\n" + Knight.getStats());
				typePick = 2;
			}
		});
		btnKnight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKnight.setBounds(225, 241, 149, 60);
		frame.getContentPane().add(btnKnight);
		
		JButton btnJester = new JButton("Trickster");
		btnJester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Trickster.background() + "\n\n" + Trickster.getStats());
				typePick = 3;
			}
		});
		btnJester.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnJester.setBounds(396, 244, 149, 60);
		frame.getContentPane().add(btnJester);
		
		JButton btnWatchdog = new JButton("Watch Dog");
		btnWatchdog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(watchDog.background() + "\n\n" + watchDog.getStats());
				typePick = 4;
			}
		});
		btnWatchdog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnWatchdog.setBounds(575, 241, 149, 60);
		frame.getContentPane().add(btnWatchdog);
		
		JButton btnNecromancer = new JButton("Path Finder");
		btnNecromancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(pathFinder.background() + "\n\n" + pathFinder.getStats());
				typePick = 5;
			}
		});
		btnNecromancer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNecromancer.setBounds(575, 326, 149, 60);
		frame.getContentPane().add(btnNecromancer);
		
		JButton btnHealer = new JButton("Mental Monk");
		btnHealer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(mentalMonk.background() + "\n\n" + mentalMonk.getStats());
				typePick = 6;
				
			}
		});
		btnHealer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHealer.setBounds(396, 326, 149, 60);
		frame.getContentPane().add(btnHealer);
	}
	
	/**
	 * This method is called when Team creation is not complete and more Heroes 
	 * need to be created. Else the first city is created.
	 */
	public void runAgain() {
		if (game.getParty().getTeamLength() > 0) {
			game.launchHeroSetupSCREEN();
		} else {
			game.launchHomeBaseSCREEN(false);
		}
	}
	
	/**
	 * Closes up the frame and clears up this instance of HeroSetupScreen
	 */
	public void closeSCREEN() {
		frame.dispose();
	}
	
	/**
	 * This method calls closeSetupScreen of GameEnvironment class which closes the 
	 * HeroSetupSCREEN using closeSCREEN().
	 */
	public void finishedWindow() {
		game.closeHeroSetupScreen(this);
	}
	
	/**
	 * This method creates Heroes based on the input given to it by variable typePick and 
	 * heroName, and adds them to the Team
	 */
	public void createHero() {
		Hero newHero = HelperFunctions.heroCreate(typePick, heroName);
		game.getParty().addToTeam(newHero);
	}
	
}
