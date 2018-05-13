
public class maxHealthUp extends Item {
	
	private final int MaxUp;
	private final String Description;
	
	public maxHealthUp() {
		super("MaxHealthUp Potions", 80, 0);
		MaxUp = 20;
		Description = "This item increases the Maximum Health of a Hero by " + MaxUp + " points.";
		this.setItemDescription(Description);
	}
	
	public int getMaxUp() {
		return MaxUp;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
	public void use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setMaximumHealth(hero.getMaximumHealth() + MaxUp);
			this.setItemStock(this.getItemStock() - 1);
			System.out.println("Power Up Successful");
		} else {
			System.out.println("Insufficient amount of " + this.getItemName() + ", Please Buy Some from Shop");
		}
	}

}
