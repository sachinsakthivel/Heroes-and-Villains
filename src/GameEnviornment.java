import java.util.Scanner;

public class GameEnviornment {
	
	private String teamName = "";
	private int teamLength;
	private int cityNum;
	
	
	public void setGame() {
		Scanner reader = new Scanner(System.in);
		while (teamName.length() < 2 || teamName.length() > 10) {
			System.out.println("What is the name of your super hero team?: ");
			teamName = reader.next();
			if (teamName.length() < 2 || teamName.length() > 10) {
				System.out.println("Invalid Input, the Length of Team Name must be 2-10 characters long:");
			}
		}
		while (cityNum <= 3 || cityNum >= 6) {
			System.out.println("How many cities would you like to explore?:");
			cityNum = reader.nextInt();
			if (cityNum <= 3 || cityNum >= 6) {
				System.out.println("Invalid Input, You can choose between 3 to 6 cities");
			}
		}

	}
	
	
}
