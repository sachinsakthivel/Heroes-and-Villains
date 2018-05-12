
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

}
