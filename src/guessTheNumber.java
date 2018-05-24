import java.util.Random;

public class guessTheNumber extends miniGame {
	
	private static final String name = "Guess The Number";
	private static final String rules = "The Aim of the Game is to Guess the Villans's Number. You have two Guesses, and the Villan will say whether you Guess is Higher or Lower";
	private int VillainGuess;
	private int tries = 0;
	private int userGuess;
	private boolean gameWon = false;
	private int upperLimit;
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
