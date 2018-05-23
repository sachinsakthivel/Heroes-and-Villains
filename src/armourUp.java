/**
 * Date: May 3rd 2018
 * 
 * This class creates the Armour power up Item.
 * 
 * Parent Class is Item. Attributes include amount of Armour and Armour description. Enables Hero to 
 * use Armour Item.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */
public class armourUp extends Item {
	
	/**
	 * An unchangeable Integer variable depicting amount of Armour Item provides.
	 */
	private final int armAmount;
	
	/**
	 * An unchangeable String variable describing the Item, armourUp.
	 */
	private final String Description;
	
	
	/**
	 * Constructor method for Item, armourUp.
	 * Sets Name, Price and Stock using Item Class.
	 * Armour provided set to 5.
	 * An explanation of how the Item, armourUp works is given.
	 */
	public armourUp() {
		super("Armour Piece", 120, 0);
		armAmount = 5;
		Description = "This item increases the Armour of a Hero by " + armAmount + " points. Armour decreases the damage taken by any who wear it.\nIt is stackable";
		this.setItemDescription(Description);
	}
	
	/**
	 * This method returns an Integer variable 'armAmount' meaning amount of armour.
	 * @return Returns Integer armAmount.
	 */
	public int getArmour() {
		return armAmount;
	}
	
	/**
	 * This (toString) method returns a String variable containing Item Name, Stock, and Description.
	 */
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
	/**
	 * This method lets user use armourUp item on Hero.
	 * Checks if Item is available in Team Inventory, if present applies Armour Attribute to Hero. Else alerts the 
	 * user to the lack of the Item.
	 * @param hero Hero Object variable referencing Hero to which the Item will be used on
	 */
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setArmour(hero.getArmour() + armAmount);
			this.setItemStock(this.getItemStock() - 1);
			return "Power Up Successful";
		} else {
			return "Insufficient amount of "+this.getItemName()+".\nPlease Buy Some from Shop";
		}
	}
	

}
