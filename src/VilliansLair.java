
public class VilliansLair {
	
	public VilliansLair() {
		
	}
	
	public void gameWon(Hero chosenhero, Villain chosenVillian) {
	chosenhero.setCurrentHealth(chosenhero.getCurrentHealth() - chosenVillian.getDamageAmount());
	if (chosenhero.getCurrentHealth() <= 0 ) {
		chosenhero.setLiving(true);
		}
	}
}
