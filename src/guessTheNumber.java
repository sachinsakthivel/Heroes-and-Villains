import java.util.*;

public class guessTheNumber extends Game {
	
	private static final String name = "Guess The Number";
	private static final String rules = "The Aim of the Game is to Guess the Villans's Number. You have two Guesses, and the Villan will say whether you Guess is Higher or Lower";
	private int guessNumber;
	private int tries;
	private int userGuess;
	private boolean gameWon;
	
	public guessTheNumber() {
		super(name, rules);
	}
	public boolean play(int upperLimit) {
		System.out.println("Welcome to game of 'Guess the Number' !!!");
		System.out.println("The rules are simple: You have two chances to guess the number that the I have chosen in the range of 1 to 10");
		System.out.println("Don't worry, I'm not that unfair, I will tell you if your guess is higher or lower.");
		gameWon = false;
		Random numGenerator = new Random();
		guessNumber = numGenerator.nextInt(upperLimit) + 1;
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
	
	public static void main(String[] args) {
		guessTheNumber newGame = new guessTheNumber();
		System.out.println(newGame.play(10));
	}

}
