
public class riggedDice extends Item{
	
	private final int upperRollLimit;
	private final String Description;
	
	public riggedDice() {
		super("Weighted Dice", 60, 0);
		upperRollLimit = 1;
		Description = "This item increases the chances of a Hero winning the Dice mini-game that a villian might play by 10%.\nIt is stackable.";
		this.setItemDescription(Description);
			
	}
	
	public int getRollLimit() {
		return upperRollLimit;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
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
