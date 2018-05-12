
public class maxHealthUp extends Item {
	private int MaxUp;
	
	public maxHealthUp() {
		super("Maximum Health Up", 80, 0);
		MaxUp = 20;
	}
	
	public int getMaxUp() {
		return MaxUp;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item increases the Maximum Health of a Hero by " + MaxUp + " points.";
		return returnString;
	}

}
