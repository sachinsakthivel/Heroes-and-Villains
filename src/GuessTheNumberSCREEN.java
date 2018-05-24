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

public class GuessTheNumberSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private guessTheNumber GuessGame;
	private Hero hero;
	private Villain villain;
	private int villianGuess;
	private JButton btnIGuess;
	private JTextArea textArea;
	private JButton Continue;
	private int UserGuess;
	private boolean gameWon;
	private int tryNo;

	/**
	 * Create the application.
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
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
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
