
public class LesserHeals extends Item {
	private int HealNum;
	
	public LesserHeals() {
		super("Lesser Heal Tickets", 20, 30, 0);
		HealNum = 10;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item heals " + HealNum + " hp points in " + this.getItemDuration() + " seconds.";
		return returnString;
	}
	
}
