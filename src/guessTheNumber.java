import java.util.Random;

/**
 * Date: May 17th 2018
 * 
 * This class creates the minigame Guess the Number.
 * 
 * Parent Class is miniGame. The user chooses a number between 1 and 10 in an attempt to
 * guess the Villains choice. Odds of winning the game can be improved by buying Hypnotic
 *  Suggestion Skillbook Item in the Shop.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class guessTheNumber extends miniGame {
	
	/**
	 * String variable for Name of the minigame.
	 */
	private static final String name = "Guess The Number";
	/**
	 * String variable for Rules of the minigame.
	 */
	private static final String rules = "The Aim of the Game is to Guess the Villans's Number. You have two Guesses, and the Villan will say whether you Guess is Higher or Lower";
	/**
	 * Integer variable for the number chosen by the Villain.
	 */
	private int VillainGuess;
	/**
	 * Integer variable for the number of tries the number has used to guess the Villain's 
	 * chosen Number.
	 */
	private int tries = 0;
	/**
	 * Integer variable for the number chosen by the User.
	 */
	private int userGuess;
	/**
	 * Boolean variable referencing whether the game was won by the Hero or not.
	 */
	private boolean gameWon = false;
	/**
	 * Boolean variable referencing whether User's guess was higher or not than that of the
	 * Villain's choice.
	 */
	private boolean HigherOrNot;
	
	public guessTheNumber() {
		super(name, rules);
	}
	
	public String gameDescription() {
		String output = "Welcome to game of 'Guess the Number' !!!";
		output += "\n\nThe rules are simple: You have two chances to guess the number that the I have chosen in the range of 1 to 10.";
		output += "\nDon't worry, I'm not that unfair, I will tell you if your guess is higher or lower.";
		output += "\n\nAre you feeling Lucky?";
		return output;
	}
	
	
	/**
	 * This method uses input variables userGuess and VillainGuess to determine whether 
	 * the User won or not and returns Boolean variable gameWon.
	 * @param userGuess Integer variable for the number chosen by the User
	 * @param VillianGuess Integer variable for the number chosen by the Villain
	 * @return Returns Boolean variable gameWon
	 */
	public boolean check(int userGuess, int VillianGuess) {
		if (userGuess == VillianGuess) {
			gameWon = true;
			return gameWon ;
		} else if (userGuess < VillianGuess) {
			HigherOrNot = true;
			return HigherOrNot;
		} else {
			HigherOrNot = false;
			return HigherOrNot;
		}
	}
	
	
}
