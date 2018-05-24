import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is GUI class which corresponds to the diceRolls class which is a type of 
 * minigame. This class was built using Swing and facilitates the interaction 
 * between the User and the Dice Roll minigame.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 19th 2018
 *
 */

public class diceRollsSCREEN {

	private JFrame frame;
	private JTextArea textArea;
	private JButton btnHeroSelect;
	private JButton btnRoll;
	/**
	 * Game Environment variable to pass data on the current status of the game.
	 */
	private GameEnvironment game;
	/**
	 * Variable 'hero' of Type Hero
	 */
	private Hero hero;
	/**
	 * Variable 'villain' of Type Villain
	 */
	private Villain villain;
	/**
	 * Variable 'dice' of Type diceRolls which is the minigame Dice Roll
	 */
	private diceRolls dice;

	
	
	/**
	 * Create the application.
	 * @param newGame Input variable 'newGame' of type GameEnvironment to pass data on to the 
	 * method of the current state of the game.
	 * @param chosenHero Input variable 'chosenHero' of Type Hero which passes on data about the
	 * hero to the method.
	 */
	public diceRollsSCREEN(GameEnvironment newGame, Hero chosenHero) {
		initialize();
		game = newGame;
		hero = chosenHero;
		villain = game.getCurrentCity().getVillainsLair().getVillain();
		dice = new diceRolls();
		textArea.setText(dice.gameDescription());
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 916, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbltitle = new JLabel("Dice Rolls");
		lbltitle.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lbltitle.setBounds(368, 22, 191, 59);
		frame.getContentPane().add(lbltitle);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setBounds(108, 97, 711, 182);
		frame.getContentPane().add(textArea);
		
		btnRoll = new JButton("Roll Dices!!");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean gameWon = dice.play(hero);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(dice.results());
				btnHeroSelect.setVisible(true);
				btnRoll.setVisible(false);
				
			}
		});
		btnRoll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRoll.setBounds(340, 325, 235, 57);
		frame.getContentPane().add(btnRoll);
		
		btnHeroSelect = new JButton("Return to Hero Select");
		btnHeroSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.getParty().checkDead(game);
			}
		});
		btnHeroSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHeroSelect.setBounds(340, 325, 235, 57);
		frame.getContentPane().add(btnHeroSelect);
		btnHeroSelect.setVisible(false);
	}
	
	/**
	 * Closes up the frame and clears up this instance of diceRollsSCREEN
	 */
	public void closeSCREEN() {
		frame.dispose();
	}
	
	/**
	 * This utilizes the closeSCREEN method to exit the screen after checking for various 
	 * conditions. If the Team is killed the User will be notified of his/her defeat. If the 
	 * Villain is killed the User progresses to the next City. In all cases the diceRollSCREEN 
	 * is disposed of.
	 */
	public void finishedWindow() {
		if (game.getParty().checkDead(game) ) {
			JOptionPane.showMessageDialog(null, "Your Team has Perished. You have Failed this City" + "\n");
			closeSCREEN();
			game.launchExitSCREEN();
		}else if (villain.checkdeath()) {
			game.getParty().setCoins(game.getParty().getCoins() + 150);
			JOptionPane.showMessageDialog(null, "Congratulations You have Defeated this Villain, Now Onward to the Next City!" + "\nYou have recieved 150 coins as gratitude from the Citizens");
			closeSCREEN();
			game.getHomeBase().runAgain();
		} else {
			game.closeDiceRollsSCREEN(this);	
		}
	}
	
	
}
