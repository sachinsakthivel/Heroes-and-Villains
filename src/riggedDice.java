/**
 * Date: May 3rd 2018
 * 
 * This class creates the Dice attribute power up Item.
 * 
 * Parent Class is Item. Dice attribute of a Hero increases its chances of wining the Dice Roll 
 * minigame. Attributes include upperRollLimit (Dice attribute) and description of Item. 
 * Enables Hero to use hypSuggestSkill Item.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class riggedDice extends Item{
	
	/**
	 * An unchangeable Integer variable depicting amount of Dice increase the Item provides.
	 */
	private final int upperRollLimit;
	/**
	 * An unchangeable String variable describing the Item, riggedDice.
	 */
	private final String Description;
	
	
	/**
	 * Constructor method for Item, Weighted Dice, Dice attribute power up Item.
	 * Sets Name, Price and Stock using Item Class.
	 * Dice provided set to 1.
	 * An explanation of how the Item, Weighted Dice works is stored in Description.
	 */
	public riggedDice() {
		super("Weighted Dice", 60, 0);
		upperRollLimit = 1;
		Description = "This item increases the chances of a Hero winning the Dice mini-game that a villian might play by 10%.\nIt is stackable.";
		this.setItemDescription(Description);	
	}
	
	/**
	 * This method returns an Integer variable 'upperRollLimit' meaning amount of Dice increase 
	 * the Item provides.
	 * @return Returns Integer 'upperRollLimit', amount of Dice increase the Item provides.
	 */
	public int getRollLimit() {
		return upperRollLimit;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
	/**
	 * This method lets user use Weighted Dice item on Hero.
	 * Checks if Item is available in Team Inventory, if present increases Dice Attribute of Hero. Else alerts the 
	 * user to the lack of the Item.
	 * @param hero Hero Object variable referencing Hero to which the Item will be used on.
	 */
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setDice(hero.getDice() + upperRollLimit);
			this.setItemStock(this.getItemStock() - 1);
			return "Power Up Successful";
		} else {
			return "Insufficient amount of "+this.getItemName()+". \nPlease Buy Some from Shop";
		}
	}

}
