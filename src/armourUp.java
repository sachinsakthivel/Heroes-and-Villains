
public class armourUp extends Item {
	
	private final int armAmount;
	private final String Description;
	
	public armourUp() {
		super("Armour Piece", 120, 0);
		armAmount = 5;
		Description = "This item increases the Armour of a Hero by " + armAmount + " points. Armour decreases the damage taken by any who wear it.\nIt is stackable";
		this.setItemDescription(Description);
	}
	
	public int getArmour() {
		return armAmount;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
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
