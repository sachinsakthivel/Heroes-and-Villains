/**
 * Date: May 11th 2018
 * 
 * This class creates the Map Item.
 * 
 * Parent Class is Item. Map Item sets all Locations of the current City to discovered. Map Item 
 * Can be bought form shop.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Maps extends Item {
	
	/**
	 * An unchangeable String variable describing the Item, Map.
	 */
	private final String Description;
	
	/**
	 * Constructor method for Item, Map.
	 * Sets Name, Price and Stock using Item class.
	 * An explanation of how the item is stored in the attribute Description.
	 */
	public Maps() {
		super("Map of Cities", 50, 0);
		Description = "This item reveals all the important locations in the current city.";
		this.setItemDescription(Description);
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}

}