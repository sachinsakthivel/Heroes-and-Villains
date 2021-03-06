import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * This Class provides the GUI for the User to select a Hero from the team and battle the 
 * current Villain
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 23rd 2018
 *
 */

public class battleSCREEN {

	private JFrame frame;
	private JTextArea txtrVillain;
	private JTextArea txtrHeroDescription;
	private JTextArea txtrVillainDescription;
	private JLabel lblerror;
	JPanel villainDescription;
	/**
	 * GameEnvironment variable to pass data on the current status of the game.
	 */
	private GameEnvironment game;
	/**
	 * Variable 'villainsLair' of Type VillainsLair refers to the currently active villains lair
	 */
	private VillainsLair villainsLair;
	/**
	 * Variable 'HeroIndex' of Type Integer refers to User's selection of Heros, and it is set 
	 * to -1 by default.
	 */
	private int HeroIndex = -1;
	/**
	 * Variable 'gameChoice' of Type Integer refers to Villains preferred choice in minigames
	 */
	private int gameChoice;
	


	/**
	 * Create the application.
	 * @param newGame Input variable 'newGame' of type GameEnvironment to pass data on to the 
	 * method of the current state of the game.
	 */
	public battleSCREEN(GameEnvironment newGame) {
		game = newGame;
		villainsLair = game.getCurrentCity().getVillainsLair();
		gameChoice = villainsLair.getVillain().gamePreference();
		initialize();
		frame.setVisible(true);
		if (game.getParty().typeCheck("Mental Monk")) {
			villainDescription.setVisible(true);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("DEATH BATTLE!");
		titleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		titleLabel.setBounds(340, 11, 220, 84);
		frame.getContentPane().add(titleLabel);
		
		txtrVillain = new JTextArea();
		txtrVillain.setLineWrap(true);
		txtrVillain.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrVillain.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtrVillain.setEditable(false);
		txtrVillain.setWrapStyleWord(true);
		txtrVillain.setText(villainsLair.getVillain().toString());
		txtrVillain.setBounds(106, 91, 681, 108);
		frame.getContentPane().add(txtrVillain);
		
		JLabel label = new JLabel("Hero Selection:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(20, 210, 214, 29);
		frame.getContentPane().add(label);
		
		if (game.getParty().getTeam().size()  >= 1) {
			JButton button = new JButton("Hero: " + game.getParty().getTeam().get(0).getPersonName());
			button.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HeroIndex = 0;
					txtrHeroDescription.setText(game.getParty().getTeam().get(0).toString());	
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button.setBounds(20, 250, 206, 43);
			frame.getContentPane().add(button);
			
		}
		
		if (game.getParty().getTeam().size()  >= 2) {
			JButton button_1 = new JButton("Hero: " + game.getParty().getTeam().get(1).getPersonName());
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HeroIndex = 1;
					txtrHeroDescription.setText(game.getParty().getTeam().get(1).toString());
					
				}
			});
			button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button_1.setBounds(20, 324, 206, 43);
			frame.getContentPane().add(button_1);
		}
		
		if (game.getParty().getTeam().size()  == 3) {
			JButton button_2 = new JButton("Hero: "+ game.getParty().getTeam().get(2).getPersonName());
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HeroIndex = 2;
					txtrHeroDescription.setText(game.getParty().getTeam().get(2).toString());
				}
			});
			button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button_2.setBounds(20, 398, 206, 43);
			frame.getContentPane().add(button_2);
		}
		
		JButton btnReturnToLair = new JButton("Return to Lair Entrance");
		btnReturnToLair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnReturnToLair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnToLair.setBounds(20, 528, 235, 57);
		frame.getContentPane().add(btnReturnToLair);
		
		JButton btnFightVillain = new JButton("Fight Villain\r\n");
		btnFightVillain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				battle(HeroIndex, gameChoice, game);
				}
		});
		btnFightVillain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFightVillain.setBounds(619, 528, 235, 57);
		frame.getContentPane().add(btnFightVillain);
		
		JLabel label_1 = new JLabel("Hero Selection:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(270, 210, 214, 29);
		frame.getContentPane().add(label_1);
		
		lblerror = new JLabel("Please Select a Hero");
		lblerror.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblerror.setForeground(Color.RED);
		lblerror.setBounds(654, 489, 255, 29);
		lblerror.setVisible(false);
		frame.getContentPane().add(lblerror);
		
		villainDescription = new JPanel();
		villainDescription.setBounds(509, 210, 363, 268);
		frame.getContentPane().add(villainDescription);
		villainDescription.setLayout(null);
		villainDescription.setVisible(false);
		
		JLabel lblVillaindescription = new JLabel("Knowledge About Villain:\r\n");
		lblVillaindescription.setBounds(10, 4, 218, 24);
		villainDescription.add(lblVillaindescription);
		lblVillaindescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillaindescription.setFont(new Font("Dialog", Font.BOLD, 18));
		
		txtrVillainDescription = new JTextArea();
		txtrVillainDescription.setWrapStyleWord(true);
		txtrVillainDescription.setLineWrap(true);
		txtrVillainDescription.setEditable(false);
		txtrVillainDescription.setBounds(26, 36, 337, 191);
		villainDescription.add(txtrVillainDescription);
		txtrVillainDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrVillainDescription.setText(villainsLair.villainInsight() + "\nChosen Game to Play: " +villainsLair.getGames().get(gameChoice).getGameName());
		
		txtrHeroDescription = new JTextArea();
		txtrHeroDescription.setWrapStyleWord(true);
		txtrHeroDescription.setLineWrap(true);
		txtrHeroDescription.setEditable(false);
		txtrHeroDescription.setBounds(280, 246, 214, 191);
		frame.getContentPane().add(txtrHeroDescription);
		txtrHeroDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrHeroDescription.setText("Select a Hero");
	}
	
	/**
	 * Closes up the frame and clears up this instance of GuessTheNumberSCREEN
	 */
	public void closeSCREEN() {
		frame.dispose();
	}
	
	/**
	 * This method calls closeBattleSCREEN of GameEnvironment class which closes the 
	 * BattleSCREEN and creates a new instance of the GUI element VillainLairSCREEN.
	 */
	public void finishedWindow() {
		game.closeBattleSCREEN(this);
	}
	
	/**
	 * This method facilitates minigame battles by creating new instances of the relevant 
	 * minigames with the User's selected Hero.
	 * @param heroIndex Variable 'heroIndex' of Type Integer refers to the User's selected Hero
	 * @param gameChoice Variable 'gameChoice' of Type Integer refers to the Villains preferred 
	 * minigame choice. 
	 * @param game GameEnvironment variable to pass data on the current status of the game.
	 */
	public void battle(int heroIndex, int gameChoice, GameEnvironment game) {
		if (heroIndex == -1) {
			lblerror.setVisible(true);
		} else {
			Hero chosenHero = game.getParty().getTeam().get(HeroIndex);
			if (gameChoice == 0) {
				game.launchDiceRollsSCREEN(chosenHero);
			} else if (gameChoice == 1) {
				game.launchRockPaperSCREEN(chosenHero);
			} else {
				game.launchGuessNumber(chosenHero);
			}
			closeSCREEN();
		}
	}
}
