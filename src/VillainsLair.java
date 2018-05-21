import java.util.*;

public class VillainsLair extends Locations{
	
	private int userInput;
	private Villain villain;
	private Hero chosenHero;
	private int chosenGame;
	private diceRolls dice = new diceRolls();
	private rockPaperScissors RPS = new rockPaperScissors();
	private guessTheNumber guess = new guessTheNumber();
	private ArrayList<miniGame> games = new ArrayList<miniGame>(Arrays.asList(dice, RPS, guess));
	
	
	public VillainsLair(boolean isFinal) {
		super("Villian's Lair");
		if (isFinal) {
			 villain = new finalVillain();
		} else {
			villain = new Villain();
		}
	}
	
	public void travel(GameEnvironment game) {
		travelledto();
		game.launchVillainLairSCREEN(game.getHomeBase());
		/*
		userInput = -1; 
		System.out.println("You have arrived at the Villain's Lair!");
		while (userInput != 0 && villain.getLiving() && game.getParty().getTeam().size() > 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 1);
			if (userInput == 1 ) {
				System.out.println(villain);
				chosenHero = HelperFunctions.heroPick(game.getParty().getTeam());
				chosenGame = villain.gamePreference();
				battle(chosenHero, villain, chosenGame);
				chosenHero.checkdeath();
				if (!chosenHero.getLiving()) {
					game.getParty().removeOffTeam(chosenHero);
				}
				game.getParty().checkDead();
				villain.checkdeath();
			}
			
		}
		*/
	}
	
	public void battle(Hero hero, Villain villain, int gameChoice) {
		boolean gameWon;
		if (gameChoice == 0) {
			System.out.println(dice);
			gameWon = dice.play(hero);
		} else if ( gameChoice == 1) {
			System.out.println(RPS);
			gameWon = RPS.play(hero);
		} else {
			System.out.println(guess);
			gameWon = guess.play(hero);
		}
		if (!gameWon) {
			int damage = hero.getArmour() - villain.getDamage();
			hero.setCurrentHealth(hero.getCurrentHealth() + damage);
			System.out.println("Hero's current Health: "+ hero.getCurrentHealth() + "\n");
		} else {
			villain.setStrikes(villain.getStrikes() - 1);
			System.out.println("Games left to Win until Villan Dies : " + villain.getStrikes() + "\n");
		}
	}
	
	public void menuOptions() {
		System.out.println("What would you like to do? (Input the Number that Corresponds with your Choice) ");
		System.out.println("0 - Travel Back to Homebase");
		System.out.println("1 - Fight the Villain");
	}
	
	public Villain getVillain() {
		return villain;
	}
	
	public ArrayList<miniGame> getGames() {
		return games;
	}
	
	public String villainInsight() {
		String output = "Insight into the mind of "+villain.getPersonName()+":";
		output += "\n\nDamage: "+villain.getDamage();
		output += "\nGames left to Win until "+villain.getPersonName()+" Dies: "+villain.getStrikes();
		return output;
		}
	
}
