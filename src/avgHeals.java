
public class avgHeals extends Item{
	private int HealNum;
	private int ItemDuration;
	
	public avgHeals() {
		super("Average Heal Tickets", 50, 0);
		ItemDuration = 60;
		HealNum = 25;
	}
	
	public int getHealNum() {
		return HealNum;
	}
	
	public int getItemDuration() {
		return ItemDuration;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item heals " + HealNum + " hp points in " + ItemDuration + " seconds.";
		return returnString;
	}
	
}
