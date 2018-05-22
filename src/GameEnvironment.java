public class GameEnvironment {
	
	private int cityNum;
	private  HomeBaseSCREEN homeBase;
	private Team chosenTeam;
	private City currentCity;
	private battleSCREEN battle;
		
	public void setGame() {
		GameEnvironment game = new GameEnvironment();
		game.launchStartUpSCREEN();
	}
	
	/*
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
	*/
	
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
		chosenTeam.getInv().get(4).setItemStock(4);
		launchHeroSetupSCREEN();
	}
	
	public void launchHeroSetupSCREEN() {
		HeroSetupSCREEN heroSetup = new HeroSetupSCREEN(this);
	}
	
	public void closeHeroSetupScreen(HeroSetupSCREEN heroCreate) {
		heroCreate.closeSCREEN();
	}
	
	public void launchHomeBaseSCREEN(boolean isFinal) {
		homeBase = new HomeBaseSCREEN(this, isFinal);
	}
	
	public void closeHomeBaseSCREEN(HomeBaseSCREEN home) {
		home.closeSCREEN();
	}
	
	public void launchPowerUpSCREEN(HomeBaseSCREEN homeBase) {
		homeBase.getFrame().setVisible(false);
		PowerUpSCREEN powerUp = new PowerUpSCREEN(this);
		homeBase.updateButton();
	}
	
	public void closePowerUpSCREEN(HomeBaseSCREEN homeBase, PowerUpSCREEN powerUp) {
		powerUp.closeSCREEN();
		homeBase.getFrame().setVisible(true);
	}
	
	public void launchShopSCREEN(HomeBaseSCREEN homeBase) {
		homeBase.getFrame().setVisible(false);
		ShopSCREEN ShopWindow = new ShopSCREEN(this);
		homeBase.updateButton();
		
	}
	
	public void closeShopSCREEN(HomeBaseSCREEN homeBase, ShopSCREEN Shop) {
		Shop.closeSCREEN();
		homeBase.getFrame().setVisible(true);
	}

	
	public void launchVillainLairSCREEN(HomeBaseSCREEN homeBase) {
		homeBase.getFrame().setVisible(false);
		VillainsLairSCREEN villainLair = new VillainsLairSCREEN(this);
		homeBase.updateButton();
	}
	
	public void closeVillainLairSCREEN(HomeBaseSCREEN homeBase, VillainsLairSCREEN villainLair, boolean toHomeBase) {
		villainLair.closeSCREEN();
		if(toHomeBase) {
			homeBase.getFrame().setVisible(true);
		}
	}
	
	public void launchBattleSCREEN() {
		battle = new battleSCREEN(this);
	}
	
	public void closeBattleSCREEN(battleSCREEN battle) {
		battle.closeSCREEN();
		VillainsLairSCREEN villainLair = new VillainsLairSCREEN(this);
	}
	
	public void launchDiceRollsSCREEN(Hero chosenHero) {
		diceRollsSCREEN dice = new diceRollsSCREEN(this, chosenHero);
	}
	
	public void closeDiceRollsSCREEN(diceRollsSCREEN dice) {
		dice.closeSCREEN();
		battleSCREEN battle = new battleSCREEN(this);
	}
	
	public void launchRockPaperSCREEN(Hero chosenHero) {
		rockPaperSCREEN rps = new rockPaperSCREEN(this, chosenHero);
	}
	
	public void closeDiceRollsSCREEN(rockPaperSCREEN rps) {
		rps.closeSCREEN();
		battleSCREEN battle = new battleSCREEN(this);
	}

  
	public void launchExitSCREEN() {
		ExitSCREEN exit = new ExitSCREEN();
	}
	
	public void setParty(Team team) {
		chosenTeam = team;
	}
	
	public void setCityNum(int num) {
		cityNum = num;
	}
	
	public Team getParty() {
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
	
	public HomeBaseSCREEN getHomeBase() {
		return homeBase;
	}
	
}
