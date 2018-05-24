/**
 * Date: May 11th 2018
 * 
 * pathFinder describes and creates a type of hero, Path Finder.
 * 
 * pathFinder's parent class is Hero. This Hero Type has the special ability to scout ahead and 
 * discover the locations surrounding the HomeBase in each City without the help of a Map Item.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class pathFinder extends Hero {
	
	/**
	 * Local variable which determines Hero Types Max Health attribute. (120)
	 */
	private static int maxHealth = 120;
	/**
	 * Local variable which determines Hero Type's Armour attribute. (0)
	 */
	private static int Armour = 0;
	/**
	 * Local variable which determines Hero Type's Luck attribute. (0)
	 */
	private static int Luck = 0;
	
	/**
	 * Constructor method for pathFinder class.
	 * Which creates a instance of a Hero, Path Finder, with a Name, Health, and Type.
	 * Other attributes are set to default.
	 * @param name Input String variable used as Name for the Hero.
	 */
	public pathFinder(String name) {
		super(name);
		this.setType("Path Finder");
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
	}
	
	/**
	 * This method returns a description about the Hero Type.
	 * @return Returns a String output containing a multi-line description of the Hero.
	 */
	public static String background() {
		String output = "Guides who lead the way for the team, they have excellent analysis skills, exceptional memory "; 
		output += "\nWill Automatically reveal all the Possible Locations that can be travelled to from the HomeBase";
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