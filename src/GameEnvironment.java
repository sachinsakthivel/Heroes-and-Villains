import java.util.Scanner;

public class GameEnvironment {
	
	private String teamName = "";
	private int teamLength = -1;
	private int cityNum = -1;
	
	
	public void getInput() {
		Scanner reader = new Scanner(System.in);
		while (teamName.length() < 2 || teamName.length() > 10) {
			System.out.println("Hey there, What is the name of your super hero team?: ");
			teamName = reader.next();
			if (teamName.length() < 2 || teamName.length() > 10) {
				System.out.println("Invalid Input, the Length of Team Name must be 2-10 characters long:");
			}
		}
		while (cityNum < 3 || cityNum > 6) {
			System.out.println("How many Cities would you like to explore?: (Choose between 3 to 6 Cities)");
			cityNum = HelperFunctions.InputValidator(3, 6);
			}
		while (teamLength < 1 || teamLength > 3) {
			System.out.println("How many Heroes would you like to have on your team?: (Choose between 1 to 3 Heroes)");
			teamLength = HelperFunctions.InputValidator(1, 3);
		}
	}
	
	public void setGame() {
		getInput();
		Team newTeam = new Team(teamName, teamLength);
		playGame(newTeam);
	}
	
	public void playGame(Team chosenTeam) {
		storyIntro();
		 int i = 0;
		while (i < cityNum) {
			if (i < cityNum -1) {
				City newCity = new City(false);
				newCity.HomeBase(chosenTeam);
				System.out.println("Congratulations, You have Saved this City!. Now Onto to the Next City!.");
				i++;
			} else {
				City finalCity = new City(true);
				finalCity.HomeBase(chosenTeam);
				storyOutro();
				System.out.println("GAME WON!!!");
				i++;
			}
		}
	}
	
	public void storyIntro() {
		System.out.println("Story Introduction not implemented Yet.");
	}
	
	public void storyOutro() {
		System.out.println("Story Conclusion not implemented Yet.");
	}
}
