import java.util.*;

/**
 * This Class contains methods that was use to help facilitate certain action within the game. 
 * These methods is used in a wide area of actions, such as Input validation, and User 
 * Interactions.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 17th 2018
 */

public class HelperFunctions {
	
	/**
	 * This method is used to create a Hero based on the input received through Integer variable
	 * 'userPick' and String 'name'. A new instance of the relevant hero is created and returned.
	 * @param userPick This Integer variable determines the Hero Type of the created Hero
	 * @param name This String variable determines the Name of the newly created Hero.
	 * @return Returns a Hero of specific Hero Type dependent on the Input variables.
	 */
	public static Hero heroCreate(int userPick, String name) {
		if (userPick == 1 ) {
			Guardian newHero = new Guardian(name);
			return newHero;
		} else if (userPick == 2) {
			Knight newHero = new Knight(name);
			return newHero;
		} else if (userPick == 3) {
			Trickster newHero = new Trickster(name);
			return newHero;
		} else if (userPick == 4) {
			watchDog newHero = new watchDog(name);
			return newHero;
		} else if (userPick == 5) {
			pathFinder newHero = new pathFinder(name);
			return newHero;
		} else {
			mentalMonk newHero = new mentalMonk(name);
			return newHero;
		}
	}
	
		
}
