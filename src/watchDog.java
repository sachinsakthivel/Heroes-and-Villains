/**
 * Date: May 12th 2018
 * 
 * watchDog describes and creates a type of hero, Watch Dog.
 * 
 * Watch Dog's parent class is Hero. This Hero Type has the ability to prevent undesirable Random Events
 * Occurring when the Team travels.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class watchDog extends Hero {
	
	/**
	 * Local variable which determines Hero Types Max Health attribute. (100)
	 */
	private static int maxHealth = 100;
	
	/**
	 * Local variable which determines Hero Type's Armour attribute. (0)
	 */
	private static int Armour = 0;
	
	/**
	 * Local variable which determines Hero Type's Luck attribute. (0)
	 */
	private static int Luck = 0;
	
	/**
	 * Constructor method for watchDog class.
	 * Which creates a instance of a Hero, Watch Dog, with a Name and Type.
	 * Other attributes are set to default.
	 * @param name Input String variable used as Name for the Hero.
	 */
	public watchDog(String name) {
		super(name);
		this.setType("WatchDog");
	}
	
	/**
	 * This method returns a description about the Hero Type.
	 * @return Returns a String output containing a multi-line description of the Hero.
	 */
	public static String background() {
		String output = "Eyes of a Hawk, always Watching and ever Vigilant.";
		output += "\nA Human Alarm that can catch even the most masterful Thief red-handed.";
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