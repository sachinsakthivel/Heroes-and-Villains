import java.util.Scanner;

public class MAINGUIManager {
	
	private String teamName = "";
	private int teamLength = -1;
	private int cityNum = -1;
	
	public void setGame() {
		getInput();
		Team newTeam = new Team(teamName, teamLength);
		playGame(newTeam);
	}
	
	public void 
	
	
	
	
	public void storyIntro() {
		System.out.println("Story Introduction not implemented Yet.");
	}
	
	public void storyOutro() {
		System.out.println("Story Conclusion not implemented Yet.");
	}
	
	
	// Opens up the first screen the user sees.
	public void closeStartUpSCREEN(StartUpSCREEN newStartupSCREEN) {
		newStartupSCREEN.closeSCREEN();		
	}
	
}
