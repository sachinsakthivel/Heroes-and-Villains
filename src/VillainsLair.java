import java.util.*;

public class VillainsLair extends Locations{
	
	private Villain villain;
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
	}
	
	public void gameResults(boolean gameWon, Hero hero, Villain villain, GameEnvironment game) {
		if (!gameWon) {
			int damage = hero.getArmour() - villain.getDamage();
			hero.setCurrentHealth(hero.getCurrentHealth() + damage);
		} else {
			villain.setStrikes(villain.getStrikes() - 1);
		}
		hero.checkdeath();
		if(!hero.getLiving()) {
			game.getParty().removeOffTeam(hero);
		}
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
