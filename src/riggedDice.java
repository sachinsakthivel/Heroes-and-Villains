
public class riggedDice extends Item{
	
	private int upperRollLimit;
	
	public riggedDice() {
		super("Weighted Dice", 60, 0);
			upperRollLimit = 2;
	}
	
	public int getRollLimit() {
		return upperRollLimit;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item increases the chances of a Hero winning the Dice mini-game that a villian might play by 10%.\nIt is stackable.";
		return returnString;
	}

}
