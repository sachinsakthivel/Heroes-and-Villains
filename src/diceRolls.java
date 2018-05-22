import java.util.*;

public class diceRolls extends miniGame{
	
	private static final String name = "Dice Rolls";
	private static final String rules = "The Aim of this Game is to get the highest dice roll, The Person with the Highest Roll is the Winner!!";
	private int villanRoll;
	private int userRoll;
	private boolean gameWon;
	
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
