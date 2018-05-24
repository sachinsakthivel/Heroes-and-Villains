/**
 * Date: May 5th 2018
 * 
 * This class creates the Skill attribute, power up, Item.
 * 
 * Parent Class is Item. Skill attribute of a Hero increases its chances of wining the Guess the
 * Number minigame. Attributes include upperLimit (Skill attribute) and description of Item. 
 * Enables Hero to use hypSuggestSkill Item.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class hypSuggestSkill extends Item {
	
	/**
	 * An unchangeable Integer variable depicting amount of Skill increase the Item provides.
	 */
	private final int upperLimit;
	
	/**
	 * An unchangeable String variable describing the Item, hypSuggestSkill.
	 */
	private final String Description;
	
	
	/**
	 * Constructor method for Item, hypSuggestSkill.
	 * Sets Name, Price and Stock using Item Class.
	 * Skill provided set to 1.
	 * An explanation of how the Item, Hypnotic Suggestion Skillbook works is stored in Description.
	 */
	public hypSuggestSkill() {
		super("Hypnotic Suggestion Skillbook", 90, 0);
			upperLimit = 1;
			Description ="This item allows a Hero to learn the skill of Hypnotic suggestion which helps in the Mini-game 'Guess the Number' by reducing the range given by 1.\nIt is stackable.";
			this.setItemDescription(Description);
	}
	
	/**
	 * This method returns the Integer variable upperLimit depicting amount of
	 *  Skill increase the Item provides.
	 * @return Returns Integer 'upperLimit' Skill the Item provides.
	 */
	public int getUpperLimit() {
		return upperLimit;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
	/**
	 * This method lets user use hypSuggestSkill item on Hero.
	 * Checks if Item is available in Team Inventory, if present increases Skill Attribute of 
	 * Hero. Else alerts the user to the lack of the Item.
	 * @param hero Hero Object variable referencing Hero to which the Item will be used on.
	 */
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setSkill(hero.getSkill() + upperLimit);
			this.setItemStock(this.getItemStock() - 1);
			return "Power Up Successful";
		} else {
			return "Insufficient amount of "+this.getItemName()+".\nPlease Buy Some from Shop";
		}
	}

}
