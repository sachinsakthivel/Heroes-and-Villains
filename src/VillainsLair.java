import java.util.ArrayList;
import java.util.Arrays;

public class VillainsLair extends Locations{
	
	private int userInput;
	private Villain villain;
	private Hero chosenHero;
	private int chosenGame;
	private diceRolls dice = new diceRolls();
	private rockPaperScissors RPS = new rockPaperScissors();
	private guessTheNumber guess = new guessTheNumber();
	
	
	public VillainsLair(boolean isFinal) {
		super("Villian's Lair");
		if (isFinal) {
			 villain = new finalVillain();
		} else {
			villain = new Villain();
		}
	}
	
	public void travel(Team team) {
		travelledto();
		userInput = -1;
		System.out.println("You have arrived at the Villain's Lair!");
		while (userInput != 0 || !villain.getLiving() || team.getTeam().size() == 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 1);
			if (userInput == 1 ) {
				System.out.println(villain);
				chosenHero = HelperFunctions.heroPick(team.getTeam());
				chosenGame = villain.gamePreference();
				battle(chosenHero, villain, chosenGame);
				chosenHero.checkdeath();
				if (!chosenHero.getLiving()) {
					team.removeOffTeam(chosenHero);
				}
				team.checkDead();
				villain.checkdeath();
			}
			
		}
	}
	
	public void battle(Hero hero, Villain villain, int gameChoice) {
		boolean gameWon;
		if (gameChoice == 0) {
			System.out.println(dice);
			gameWon = dice.play(hero.getDice());
		} else if ( gameChoice == 1) {
			System.out.println(RPS);
			gameWon = RPS.play();
		} else {
			System.out.println(guess);
			gameWon = guess.play(hero.getSkill());
		}
		if (!gameWon) {
			int damage = hero.getArmour() - villain.getDamage();
			hero.setCurrentHealth(hero.getCurrentHealth() + damage);
			System.out.println("Hero's current Health: "+ hero.getCurrentHealth());
		} else {
			villain.setStrikes(villain.getStrikes() - 1);
			System.out.println("Villian's Games Lost : " + villain.getStrikes());
		}
	}
	
	public void menuOptions() {
		System.out.println("0 - Travel Back to Homebase");
		System.out.println("1 - Fight the Villain");
	}
	
	public Villain getVillain() {
		return villain;
	}
	
}
