import java.util.*;

/**
 * Date: May 17th 2018
 * 
 * This class creates Location, Villain's Lair.
 * 
 * The VillainsLair class's parent class is Locations. This class creates a Villain's Lair for 
 * each city. Creates new instances of minigames and manages the outcome of the minigame by 
 * dealing damage to the relevant party.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class VillainsLair extends Locations{
	
	/**
	 * Local variable 'villain' of type Villain created for the User to battle.
	 */
	private Villain villain;
	/**
	 * A new Instance of the minigame Dice Roll, created under variable 'dice'.
	 */
	private diceRolls dice = new diceRolls();
	/**
	 * A new Instance of the minigame Rock Paper Scissors, created under variable 'RPS'.
	 */
	private rockPaperScissors RPS = new rockPaperScissors();
	/**
	 * A new Instance of the minigame Guess the Number, created under variable 'guess'.
	 */
	private guessTheNumber guess = new guessTheNumber();
	/**
	 * Local ArrayList variable 'games' which contains miniGames created above.
	 */
	private ArrayList<miniGame> games = new ArrayList<miniGame>(Arrays.asList(dice, RPS, guess));
	
	
	/**
	 * Constructor method for VillainsLair.
	 * Sets the locations Name to "Villian's Lair" using parent class, Locations.
	 * If the input variable 'isFinal' is true, a new instance of finalVillain will be created 
	 * under the variable 'villain' else a normal villain will be created under the same variable.
	 * @param isFinal Input Boolean variable which determines if the current city of the 
	 * play through is the final City.
	 */
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
	
	/**
	 * This method determines the damage given out to either the Hero or the Villain depending 
	 * on which party won the minigame. If Hero is killed, it will be removed off the Team
	 * @param gameWon Input Boolean variable which states whether the Hero won the minigame or 
	 * not. 
	 * @param hero Input variable 'hero' of type Hero, which is the chosen Hero to fight the 
	 * Villain in the minigame.
	 * @param villain Input variable 'villains' of type Villain, which is the chosen Hero to 
	 * fight the Hero in the minigame.
	 * @param game Input variable 'game' of type GameEnviornment which inputs data about all 
	 * aspects of the current game.
	 */
	public void gameResults(boolean gameWon, Hero hero, Villain villain, GameEnvironment game) {
		if (!gameWon) {
			int damage = hero.getArmour() - villain.getDamage();
			if (damage < 0) {
				hero.setCurrentHealth(hero.getCurrentHealth() + damage);
			}
		} else {
			villain.setStrikes(villain.getStrikes() - 1);
		}
		hero.checkdeath();
		if(!hero.getLiving()) {
			game.getParty().removeOffTeam(hero);
		}
	}
	
	/**
	 * This method returns the Villain which resides in the current City.
	 * @return Returns variable 'villain' of type Villain
	 */
	public Villain getVillain() {
		return villain;
	}
	
	/**
	 * This methods returns the ArrayList 'games'.
	 * @return Returns variable 'games' of type ArrayList which contains miniGames.
	 */
	public ArrayList<miniGame> getGames() {
		return games;
	}
	
	/**
	 * This method returns valuable information about the Villain which resides 
	 * in the current City and returns it using String variable 'output'.
	 * @return Returns String variable 'output' containing information about the villain.
	 */
	public String villainInsight() {
		String output = "Insight into the mind of "+villain.getPersonName()+":";
		output += "\n\nDamage: "+villain.getDamage();
		output += "\nGames left to Win until "+villain.getPersonName()+" Dies: "+villain.getStrikes();
		return output;
		}
	
}
