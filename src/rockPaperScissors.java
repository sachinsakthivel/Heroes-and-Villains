import java.util.*;

public class rockPaperScissors {
	
	private int vNum;
	private String vPick;
	private int userPick;
	private boolean gameWon = false;
	
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
		System.out.println("Your choice?:");
		System.out.println("1 - Paper");
		System.out.println("2 - Scissors");
		System.out.println("3 - Rock");
	}
	
	public static void main(String[] args) {
		rockPaperScissors newgame = new rockPaperScissors();
		System.out.println((newgame.play()));
		
	}

}
