
public class Maps extends Item {
	
	public Maps() {
		super("Map of Cities", 50, 0);
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item reveals all the important locations in the current city.";
		return returnString;
	}

}