import java.util.*;

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

	public boolean play(Hero hero, int UserGuess) {
		userGuess = UserGuess;
		upperLimit = hero.getSkill();
		Random numGenerator = new Random();
		VillainGuess = numGenerator.nextInt(10 - upperLimit) + 1;
		while (gameWon == false) {
			if (tries >=  2) {
				gameWon = false;
				break;
			}
			tries++;
			if (userGuess == VillainGuess) {
				gameWon = true;
			} else if (userGuess < VillainGuess) {
				HigherOrNot = true;
			} else {
				HigherOrNot = false;
			}
		}
		return gameWon;
	}
	
	
	public boolean GetHighOrNot() {
		return HigherOrNot;
	}
	
	/*
	
	public boolean playText(Hero hero) {
		int upperLimit = hero.getSkill();
		gameWon = false;
		Random numGenerator = new Random();
		guessNumber = numGenerator.nextInt(10 - upperLimit) + 1;
		Scanner input = new Scanner(System.in);
		while (gameWon == false) {
			if (tries == 2) {
				System.out.println("Ha Ha Ha, You Lose. The number I chose was " + guessNumber);
				break;
			}
			System.out.println("\nWell then, What's your guess?? Choose Wisely !!");
			userGuess = input.nextInt();
			System.out.println(guessNumber);
			tries++;
			if (userGuess == guessNumber) {
				System.out.println("Well done, You guessed Right!!, You Win.");
				gameWon = true;
			} else if (userGuess < guessNumber) {
				System.out.println("Your Guess is lower than mine.");
				
			} else {
				System.out.println("Your Guess is higher than mine.");
			}
		}
		return gameWon;
	}
	*/
	
}
