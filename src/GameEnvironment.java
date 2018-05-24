/**
 * Date: April 29th 2018
 * 
 * The main class of the Game that runs the game.
 * 
 * The game is broken down in to two sections determined by progression. Setting up the game, team and heroes
 * are linear progression while the each city would be considered circular progression. The setup GUI and the 
 * city loops are launched form this class.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */
public class GameEnvironment {
	
	/**
	 * Local int value depicting the number of city the player is progressing through at the moment.
	 */
	private int cityNum;
	/**
	 * Local variable referencing the current Home base symbolizing a city.
	 */
	private  HomeBaseSCREEN homeBase;
	/**
	 * Local variable referencing the current player created team.
	 */
	private Team chosenTeam;
	/**
	 * Local variable referencing all data stored in the current city level.
	 */
	private City currentCity;
	/**
	 * Local variable used to instantiate a new battle screen.
	 */
	private battleSCREEN battle;
		
	/**
	 * This method starts a new game and launches the Start up screen.
	 */
	public void setGame() {
		GameEnvironment game = new GameEnvironment();
		game.launchStartUpSCREEN();
	}
	
	/**
	 * This method instantiate and launches the GUI element StartUpSCREEN which has the options to start a game or quit the application.
	 */
	public void launchStartUpSCREEN() {
		StartUpSCREEN StartUp = new StartUpSCREEN(this);
	}
	
	/**
	 * This Method closes the GUI element StartUpSCREEN and launches the next GUI element, the GameSetupSCREEN.
	 * @param mainMenu The GUI element StartUpSCREEN 
	 */
	public void closeMainScreen(StartUpSCREEN mainMenu) {
		mainMenu.closeSCREEN();
		launchGameSetupSCREEN();
	}
	
	/**
	 * This method instantiate and launches the GUI element GameSetupSCREEN which lets the user create a team, specify a team size 
	 * and the number of cities the user would like to explore.
	 */
	public void launchGameSetupSCREEN() {
		GameSetupSCREEN GameSetup = new GameSetupSCREEN(this);
	}
	
	/**
	 * This method closes the GUI element GameSetupSCREEN uses the data gathered to setup the Circular progression loop. 
	 * The GUI element HeroSetupSCREEN is launched after the creation of a team for the current game.
	 * @param setup The data gathered in the GUI element GameSetupSCREEN is passed on to the current method.
	 */
	public void closeSetupScreen(GameSetupSCREEN setup) {
		setup.closeSCREEN();
		cityNum = setup.getNoCities();
		chosenTeam = new Team(setup.getTeamName(), setup.getNoHeroes());
		launchHeroSetupSCREEN();
	}
	
	/**
	 * This method instantiate and launches the GUI element HeroSetupSCREEN which lets the user create a hero giving it a name and 
	 * choosing a hero type.
	 */
	public void launchHeroSetupSCREEN() {
		HeroSetupSCREEN heroSetup = new HeroSetupSCREEN(this);
	}
	
	/**
	 * This method closes the current GUI element HeroSetupSCREEN.
	 * @param heroCreate Variable referencing the instance of the GUI element HeroSetupSCREEN currently being displayed
	 */
	public void closeHeroSetupScreen(HeroSetupSCREEN heroCreate) {
		heroCreate.closeSCREEN();
	}
	
	/**
	 * This method instantiate and launches the GUI element HomeBaseSCREEN which represents each city and a boolean variable
	 *  to identify if the HomeBaseSCREEN being created represents the Final city of the users playthrough.
	 * @param isFinal Variable which is used to verify if the HomeBaseSCREEN being created represents the Final city of the users playthrough.
	 */
	public void launchHomeBaseSCREEN(boolean isFinal) {
		homeBase = new HomeBaseSCREEN(this, isFinal);
	}
	
	/**
	 * This method closes the current GUI element HomeBaseSCREEN.
	 * @param home Variable referencing the instance of the GUI element HomeBaseSCREEN currently being displayed.
	 */
	public void closeHomeBaseSCREEN(HomeBaseSCREEN home) {
		home.closeSCREEN();
	}
	
	/**
	 * This method instantiate and launches the GUI element PowerUpSCEEN which enables users to upgrade skills of their heroes.
	 * The current HomeBaseSCREEN is hidden and the PowerUPSCREEN is launched. HomeBaseSCREEN is updated.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 */
	public void launchPowerUpSCREEN(HomeBaseSCREEN homeBase) {
		homeBase.getFrame().setVisible(false);
		PowerUpSCREEN powerUp = new PowerUpSCREEN(this);
		homeBase.updateButton();
	}
	
