
public class greaterHeals extends Item{
	private int HealNum;
	
	public greaterHeals() {
		super("Greater Heal Tickets", 100, 120, 0);
		HealNum = 50;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item heals " + HealNum + " hp points in " + this.getItemDuration() + " seconds.";
		return returnString;
	}
}
