import java.util.Scanner;

public class GameEnviornment {
	
	private String teamName = "";
	private int teamLength = -1;
	private int cityNum = -1;
	
	
	public void getInput() {
		Scanner reader = new Scanner(System.in);
		while (teamName.length() < 2 || teamName.length() > 10) {
			System.out.println("What is the name of your super hero team?: ");
			teamName = reader.next();
			if (teamName.length() < 2 || teamName.length() > 10) {
				System.out.println("Invalid Input, the Length of Team Name must be 2-10 characters long:");
			}
		}
		while (cityNum < 3 || cityNum > 6) {
			System.out.println("How many Cities would you like to explore?:");
			cityNum = reader.nextInt();
			if (cityNum < 3 || cityNum >6) {
				System.out.println("Invalid Input, You can choose between 3 to 6 cities");
			}
		}
		while (teamLength < 1 || teamLength > 3) {
			System.out.println("How many Heroes would you like to have on your team?: ");
			teamLength = reader.nextInt();
			if (teamLength <1 || teamLength > 3) {
				System.out.println("Invalid Input, You can choose between 1 to 3 Heroes");
			}
		}

	}
	
	public void setGame() {
		getInput();
		Team newTeam = new Team(teamName, teamLength);
		System.out.println(newTeam);
		playGame(newTeam);
	}
	
	public void playGame(Team chosenTeam) {
		storyIntro();
		 int i = 0;
		while (i < cityNum) {
			if (i < cityNum -1) {
				City newCity = new City(false);
				newCity.HomeBase(chosenTeam);
				i++;
			} else {
				City newCity = new City(true);
				newCity.HomeBase(chosenTeam);
				i++;
			}
		}
	}
	
	public void storyIntro() {
		System.out.println("Story Introduction not implemented Yet.");
	}
}
