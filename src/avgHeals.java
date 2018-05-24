import java.util.Random;
/**
 * Date: May 5th 2018
 * 
 * This class creates the Average Health Restore Item, avgHeals.
 * 
 * Parent Class is Item. Attributes include amount of HealBase, Duration and description. Enables Hero to 
 * use avgHeals Item.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */
public class avgHeals extends Item {
	
	/**
	 * An unchangeable Integer variable depicting amount of Health that can be restored.
	 */
	private final  int HealBase;
	
	/**
	 * An unchangeable Integer variable depicting Duration the Item takes to come into effect.
	 */
	private final int Duration;
	
	/**
	 * An unchangeable String variable describing the Item, avgHeals.
	 */
	private final String Description;
	
	/**
	 * A local variable of Random class, to determine the bonus Health restored.
	 */
	private Random rand = new Random();
	
	/**
	 * Constructor method for Item, avgHeals.
	 * Sets Name, Price and Stock using Item Class.
	 * Health restored, HealBase, is set to 25.
	 * An explanation of how the Item, avgHeals work is given.
	 */
	public avgHeals() {
		super("Average Heal Tickets", 50, 0);
		HealBase = 25;
		Duration = 2;
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
	
	/**
	 * This (toString) method returns a String variable containing Item Name, Stock, and Description.
	 */
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.Description;
		return returnString;
	}
	
	/**
	 * This method lets user use 'avgHeals' item on Hero.
	 * Checks if Item is available in Team Inventory, if present restores 25 to 30 Health (randomized) over 2 minutes of Hero. 
	 * Else alerts the user to the lack of the Item.
	 * @param hero Hero Object variable referencing Hero to which the Item will be used on
	 */
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			int heroHealthUpdate = hero.getCurrentHealth() + rand.nextInt(5) + HealBase;
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
