
public class VilliansLair extends Locations{
	
	public VilliansLair(boolean isFinal) {
		super("Villian's Lair");
		if (isFinal) {
			System.out.println("Creating a Final Villain");
		} else {
			System.out.println("Creating a Villain");
		}
	}
	
	public void travel(Team team) {
		travelledto();
		System.out.println("There is a fine line between bravery and foolishness, I do not on which side you Heroes stand upon, Show me!");
		System.out.println("You have encountered the Boss of this City");
	}
	
	public void gameWon(Hero chosenhero, Villain chosenVillian) {
	chosenhero.setCurrentHealth(chosenhero.getCurrentHealth() - chosenVillian.getDamageAmount());
	if (chosenhero.getCurrentHealth() <= 0 ) {
		chosenhero.setLiving(true);
		}
	}
}
