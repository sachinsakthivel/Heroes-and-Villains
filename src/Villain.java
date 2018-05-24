import java.util.*;

/**
 * Date: April 30th 2018
 * 
 * Villain class determines attributes and methods of a Villain. 
 * 
 * Person is Villain's parent class and finalVillain is a subclass of Villain. The class provides
 * Object Villain attributes such as Health (in the form of Strikes), Damage, Mini-Game preference 
 * and Taunts. Includes getter and setter methods for said Attributes.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Villain extends Person {
	
	/**
	 * Local Integer variable indicating the damage that can be inflicted by the Villain.
	 */
	private int damageAmount;
	/**
	 * Local String variable which refers to a Villain's chosen Taunt Phrase.
	 */
	private String tauntPhrase;
	/**
	 * Local Integer variable referring to a Villain's Health in the form of Strikes until defeat.
	 * Loosing a Minigame results in loosing 1 strike.
	 */
	private int strikes;
	/**
	 * Local ArrayList containing String variables of possible Names for a Villain to choose from.
	 */
	private static ArrayList<String> possibleNames = new ArrayList<String>(Arrays.asList("Angel Slayer", "Whitewash", "Cyclone", "Jester of Years", "Red Saint", "Vex", "Discord", "Inferno",
			"Moors Stalker", "Nashville Psycho", "Blink"));
	/**
	 * Local ArrayList containing String variables of possible Taunts for a Villain to choose from.
	 */
	private static ArrayList<String> possibleTaunts = new ArrayList<String>(Arrays.asList("I had a brother who fought like you. Keyword: Had. ",
			"Aye! I might be a vain bastard, but you know what allows me to own this keep? You want to know my secret for gaining constant income? Idiots like you.",
			"Why are you standing there? Do you want my autograph before you die?",
			"You interfering hussy!",
			"Would you like to know how you all will Die?",
			"I cannot be caged. I cannot be controlled. Understand this as you die, ever pathetic, ever fools!",
			"YOU'RE GOING TO BE MY NEW MEAT BICYCLE!",
			"THE NIGHT WIND CAN ALWAYS CARRY ONE MORE SCREAM.",
			"There is a fine line between bravery and foolishness, I do not on which side you Heroes stand upon, Show me!"));
	
	private static Random rand = new Random();
	
	
	/**
	 * Constructor method for Villain Class.
	 * Name is given to the villain from randomly choosing a String Variable from the ArrayList 
	 * 'possibleNames'. Damage is set 20 by default plus a random amount of 0 to 15. Taunt Phrase
	 * is chosen in a similar manner to Name using ArrayList 'possibleTaunts'. Strikes are set 
	 * to 3 by default.
	 */
	public Villain() {
		super(possibleNames.get(rand.nextInt(possibleNames.size())));
		damageAmount = rand.nextInt(15) + 20;
		tauntPhrase = possibleTaunts.get(rand.nextInt(possibleTaunts.size()));
		strikes = 3;
	}
	
	/**
	 * This method returns a Villain's attribute Damage.
	 * @return Returns Integer variable, Damage, of Villain.
	 */
	public int getDamage() {
		return damageAmount;
	}
	
	/**
	 * This method sets a Villain's Damage attribute to input variable 'damage'.
	 * @param damage Integer variable referencing Damage attribute.
	 */
	public void setDamage(int damage) {
		damageAmount = damage;
	}
	
	/**
	 * This method returns a Villain's attribute Strikes.
	 * @return Returns Integer variable, Strikes, of Villain.
	 */
	public int getStrikes() {
		return strikes;
	}
	
	/**
	 * This method sets a Villain's Strike attribute to input variable 'newStrike'.
	 * @param newStrike Integer variable referencing Strike attribute.
	 */
	public void setStrikes(int newStrike) {
		strikes = newStrike;
	}
	
	/**
	 * This method returns a Villain's attribute Taunt.
	 * @return Returns String variable, Taunt, of Villain.
	 */
	public String getTaunt() {
		return tauntPhrase;
	}
	
	/**
	 * This method sets a Villain's Taunt attribute to input variable 'taunt'.
	 * @param taunt String variable referencing Taunt attribute.
	 */
	public void setTaunt(String taunt) {
		tauntPhrase = taunt;
	}
	
	/**
	 * This method returns an Integer variable referencing the minigame which is preferred by 
	 * the villain.
	 * @return Returns Integer variable related to Villan's preferred minigame.
	 */
	public int gamePreference() {
		return rand.nextInt(2);
	}
	
	/**
	 * This method checks whether the Villain is dead by Strikes left. If Strikes is less than 0,
	 * method returns Boolean true, else returns false.
	 * @return Returns true of false depending on Strikes left for the Villain.
	 */
	public boolean checkdeath() {
		if (strikes <= 0) {
			this.setLiving(false);
			return true;
		}
		return false;
	}
	
	
	public String toString() {
		String output = new String("Welcome Heroes, I am known as '" +this.getPersonName()+"'.");
		output += "\n\n" + this.getTaunt() + "\n";
		return output;
	}
	
}