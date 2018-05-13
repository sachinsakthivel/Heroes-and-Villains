import java.util.*;

public class rockPaperScissors extends Game {
	
	private static final String name = "Rock Paper Scissors";
	private static final String rules = "The Aim of this Game is to beat the opponent's choice. Paper beats Rock, Rock beat Scissors and Scissors beats Paper.";
	private int vNum;
	private String vPick;
	private int userPick;
	private boolean gameWon;
	
	public rockPaperScissors() {
		super(name, rules);
	}
	
	public boolean play() {
		gameWon = false;
		Scanner UserInput = new Scanner(System.in);
		Random villianChoice = new Random();
		menuOptions();
		userPick = UserInput.nextInt();
		vNum  = villianChoice.nextInt(3) + 1;
		if (vNum == 1) {
			vPick = "Paper";
		}
		else if (vNum == 2) {
			vPick = "Scissors";
		}
		else {
			vPick = "Paper";
		}
		System.out.println("....And the villian has picked "+vPick+" !.");
		if (userPick == vNum) {
			System.out.println("So close! It's a tie!!");
			System.out.println("We Shall Play Again.");
			play();
		}
		else {
			switch(userPick) {
			case 1:
				if (vNum == 2) {
					System.out.println("Sadly, You Have Lost.");
				}
				else {
					System.out.println("Congratulations You have Won this Game!!!");
					gameWon = true;
				}
				break;
			case 2:
				if (vNum == 1) {
					System.out.println("Sadly, You Have Lost.");
				}
				else {
					System.out.println("Congratulations You have Won this Game!!!");
					gameWon = true;
				} 
				break;
			case 3:
				if (vNum == 1) {
					System.out.println("Sadly, You Have Lost.");
				}
				else {
					System.out.println("Congratulations You have Won this Game!!!");
					gameWon = true;
				} 
				break;
				}
			}
		return gameWon;
	}

	
	
	public void menuOptions() {
		System.out.println("Welcome to the game of Rock Paper Scissors !!!");
		System.out.println("Your choice?:\n");
		System.out.println("1 - Paper");
		System.out.println("2 - Scissors");
		System.out.println("3 - Rock");
	}
	

}
