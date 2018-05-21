
public class hypSuggestSkill extends Item {
	
	private final int upperLimit;
	private final String Description;
	
	public hypSuggestSkill() {
		super("Hypnotic Suggestion Skillbook", 90, 0);
			upperLimit = 1;
			Description ="This item allows a Hero to learn the skill of Hypnotic suggestion which helps in the Mini-game 'Guess the Number' by reducing the range given by 1.\nIt is stackable.";
			this.setItemDescription(Description);
	}
	
	public int getUpperLimit() {
		return upperLimit;
	}
	
	public String toString() {
		String returnString = this.getItemName() + " - " + this.getItemStock() + " currently in Team Inventory.";
		returnString += "\n" + this.getItemDescription();
		return returnString;
	}
	
	public String use(Hero hero) {
		if (this.getItemStock() > 0 ) {
			hero.setSkill(hero.getSkill() + upperLimit);
			this.setItemStock(this.getItemStock() - 1);
			return "Power Up Successful";
		} else {
			return "Insufficient amount of "+this.getItemName()+".\nPlease Buy Some from Shop";
		}
	}

}
