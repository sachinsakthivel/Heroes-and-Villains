import java.util.*;

public class diceRolls {
	private int villanRoll;
	private int userRoll;
	private String userInput;
	private boolean gameWon;
	
	
	public boolean play(int rollLimit) {
		gameWon = false;
		Random rollGenerator = new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcom to the game of Dice Rolls !!!");
		System.out.println("This is the game that test's your connection the Lady of Luck!");
		System.out.println("\nAre you feeling Lucky? - (Press any character to roll)");
		userInput = input.next();
		villanRoll = rollGenerator.nextInt(10 - rollLimit) + 1;
		userRoll = rollGenerator.nextInt(10) + 1;
		System.out.println("You have rolled a " + userRoll+ ".");
		if (villanRoll == userRoll) {
			System.out.println("\naWell, it seems Lady Luck is quite indecisive, It's a tie.");
			System.out.println("We Shall Play Again");
			play(rollLimit);
		} else if (villanRoll > userRoll) {
			System.out.println("Ha Ha, Sadly you had no chance, You Lose.");
			System.out.println("I rolled a " + villanRoll + ".");
		} else {
			System.out.println("It seems you have won today, but remember Lady Luck is quite fickle.");
			System.out.println("I rolled a " + villanRoll + ".");
			gameWon = true;
		}
		return gameWon;
	}
	
	public static void main(String[] args) {
		diceRolls newGame = new diceRolls();
		System.out.println((newGame.play(12)));
	}
}
