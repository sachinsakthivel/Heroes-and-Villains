
public class greaterHeals extends Item{
	private int HealNum;
	private int ItemDuration;
	
	public greaterHeals() {
		super("Greater Heal Tickets", 100, 0);
		HealNum = 50;
		ItemDuration = 120;
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
