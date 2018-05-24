import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * This is GUI class which corresponds to the guessTheNumber class which is a type of 
 * minigame. This class was built using Swing and facilitates the interaction 
 * between the User and the Guess the Number minigame.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 22nd 2018
 *
 */

public class GuessTheNumberSCREEN {

	private JFrame frame;
	private JButton btnIGuess;
	private JTextArea textArea;
	private JButton Continue;
	/**
	 * GameEnvironment variable to pass data on the current status of the game.
	 */
	private GameEnvironment game;
	/**
	 * Variable 'GuessGame' of Type guessTheNumber which is the minigame Guess the Number.
	 */
	private guessTheNumber GuessGame;
	/**
	 * Variable 'hero' of Type Hero
	 */
	private Hero hero;
	/**
	 * Variable 'villain' of Type Villain
	 */
	private Villain villain;
	/**
	 * Variable 'villianGuess' of Type Integer refers to the Villain's chosen number
	 */
	private int villianGuess;
	/**
	 * Variable 'UserGuess' of Type Integer refers to User's choice
	 */
	private int UserGuess;
	/**
	 * Boolean variable referencing whether the game was won by the Hero or not.
	 */
	private boolean gameWon;
	/**
	 * Variable 'tryNo' of Type Integer which refers to how many tries the User has had at 
	 * guessing the Villain's chosen number.
	 */
	private int tryNo;

	/**
	 * Create the application.
	 * @param newGame Input variable 'newGame' of type GameEnvironment to pass data on to the 
	 * method of the current state of the game.
	 * @param chosenHero chosenHero Input variable 'chosenHero' of Type Hero which passes on data about the
	 * hero to the method.
	 */
	public GuessTheNumberSCREEN(GameEnvironment newGame, Hero chosenHero) {
		game = newGame;
		hero = chosenHero;
		villain = game.getCurrentCity().getVillainsLair().getVillain();
		GuessGame = new guessTheNumber();
		Random rand = new Random();
		villianGuess = rand.nextInt(10 - hero.getSkill());
		tryNo = 0;
		initialize();
		textArea.setText(GuessGame.gameDescription());
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGuessTheNumber = new JLabel("Guess the Number");
		lblGuessTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessTheNumber.setFont(new Font("Tw Cen MT", Font.PLAIN, 32));
		lblGuessTheNumber.setBounds(369, 52, 296, 59);
		frame.getContentPane().add(lblGuessTheNumber);

		JSlider UGuessSlider = new JSlider();
		UGuessSlider.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		UGuessSlider.setPaintTicks(true);
		UGuessSlider.setPaintLabels(true);
		UGuessSlider.setMajorTickSpacing(1);
		UGuessSlider.setMaximum(10);
		UGuessSlider.setMinimum(1);
		UGuessSlider.setBounds(175, 445, 684, 44);
		frame.getContentPane().add(UGuessSlider);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(162, 129, 711, 204);
		frame.getContentPane().add(textArea);
		
		btnIGuess = new JButton("Did you guess...");
		btnIGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserGuess = UGuessSlider.getValue();
				tryNo++;
				gameWon = playGame();
				if (gameWon) {
					textArea.setText("Well done, You guessed Right!!, You Win.");
					btnIGuess.setVisible(false);
					Continue.setVisible(true);
				}else if (tryNo > 2) {
					textArea.setText("Ha Ha Ha, You Lose. The number I chose was " + villianGuess);
					btnIGuess.setVisible(false);
					Continue.setVisible(true);
				} 
			}
		});
		btnIGuess.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnIGuess.setBounds(404, 572, 235, 57);
		frame.getContentPane().add(btnIGuess);
		
		Continue = new JButton("Return to Hero Selction");
		Continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				finishedWindow();
				game.getParty().checkDead(game);
			}
		});
		Continue.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		Continue.setBounds(404, 572, 235, 57);
		frame.getContentPane().add(Continue);
		Continue.setVisible(false);
		
	}
	
	/**
	 * This method uses variables UserGuess and villianGuess to determine the outcome of an 
	 * instance of the game. (1 try) If game is won by the User, 'gameWon' is set to true, else 
	 * it returns false. The method also modifies the text in the 'textArea' of type JTextArea 
	 * depending on whether the 'UserGuess' was higher or not than the 'villianGuess'
	 * @return Returns the Boolean variable 'gameWon' 
	 */
	public boolean playGame() {
		if (UserGuess == villianGuess) {
			gameWon = true;
		} else if (UserGuess < villianGuess) {
			textArea.setText("Your Guess is lower than mine.");
			gameWon = false;
			
		} else {
			textArea.setText("Your Guess is higher than mine.");
			gameWon = false;
		}
		return gameWon;
	}
	
	/**
	 * Closes up the frame and clears up this instance of GuessTheNumberSCREEN
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
			game.closeGuessNumber(this);	
		}
	}
	
}
