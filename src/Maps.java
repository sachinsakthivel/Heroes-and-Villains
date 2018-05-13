
public class Maps extends Item {
	
	private final String Description;
	
	public Maps() {
		super("Map of Cities", 50, 0);
		Description = "This item reveals all the important locations in the current city.";
		this.setItemDescription(Description);
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}

}