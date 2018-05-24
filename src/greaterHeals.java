import java.util.Random;

/**
 * Date: May 5th 2018
 * 
 * This class creates the Greater Health Restore Item, avgHeals.
 * 
 * Parent Class is Item. Attributes include amount of HealBase, Duration and description. 
 * Enables Hero to use Greater Heal Tickets Item.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class greaterHeals extends Item {
	
	/**
	 * An unchangeable Integer variable depicting amount of Health that can be restored.
	 */
	private final int HealBase;
	/**
	 * An unchangeable Integer variable depicting Duration the Item takes to come into effect.
	 */
	private final int Duration;
	/**
	 * An unchangeable String variable describing the Item, Greater Heal Tickets.
	 */
	private final String Description;
	/**
	 * A local variable of Random class, to determine the bonus Health restored.
	 */
	private Random rand = new Random();
	
	
	/**
	 * Constructor method for Item, greaterHeals.
	 * Sets Name, Price and Stock using Item Class.
	 * Health restored, HealBase, is set to 50. Duration is set to 4 mins.
	 * An explanation of how the Item, Greater Heal Tickets work is stored in Description.
	 */
	public greaterHeals() {
		super("Greater Heal Tickets", 100, 0);
		HealBase = 50;
		Duration = 4;
		this.setItemDuration(Duration);
		Description = "This treatement heals " + HealBase + " hp points or more depending on the treament's sucess rate in " + this.getItemDuration() + " minute.";
		this.setItemDescription(Description);
	}
	
	/**
	 * This method returns an Integer variable 'getHealNum' meaning amount of health restored to Hero.
	 * @return Returns Integer getHealNum.
	 */
	public int getHealNum() {
		return HealBase;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.Description;
		return returnString;
	}
	
	/**
	 * This method lets user use 'greaterHeals' item on Hero.
	 * Checks if Item is available in Team Inventory, if present restores 50 to 60 Health (randomized) 
	 * over 4 minutes of Hero. Else alerts the user to the lack of the Item.
	 * @param hero Hero Object variable referencing Hero to which the Item will be used on.
	 */
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			int heroHealthUpdate = hero.getCurrentHealth() +rand.nextInt(10) + + HealBase;
			if (heroHealthUpdate < hero.getMaximumHealth()) {
				hero.setCurrentHealth(heroHealthUpdate);
			} else {
				hero.setCurrentHealth(hero.getMaximumHealth());
			}
			this.setItemStock(this.getItemStock() - 1);
			String out =  "Healing Procedure Has Started";
			out += " \n\nHero: "+hero.getPersonName()+ " has been moved into Healing Ward from Team." + "\n";
			return out;
		} else {
			return "Insufficient amount of "+this.getItemName()+". \nPlease Buy Some from Shop";
		}
	}
	
}
