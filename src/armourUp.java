
public class armourUp extends Item {
	
	private int armAmount;
	
	public armourUp() {
		super("Armor", 120, 0);
		armAmount = 10;
	}
	
	public int getArmour() {
		return armAmount;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item increases the Armour of a Hero by " + armAmount + " points. Armour decreases the damage taken by the any who wear it.\nIt is stackable";
		return returnString;
	}
	
	public void use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setArmour(hero.getArmour() + armAmount);
			this.setItemStock(this.getItemStock() - 1);
			System.out.println("Power Up Successful");
		} else {
			System.out.println("Insufficient amount of "+this.getItemName()+", Please Buy Some from Shop");
		}
	}
	

}
