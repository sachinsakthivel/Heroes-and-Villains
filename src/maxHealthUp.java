/**
 * Date: May 5th 2018
 * 
 * This class creates the MaxHealthUp Potion, Health attribute power up Item.
 * 
 * Parent Class is Item. Attributes include Description and amount of Health increased. Enables Hero to 
 * use MaxHealthUp Potion Item.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class maxHealthUp extends Item {
	
	/**
	 * An unchangeable Integer variable depicting amount of Maximum Health increased when item is applied.
	 */
	private final int MaxUp;
	/**
	 * An unchangeable String variable describing the Item, maxHealthUp.
	 */
	private final String Description;
	
	
	/**
	 * Constructor method for Item, maxHealthUp.
	 * Sets Name, Price and Stock using Item Class.
	 * Integer variable set to 20.
	 * An explanation of how the Item, maxHealthUp works is given in the Description.
	 */
	public maxHealthUp() {
		super("MaxHealthUp Potions", 80, 0);
		MaxUp = 20;
		Description = "This item increases the Maximum Health of a Hero by " + MaxUp + " points.";
		this.setItemDescription(Description);
	}
	
	/**
	 * This method returns an Integer variable 'MaxUp' meaning amount of Maximum Health increased.
	 * @return Returns Integer MaxUp.
	 */
	public int getMaxUp() {
		return MaxUp;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
	/**
	 * This method lets user use maxHealthUp item on Hero.
	 * Checks if Item is available in Team Inventory, if present increases Max Health Attribute of Hero. Else 
	 * alerts the user to the lack of the Item.
	 * @param hero Hero Object variable referencing Hero to which the Item will be used on.
	 */
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setMaximumHealth(hero.getMaximumHealth() + MaxUp);
			this.setItemStock(this.getItemStock() - 1);
			return "Power Up Successful";
		} else {
			return "Insufficient amount of " + this.getItemName() + ".\nPlease Buy Some from Shop";
		}
	}

}
