/**
 * Date: May 12th 2018
 * 
 * Guardian describes and creates a type of hero, Guardian.
 * 
 * Guardian's parent class is Hero. This Hero Type has the double the normal health which makes the
 * Hero Type able to endure more damage from the Villain.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Guardian extends Hero {
	
	/**
	 * Local variable which determines Hero Types Max Health attribute. (200)
	 */
	private static int maxHealth = 200;
	/**
	 * Local variable which determines Hero Type's Armour attribute. (0)
	 */
	private static int Armour = 0;
	/**
	 * Local variable which determines Hero Type's Luck attribute. (0)
	 */
	private static int Luck = 0;
	
	/**
	 * Constructor method for Guardian class.
	 * Which creates a instance of a Hero, Guardian, with a Name, Health, and Type.
	 * Other attributes are set to default.
	 * @param name Input String variable used as Name for the Hero.
	 */
	public Guardian(String name) {
		super(name);
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
		this.setType("Guardian");
	}
	
	/**
	 * This method returns a description about the Hero Type.
	 * @return Returns a String output containing a multi-line description of the Hero.
	 */
	public static String background() {
		String output = "Blessed by the Gods with a body almost Inhumanly Strong.\nTrained with Unwavering Determination to make his Body Tougher than Steel.";
		output += "\nThese Soldiers stand at the pinnacle of Human Might";
		return output;
	}
	
	/**
	 * This method returns attribute values of the Hero Type. Including MaxHealth, Armour and Luck.
	 * @return Returns a String containing information about the attributes of the Hero Type.
	 */
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
}
