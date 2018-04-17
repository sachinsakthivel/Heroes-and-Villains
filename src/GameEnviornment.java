import java.util.Scanner;

public class GameEnviornment {
	
	private String teamName = "";
	
	
	public void setGame() {
		Scanner reader = new Scanner(System.in);
		while (teamName.length() < 2 || teamName.length() > 10) {
			System.out.println("What is the name of your super hero team? (Length of Team Name must be 2-10 characters long): ");
			teamName = reader.next();
		}
		

	}
	
	
}
