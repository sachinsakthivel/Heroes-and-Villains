import java.util.*;

public class rockPaperScissors extends miniGame {
	
	private static final String name = "Rock Paper Scissors";
	private static final String rules = "The Aim of this Game is to beat the opponent's choice. Paper beats Rock, Rock beat Scissors and Scissors beats Paper.";
	private int vNum;
	private String vPick;
	private boolean gameWon;
	
	public rockPaperScissors() {
		super(name, rules);
	}
	
	public boolean play(Hero hero, int userPick) {
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
	
	public String results() {
		String output = "\n....And the villain chose "+vPick+".";
		if (!gameWon) {
			output += ("\n\nHa Ha, Sadly you had no chance.\nYou Lose.");
		} else {  
			output += ("\n\nIt seems you have won today, but remember Lady Luck is quite fickle.\nYou Win!");
		}
		return output;
	}

	
	
	public void menuOptions() {
		System.out.println("Welcome to the game of Rock Paper Scissors !!!");
		System.out.println("Your choice?:\n");
		System.out.println("1 - Paper");
		System.out.println("2 - Scissors");
		System.out.println("3 - Rock");
	}
	
}
