public class GameEnvironment {
	
	private int cityNum = -1;
	private  ExitSCREEN ExitScreen;
	private Team chosenTeam;
	private City currentCity;
		
	public void setGame() {
		GameEnvironment game = new GameEnvironment();
		game.launchStartUpSCREEN();
	}
	
	public void playGame() {
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
		chosenTeam.getInv().get(3).setItemStock(3);
		launchHeroSetupSCREEN();
	}
	public void launchHeroSetupSCREEN() {
		HeroSetupSCREEN heroSetup = new HeroSetupSCREEN(this);
	}
	
	public void closeHeroSetupScreen(HeroSetupSCREEN heroCreate) {
		heroCreate.closeSCREEN();
		System.out.println(chosenTeam);
		System.out.println(chosenTeam.getTeamLength());
	}
	
	public void launchHomeBaseSCREEN() {
		HomeBaseSCREEN homeBase = new HomeBaseSCREEN(this, true);
		for (int i = 1; i < cityNum; i++) {
			HomeBaseSCREEN homebase = new HomeBaseSCREEN(this , false );
		}
	}
	
	public void closeHomeBaseSCREEN(HomeBaseSCREEN home) {
		home.closeSCREEN();
	}
	
	public void launchShopSCREEN() {
		ShopSCREEN shop = new ShopSCREEN(this);
	}
	
	public void closeShopSCREEN(ShopSCREEN shop) {
		shop.closeSCREEN();
		launchHomeBaseSCREEN();
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

	public City getCurrentCity() {
		return currentCity;
	}
	
	public int getCityNum() {
		return cityNum;
	}

	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}
	
}
