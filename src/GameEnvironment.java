public class GameEnvironment {
	
	private int cityNum = -1;
	
	private  ExitSCREEN ExitScreen;
	
	private Team chosenTeam;
	
	public static void main(String args[]) {
		GameEnvironment game = new GameEnvironment();
		game.launchStartUpSCREEN();
	}
	
	
	public void setGame() {
		launchStartUpSCREEN();
	}
	
	public void playGame(Team chosenTeam) {
		storyIntro();
		
		// main game loop:
		
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
	
	public void launchStartUpSCREEN() {
		StartUpSCREEN StartUp = new StartUpSCREEN(this);
	}
	
	public void closeMainScreen(StartUpSCREEN mainMenu) {
		mainMenu.closeSCREEN();
		launchGameSetupSCREEN();
		
	}
	
	public void launchGameSetupSCREEN() {
		GameSetupSCREEN GameSetup = new GameSetupSCREEN(this);
	}
	
	public void closeSetupScreen(GameSetupSCREEN setup) {
		setup.closeSCREEN();
		cityNum = setup.getNoCities();
		chosenTeam = new Team(setup.getTeamName(), setup.getNoHeroes());
		launchHeroSetupSCREEN();
	}
	public void launchHeroSetupSCREEN() {
		for (int i = 0; i < chosenTeam.getTeamLength(); i++) {
			HeroSetupSCREEN HeroSetup = new HeroSetupSCREEN(this);
		}
	}
	
	public void closeHeroSetupScreen(HeroSetupSCREEN heroCreate) {
		heroCreate.closeSCREEN();
		System.out.println(chosenTeam);
		System.out.println(chosenTeam.getTeamLength());
		
	}
 
	public void launchExitSCREEN() {
		ExitScreen = new ExitSCREEN();
		ExitScreen.frame.setVisible(true);
	}
	
	public void setTeam(Team team) {
		chosenTeam = team;
	}
	
	public void setCityNum(int num) {
		cityNum = num;
	}
	
	public Team getTeam() {
		return chosenTeam;
	}
	
}
