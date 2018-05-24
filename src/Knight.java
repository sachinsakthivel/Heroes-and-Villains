/**
 * Date: May 12th 2018
 * 
 * Guardian describes and creates a type of hero, Guardian.
 * 
 * Guardian's parent class is Hero. This Hero Type has an abundance of the Armour Attribute 
 * which allows the Knight to take less damage from a villain, allowing it to fight the villain 
 * for longer without the need of a trip to the Hospital.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Knight extends Hero {
	
	/**
	 * Local variable which determines Hero Types Max Health attribute. (100)
	 */
	private static int maxHealth = 100;
	/**
	 * Local variable which determines Hero Type's Armour attribute. (10)
	 */
	private static int Armour = 10;
	/**
	 * Local variable which determines Hero Type's Luck attribute. (0)
	 */
	private static int Luck = 0;
	
	/**
	 * Constructor method for Knight class.
	 * Which creates a instance of a Hero, Knight, with a Name, Armour, and Type.
	 * Other attributes are set to default.
	 * @param name Input String variable used as Name for the Hero.
	 */
	public Knight(String name) {
		super(name);
		this.setArmour(Armour);
		this.setType("Knight");
	}
	
	/**
	 * This method returns a description about the Hero Type.
	 * @return Returns a String output containing a multi-line description of the Hero.
	 */
	public static String background() {
		String output = "Clad from Head to Toe, in Titanium.\nA Living Breathing Shield with an Unwavering Will";
		output += "\nStanding Tall with Pride at the Frontlines.\nNever Wavering and Protecting those who are weaker from Harm.";
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

