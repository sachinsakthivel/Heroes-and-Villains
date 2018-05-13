
public class riggedDice extends Item{
	
	private int upperRollLimit;
	
	public riggedDice() {
		super("Weighted Dice", 60, 0);
			upperRollLimit = 1;
	}
	
	public int getRollLimit() {
		return upperRollLimit;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item increases the chances of a Hero winning the Dice mini-game that a villian might play by 10%.\nIt is stackable.";
		return returnString;
	}
	
	public void use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setDice(hero.getDice() + upperRollLimit);
			this.setItemStock(this.getItemStock() - 1);
			System.out.println("Power Up Successful");
		} else {
			System.out.println("Insufficient amount of "+this.getItemName()+", Please Buy Some from Shop");
		}
	}

}
