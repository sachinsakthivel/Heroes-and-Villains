import java.util.*;

/**
 * Date: May 14th 2018
 * 
 * This class creates the minigame Dice Rolls.
 * 
 * Parent Class is miniGame. The user rolls a number between 1 and 10, and if the Villain rolls 
 * higher number, user looses the game and vice versa. Odds of winning the game can be improved 
 * by buying Weighted Dice Item in the Shop.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class diceRolls extends miniGame{
	
	/**
	 * String variable for Name of the minigame.
	 */
	private static final String name = "Dice Rolls";
	/**
	 * String variable for Rules of the minigame.
	 */
	private static final String rules = "The Aim of this Game is to get the highest dice roll, The Person with the Highest Roll is the Winner!!";
	/**
	 * Integer variable for the number rolled by the Villain.
	 */
	private int villanRoll;
	/**
	 * Integer variable for the number rolled by the User.
	 */
	private int userRoll;
	/**
	 * Boolean variable referencing whether the game was won by the Hero or not.
	 */
	private boolean gameWon;
	
	
	/**
	 * The constructor method which uses Parent class miniGame to set Name and Rules
	 */
	public diceRolls() {
		super(name, rules);
	}
	
	public boolean play(Hero hero) {
		int rollLimit = hero.getDice();
		gameWon = false;
		Random rollGenerator = new Random();
		villanRoll = rollGenerator.nextInt(10 - rollLimit) + 1;
		userRoll = rollGenerator.nextInt(10) + 1;
		if (villanRoll == userRoll) {
			gameWon = false;
		} else if (villanRoll > userRoll) {
			gameWon = false;
		} else {
			gameWon = true;
		}
		return gameWon;
	}
	
	public String gameDescription() {
		String output = "Welcome to the game of Dice Rolls !!!";
		output += "\nThis is the game that test's your connection to the Lady of Luck!";
		output += "\n\nThe Aim of this Game is to get the highest dice roll, The Person with the Highest Roll is the Winner!!";
		output += "If it's a tie, I win. You find that unfair?; Life is unfair, so get over it. ";
		output += "\n\nAre you feeling Lucky?";
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
		String output = "\nYou have rolled a "+userRoll+".";
		output += "\nThe villain has rolled a "+villanRoll+".";
		if (!gameWon) {
			output += ("\n\nHa Ha, Sadly you had no chance.\nYou Lose.");
		} else {  
			output += ("\n\nIt seems you have won today, but remember Lady Luck is quite fickle.\nYou Win!");
		}
		return output;
	}

}
