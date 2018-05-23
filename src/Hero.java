import javax.swing.JOptionPane;

/**
 * Date: April 29th 2018
 * 
 * Hero class is parent class to all types of Heroes.
 * 
 * The class provides Object Hero attributes such as Health, Skill, Dice, Armour and Maximum Health.  
 * Includes getter and setter methods for Attributes.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Hero extends Person{
	
	/**
	 * Local Integer variable indicating Current Health of Hero. 
	 */
	private int currentHealth;
	/**
	 * Local Integer variable indicating Maximum Health of Hero.
	 */
	private int maximumHealth;
	/**
	 * Local Integer variable indicating attribute which betters chance of success in the Dice Roll minigame.
	 */
	private int Dice;
	/**
	 * Local Integer variable indicating attribute which betters chance of success in the Guess the Number minigame.
	 */
	private int Skill;
	/**
	 * Local Integer variable indicating attribute which reduces damage taken by Hero against a Villain. 
	 */
	private int Armour;
	/**
	 * Local String type variable which refers to the Hero's Special ability. Eg: Tank, Pathfinder, Trickster...
	 */
	private String type;
	
	
	/**
	 * Constructor method for hero class. 
	 * Name given using parent class Person.
	 * Default Maximum Health and Current health of 100 
	 * Dice, Skill and Armour are set to 0 by default.
	 * @param name String variable used to set Hero's Name.
	 */
	public Hero(String name) {
		super(name);
		this.maximumHealth = 100;
		currentHealth = maximumHealth;
		Dice = 0;
		Skill = 0;
		Armour = 0;
	}
	
	/**
	 * This method returns the Integer value, Current Health of Hero.
	 * @return Returns Integer value, Current Health.
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	/**
	 * This method returns the Integer value, Maximum Health of Hero.
	 * @return Returns Integer value, Maximum Health.
	 */
	public int getMaximumHealth() {
		return maximumHealth;
	}
	
	/**
	 * This method sets a Hero's Maximum Health to the input Integer variable 'maxHelath'.
	 * @param maxHealth Input Integer variable which indicated Maximum Health.
	 */
	public void setMaximumHealth(int maxHealth) {
		this.maximumHealth = maxHealth;
	}
	
	/**
	 * This method sets a Hero's Current Health to the input Integer variable 'Health'.
	 * @param maxHealth Input Integer variable which indicated Current Health.	
	 */
	public void setCurrentHealth(int Health) {
		this.currentHealth = Health;
	}
	
	
	/**
	 * This method checks whether the Hero has more than 1 health and if not set Boolean variable Living to false in parent 
	 * class Person. If Hero is dead a popUp window is displayed to the user notifying the user of the Hero's death.
	 */
	public void checkdeath() {
		if (currentHealth < 1) {
			JOptionPane.showMessageDialog(null, "Hero: " +this.getPersonName()+"has been Killed by the Villain" + "\n");
			this.setLiving(false);
		}
	}

	
	/** 
	 * This (toString) methods returns a String variable which gives a description of the Hero which includes the Name, Type, Health presented as Current/Maximum Health, Armour and
	 * Luck which is a combination of Skill and Dice.
	 */
	public String toString() {
		String output = new String("This person is named: " + getPersonName() + "\nType: " + getType() +"\nHealth: " + getCurrentHealth() + "/"+ getMaximumHealth());
		output += "\nArmour: " + getArmour() + "\nLuck: " + (getSkill() + getDice());
		return output; 
	}

	/**
	 * This method returns a Hero's attribute Dice.
	 * @return Returns Integer variable Dice of Hero.
	 */
	public int getDice() {
		return Dice;
	}

	/**
	 * This method sets a Heros Dice attribute to input variable 'dice'.
	 * @param dice Integer variable referencing Dice attribute.
	 */
	public void setDice(int dice) {
		Dice = dice;
	}

	/**
	 * This method returns a Hero's attribute Skill.
	 * @return Returns Integer variable Skill of Hero.
	 */
	public int getSkill() {
		return Skill;
	}

	/**
	 * This method sets a Heros Skill attribute to input variable 'Skill'.
	 * @param skill Integer variable referencing Skill attribute.
	 */
	public void setSkill(int skill) {
		Skill = skill;
	}

	/**
	 * This method returns a Hero's attribute Armour.
	 * @return Returns Integer variable Armour of Hero.
	 */
	public int getArmour() {
		return Armour;
	}

	/**
	 * This method sets a Heros Armour attribute to input variable 'armour'.
	 * @param armour Integer variable referencing Armour attribute.
	 */
	public void setArmour(int armour) {
		Armour = armour;
	}

	/**
	 * This method returns a Hero's Type/Specialty.
	 * @return Returns String variable, Type of Hero.
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method sets a Heros Type attribute to input variable 'type'.
	 * @param type Integer variable referencing type attribute.
	 */
	public void setType(String type) {
		this.type = type;
	}


	

}
