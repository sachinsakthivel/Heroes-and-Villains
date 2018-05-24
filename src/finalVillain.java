import java.util.*;

/**
 * Date: May 15th 2018
 * 
 * finalVillain class determines attributes and methods of the Final Villain. 
 * 
 * Person and Villain is finalVillain's parent class. The class provides the final Villain 
 * attributes such as Health (in the form of increased Strikes), increased Damage, a 
 * predetermined Minigame preference dependent on the Final Villains Strikes and preset Taunt. 
 * Includes getter and setter methods for some Attributes.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class finalVillain extends Villain{
	
	private Random rand = new Random();

	/**
	 * Constructor method for fianlVillain class.
	 * Name is set Using Parent, Villain class.
	 * Strike attribute is set to 5. Damage is set using Parent, Villain class, plus an additional
	 * 10 damage. Taunt is set to predetermined String Variable.
	 */
	public finalVillain() {
		super();
		this.setStrikes(5);
		this.setTaunt("So, You're are the ones who have been causing my allies so much trouble. *shakes his head* I need to find better allies." );
		this.setDamage(this.getDamage() + 10);
	}
	
	public int gamePreference() {
		if (this.getStrikes() > 3) {
			return rand.nextInt(2);
		} else if (this.getStrikes() == 3) {
			return 0;
		} else if (this.getStrikes() == 2) {
			return 1;
		} else {
			return 2;
		}
	}

	public String toString() {
		String output = new String("This is the end of the Road, I am Known as " +this.getPersonName()+".");
		output += "\n" + this.getTaunt();
		return output;
	}

}