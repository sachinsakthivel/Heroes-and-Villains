/**
 * Date: May 12th 2018
 * 
 * mentalMonk describes and creates a type of hero, Mental Monk.
 * 
 * Mental Monk's parent class is Hero. This Hero Type has the ability to gather information about the villain the Team is facing.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class mentalMonk extends Hero {
	
	/**
	 * Local variable which determines Hero Types Max Health attribute. (130)
	 */
	private static int maxHealth = 130;
	/**
	 * Local variable which determines Hero Type's Armour attribute. (2)
	 */
	private static int Armour = 2;
	/**
	 * Local variable which determines Hero Type's Luck attribute. (0)
	 */
	private static int Luck = 0;
	
	
	/**
	 * Constructor method for mentalMonk class.
	 * Which creates a instance of a Hero, Mental Monk, with a Name, Health, and Type.
	 * Other attributes are set to default.
	 * @param name Input String variable used as Name for the Hero.
	 */
	public mentalMonk(String name) {
		super(name);
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
		this.setType("Mental Monk");
	}
	
	/**
	 * This method returns a description about the Hero Type.
	 * @return Returns a String output containing a multi-line description of the Hero.
	 */
	public static String background() {
		String output = "To read other first I must read myself.";
		output += "\n*maniac laugh ensues*";
		output += "\nAble to Provide insight on Villain's damage, Health and Game of Choice.";
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