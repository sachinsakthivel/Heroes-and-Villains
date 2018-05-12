
public class lesserHeals extends Item {
	private int HealNum;
	private int ItemDuration;
	
	public lesserHeals() {
		super("Lesser Heal Tickets", 20, 0);
		ItemDuration = 30;
		HealNum = 10;
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
