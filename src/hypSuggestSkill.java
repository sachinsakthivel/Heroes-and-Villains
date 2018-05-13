
public class hypSuggestSkill extends Item {
	
	private int upperLimit;
	
	public hypSuggestSkill() {
		super("Hypnotic Suggestion Skill", 90, 0);
			upperLimit = 1;
	}
	
	public int getUpperLimit() {
		return upperLimit;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + "This item allows a Hero to learn the skill of Hypnotic suggestion which helps in the Mini-game 'Guess the Number' by reducing the range given by 1.";
		returnString += "\nIt is stackable.";
		return returnString;
	}
	
	public void use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setSkill(hero.getSkill() + upperLimit);
			this.setItemStock(this.getItemStock() - 1);
			System.out.println("Power Up Successful");
		} else {
			System.out.println("Insufficient amount of "+this.getItemName()+", Please Buy Some from Shop");
		}
	}

}
