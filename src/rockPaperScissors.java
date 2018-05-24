import java.util.*;

/**
 * Date: May 14th 2018
 * 
 * This class creates the minigame Rock Paper Scissors.
 * 
 * Parent Class is miniGame. The user can choose either rock, paper or scissors and normal rules
 * of Rock Paper Scissors apply except when its a tie, the Villain Wins. Odds of winning the game 
 * cannot be improved with items.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class rockPaperScissors extends miniGame {
	
	/**
	 * String variable for Name of the minigame.
	 */
	private static final String name = "Rock Paper Scissors";
	/**
	 * String variable for Rules of the minigame.
	 */
	private static final String rules = "The Aim of this Game is to beat the opponent's choice. Paper beats Rock, Rock beat Scissors and Scissors beats Paper.";
	/**
	 * Integer variable symbolizing the Villain's choice.
	 */
	private int vNum;
	/**
	 * String variable symbolizing the Villain's choice.
	 */
	private String vPick;
	/**
	 * Boolean variable referencing whether the game was won by the Hero or not.
	 */
	private boolean gameWon;
	
	/**
	 * The constructor method which uses Parent class miniGame to set Name and Rules
	 */
	public rockPaperScissors() {
		super(name, rules);
	}
	
	
	/**
	 * This method allows the User to use a Hero to fight the villain using the Rock 
	 * Paper Scissors. 
	 * The method uses VillainPick() to obtain the Villain's choice and uses input as 
	 * User's choice and follow the minigame rules to determine a winner.
	 * @param userPick Input integer variable which determines User's choice in the 
	 * minigame.
	 * @return Returns Boolean variable 'gameWon' addhereing to the rules to determine 
	 * the winner.
	 */
	public boolean play(int userPick) {
		VillianPick();
		if (userPick == vNum) {
			gameWon = false;
		}
		else {
			if (userPick == 1) {
				if (vNum == 2) {
					gameWon = false;
				} else {
					gameWon = true;
				}
			} else if (userPick == 2) {
				if (vNum == 3) {
					gameWon = true;
				}
				else {
					gameWon = true;
				} 
			} else {
				if (vNum == 1) {
					gameWon = false;
				}
				else {
					gameWon = true;
				} 
			}
		}
		return gameWon;
	}
			
	/**
	 * This method picks a choice for the villain randomly.
	 */
	public void VillianPick() {
		Random rand = new Random();
		vNum  = rand.nextInt(2) + 1;
		if (vNum == 1) {
			vPick = "Paper";
		}
		else if (vNum == 2) {
			vPick = "Scissors";
		}
		else {
			vPick = "Rock";
		}
	}
	
	public String gameDescription() {
		String output = "Welcome to the game of Rock Paper Scissors!!!";
		output += "\n\nRules are simple: Rock beats Scissors, Scissors beats Paper and Paper beats Rock";
		output += "\nA simple game that everyone has played, Now assuming you've played this before, you understand that this game brings about a lot of ties.";
		output += "\nSince spending time around yous make me sick, if it's a tie, I win.";
		output += "\n\nWhat do you Pick? Rock Paper Scissors!!!";
		return output;
	} 
	
	/**
	 * This method returns a String variable dependent on the boolean variable 'gameWon'. 
	 * If gameWon is true, String variable output will be set to an appropriate response and vice
	 * versa.
	 * @return Returns String output which contains flavour text intended to be shown in JTextAreas
	 * in the GUI element of the Game.
	 */
	public String results() {
		String output = "\n....And the villain chose "+vPick+".";
		if (!gameWon) {
			output += ("\n\nHa Ha, Sadly you had no chance.\nYou Lose.");
		} else {  
			output += ("\n\nIt seems you have won today, but remember Lady Luck is quite fickle.\nYou Win!");
		}
		return output;
	}
	
}
