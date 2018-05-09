
public class avgHeals extends Item{
	private int HealNum;
	
	public avgHeals() {
		super("Average Heal Tickets", 50, 60, 0);
		HealNum = 25;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item heals " + HealNum + " hp points in " + this.getItemDuration() + " seconds.";
		return returnString;
	}
	
}