	/**
	 * This method closes the GUI element PowerUpSCREEN currently being displayed. The user's Homebase is subjected to a random event. 
	 * Then the current HomeBaseSCREEN is set to visible.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 * @param powerUp Variable referencing the instance of the GUI element PowerUpSCREEN that was used.
	 */
	public void closePowerUpSCREEN(HomeBaseSCREEN homeBase, PowerUpSCREEN powerUp) {
		powerUp.closeSCREEN();
		homeBase.randomEvents();
		homeBase.getFrame().setVisible(true);
	}
	
	/**
	 * This method instantiate and launches the GUI element ShopSCREEN which enables the user to buy items for the team using their gold.
	 * The current HomeBaseSCREEN is hidden and the ShopSCREEN is launched. HomeBaseSCREEN is updated.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 */
	public void launchShopSCREEN(HomeBaseSCREEN homeBase) {
		homeBase.getFrame().setVisible(false);
		ShopSCREEN ShopWindow = new ShopSCREEN(this);
		homeBase.updateButton();
		
	}
	
	/**
	 * This method closes the GUI element ShopSCREEN currently being displayed. The user's Homebase is subjected to a random event. 
	 * Then the current HomeBaseSCREEN is set to visible.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 * @param Shop Variable referencing the instance of the GUI element ShopSCREEN that was used.
	 */
	public void closeShopSCREEN(HomeBaseSCREEN homeBase, ShopSCREEN Shop) {
		Shop.closeSCREEN();
		homeBase.randomEvents();
		homeBase.getFrame().setVisible(true);
	}
	
	/**
	 * This method instantiate and launches the GUI element HospitalSCREEN which enables the user to heal heroes with items purchased at the shop.
	 * The current HomeBaseSCREEN is hidden and the HospitalSCREEN is launched. HomeBaseSCREEN is updated.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 */
	public void launchHospitalSCREEN(HomeBaseSCREEN homeBase) {
		homeBase.getFrame().setVisible(false);
		hospitalSCREEN hospital = new hospitalSCREEN(this);
		homeBase.updateButton();
	}
	
	/**
	 * This method closes the GUI element HospitalSCREEN currently being displayed. The user's Homebase is subjected to a random event. 
	 * Then the current HomeBaseSCREEN is set to visible.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 * @param hospital Variable referencing the instance of the GUI element HospitalSCREEN that was used.
	 */
	public void closeHospitalSCREEN(HomeBaseSCREEN homeBase, hospitalSCREEN hospital) {
		hospital.closeSCREEN();
		homeBase.randomEvents();
		homeBase.getFrame().setVisible(true);
	}

	
	/**
	 * This method instantiate and launches the GUI element VillainLairSCREEN which enables the user to fight the city's villain using heroes available 
	 * to them. The current HomeBaseSCREEN is hidden and the VillainLairSCREEN is launched. HomeBaseSCREEN is updated.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 */
	public void launchVillainLairSCREEN(HomeBaseSCREEN homeBase) {
		homeBase.getFrame().setVisible(false);
		VillainsLairSCREEN villainLair = new VillainsLairSCREEN(this);
		homeBase.updateButton();
	}
	
	/**
	 * This method uses the toHomeBase to determine whether the user wants to fight the villain or return to the homebase. If toHomebase is True
	 * the method closes the GUI element VillainLairSCREEN currently being displayed. The user's Homebase is subjected to a random event. 
	 * Then the current HomeBaseSCREEN is set to visible. If the user decides to fight the villain then toHomebase is set to false and the method 
	 * just closes the GUI element VillainLairSCREEN currently being displayed.
	 * @param homeBase Variable referencing the instance of the GUI element HomeBaseSCREEN currently being used.
	 * @param villainLair Variable referencing the instance of the GUI element VillainLairSCREEN that was used.
	 * @param toHomeBase Boolean value which if true indicates that user want to return to homebase, otherwise indicates the user wishes to fight the villain.
	 */
	public void closeVillainLairSCREEN(HomeBaseSCREEN homeBase, VillainsLairSCREEN villainLair, boolean toHomeBase) {
		villainLair.closeSCREEN();
		if(toHomeBase) {
			homeBase.randomEvents();
			homeBase.getFrame().setVisible(true);
		}
	}
	
	/**
	 * This method instantiate and launches the GUI element BattleSCREEN which lets the user to select a hero and battle the villain.
	 */
	public void launchBattleSCREEN() {
		battle = new battleSCREEN(this);
	}
	
