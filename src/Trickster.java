/**
 * Date: May 12th 2018
 * 
 * Trickster describes and creates a type of hero, Trickster.
 * 
 * Trickster parent class is Hero. This Hero Type has Higher Luck attribute by default which
 * makes the Trickster more likely to win Mini-Games.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Trickster extends Hero {
	
	/**
	 * Local variable which determines Hero Types Max Health attribute. (100)
	 */
	private static int maxHealth = 100;
	/**
	 * Local variable which determines Hero Type's Armour attribute. (0)
	 */
	private static int Armour = 0;
	/**
	 * Local variable which determines Hero Type's Luck attribute. (4)
	 */
	private static int Luck = 4;
	
	
	/**
	 * Constructor method for Trickster class.
	 * Which creates a instance of a Hero, Trickster, with a Name, Dice, and Skill and Type.
	 * Other attributes are set to default.
	 * @param name Input String variable used as Name for the Hero.
	 */
	public Trickster(String name) {
		super(name);
		this.setDice(2);
		this.setSkill(2);
		this.setType("Trickster");
	}
	
	/**
	 * This method returns a description about the Hero Type.
	 * @return Returns a String output containing a multi-line description of the Hero.
	 */
	public static String background() {
		String output = "A Free Will with no Restrictions, Commitments or Morals.\nBlessed With Wit and loved by Lady Luck";
		output += "A Jack of All Trades, A Master of None.\nTravelling the World aimlessly without a Purpose";
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