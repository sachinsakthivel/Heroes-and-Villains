import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is GUI class which corresponds to the rockPaperScissors class which is a type of 
 * minigame. This class was built using Swing and facilitates the interaction 
 * between the User and the Rock Paper Scissors minigame.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 21st 2018
 *
 */

public class rockPaperSCREEN {

	private JFrame frame;
	private JTextArea textArea;
	private JButton btnReturnToHero;
	private JButton btnScissors;
	private JButton btnPaper;
	private JButton btnRock;
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
	 * Variable 'RPS' of Type rockPaperScissors which is the minigame Rock Paper Scissors.
	 */
	private rockPaperScissors RPS;
	/**
	 * Variable 'userPick' of Type Integer, which corresponds to the User's choice of Rock, 
	 * Paper or Scissors.
	 */
	private int userPick;

	
	/**
	 * Create the application.
	 * @param newGame Input variable 'newGame' of type GameEnvironment to pass data on to the 
	 * method of the current state of the game.
	 * @param chosenHero chosenHero Input variable 'chosenHero' of Type Hero which passes on data about the
	 * hero to the method.
	 */
	public rockPaperSCREEN(GameEnvironment newGame, Hero chosenHero) {
		initialize();
		game = newGame;
		hero = chosenHero;
		villain = game.getCurrentCity().getVillainsLair().getVillain();
		RPS = new rockPaperScissors();
		textArea.setText(RPS.gameDescription());
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 866, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRockPaperScissors = new JLabel("Rock Paper Scissors");
		lblRockPaperScissors.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblRockPaperScissors.setBounds(294, 11, 296, 59);
		frame.getContentPane().add(lblRockPaperScissors);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(69, 81, 711, 182);
		frame.getContentPane().add(textArea);
		
		btnRock = new JButton("Rock");
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPick = 3;
				boolean gameWon = RPS.play(userPick);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(RPS.results());
				visibleButtons();
			}
		});
		btnRock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRock.setBounds(23, 332, 235, 57);
		frame.getContentPane().add(btnRock);
		
		btnPaper = new JButton("Paper");
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPick = 1;
				boolean gameWon = RPS.play(userPick);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(RPS.results());
				visibleButtons();
			}
		});
		btnPaper.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPaper.setBounds(317, 332, 235, 57);
		frame.getContentPane().add(btnPaper);
		
		btnScissors = new JButton("Scissors");
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPick = 2;
				boolean gameWon = RPS.play(userPick);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(RPS.results());
				visibleButtons();
			}
		});
		btnScissors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnScissors.setBounds(595, 332, 235, 57);
		frame.getContentPane().add(btnScissors);
		
		btnReturnToHero = new JButton("Return to Hero Select");
		btnReturnToHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.getParty().checkDead(game);
			}
		});
		btnReturnToHero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnToHero.setBounds(317, 332, 235, 57);
		frame.getContentPane().add(btnReturnToHero);
		btnReturnToHero.setVisible(false);
	}
	
	/**
	 * Closes up the frame and clears up this instance of rockPaperSCREEN
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
			game.launchExitSCREEN();
			closeSCREEN();
		} else if (villain.checkdeath()) {
			game.getParty().setCoins(game.getParty().getCoins() + 150);
			JOptionPane.showMessageDialog(null, "Congratulations You have Defeated this Villain, Now Onward to the Next City!" + "\nYou have recieved 150 coins as gratitude from the Citizens");
			closeSCREEN();
			game.getHomeBase().runAgain();
		} else {
			game.closeRockPaperSCREEN(this);	
		}
	}
	
	/**
	 * This method hides the User's choice buttons, such as the Rock, Paper, and Scissor and 
	 * sets the ReturnToHero button to visible.
	 */
	public void visibleButtons() {
		btnRock.setVisible(false);
		btnPaper.setVisible(false);
		btnScissors.setVisible(false);
		btnReturnToHero.setVisible(true);
	}
}