	/**
	 * This method closes the current GUI element BattleSCREEN and creates a new instance of the GUI element VillainLairSCREEN.
	 * @param battle Variable referencing the instance of the GUI element BattleSCREEN currently being displayed.
	 */
	public void closeBattleSCREEN(battleSCREEN battle) {
		battle.closeSCREEN();
		VillainsLairSCREEN villainLair = new VillainsLairSCREEN(this);
	}
	
	/**
	 * This method instantiate and launches the GUI element DiceRollsSCREEN which lets the user battle the villain with the minigame Dice Roll.
	 * @param chosenHero Variable referencing the hero chosen to face the villain in the Dice Roll minigame.
	 */
	public void launchDiceRollsSCREEN(Hero chosenHero) {
		diceRollsSCREEN dice = new diceRollsSCREEN(this, chosenHero);
	}
	
	/**
	 * This method closes the current GUI element DiceRollsSCREEN and creates a new instance of the GUI element BattleSCREEN.
	 * @param dice Variable referencing the instance of the GUI element DiceRollsSCREEN currently being displayed.
	 */
	public void closeDiceRollsSCREEN(diceRollsSCREEN dice) {
		dice.closeSCREEN();
		battleSCREEN battle = new battleSCREEN(this);
	}
	
	/**
	 * This method instantiate and launches the GUI element RockPaperSCREEN which lets the user battle the villain with the minigame Rock Paper Scissors.
	 * @param chosenHero Variable referencing the hero chosen to face the villain in the Rock Paper Scissors minigame.
	 */
	public void launchRockPaperSCREEN(Hero chosenHero) {
		rockPaperSCREEN rps = new rockPaperSCREEN(this, chosenHero);
	}
	
	/**
	 * This method closes the current GUI element rockPaperSCREEN and creates a new instance of the GUI element BattleSCREEN.
	 * @param rps Variable referencing the instance of the GUI element rockPaperSCREEN currently being displayed.
	 */
	public void closeRockPaperSCREEN(rockPaperSCREEN rps) {
		rps.closeSCREEN();
		battleSCREEN battle = new battleSCREEN(this);
	}
	
	/**
	 * This method instantiate and launches the GUI element DiceRollsSCREEN which lets the user battle the villain with the minigame Guess the Number.
	 * @param chosenHero Variable referencing the hero chosen to face the villain in the Guess the Number minigame.
	 */
	public void launchGuessNumber(Hero chosenHero) {
		GuessTheNumberSCREEN GuessGame = new GuessTheNumberSCREEN(this, chosenHero);
	}
	
	/**
	 * This method closes the current GUI element GuessTheNumberSCREEN and creates a new instance of the GUI element BattleSCREEN.
	 * @param GuessGame Variable referencing the instance of the GUI element GuessTheNumberSCREEN currently being displayed.
	 */
	public void closeGuessNumber(GuessTheNumberSCREEN GuessGame) {
		GuessGame.closeSCREEN();
		battleSCREEN battle = new battleSCREEN(this);
	}
	  
	/**
	 * This method instantiate and launches the GUI element ExitSCREEN which is window displayed when the user quits, finishes, or fail to finish the game. 
	 */
	public void launchExitSCREEN() {
		ExitSCREEN exit = new ExitSCREEN();
	}
	
	/**
	 * This method takes an instance of team as input and sets it to chosenTeam.
	 * @param team Variable instance of team used as input.
	 */
	public void setParty(Team team) {
		chosenTeam = team;
	}
	
	/**
	 * This method takes an int num as input and set it as the cityNum meaning the number of the current city.
	 * @param num Int variable referencing the no of the current city.
	 */
	public void setCityNum(int num) {
		cityNum = num;
	}
	
	/**
	 * This method return the current team object used in GameEnvironment class.
	 * @return Returns a team object.
	 */
	public Team getParty() {
		return chosenTeam;
	}

	/**
	 * This method return the current city object in use by the GameEnvironment class.
	 * @return Returns a city object.
	 */
	public City getCurrentCity() {
		return currentCity;
	}
	
	/**
	 * This method returns int cityNum representing the number of the current city in use by GameEnvironment class.
	 * @return Returns integer cityNum.
	 */
	public int getCityNum() {
		return cityNum;
	}

	/**
	 * This method sets the city object currentCity to city object received through input.
	 * @param currentCity Variable referencing input city object.
	 */
	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}
	
	/**
	 * This method return the current GUI element HomeBaseSCREEN, homeBase in use by the GameEnvironment class.
	 * @return Returns GUI element HomeBaseSCREEN, homeBase.
	 */
	public HomeBaseSCREEN getHomeBase() {
		return homeBase;
	}
	
}
