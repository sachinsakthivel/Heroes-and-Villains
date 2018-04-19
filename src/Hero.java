enum Heroability {
	WIZARD, TANK, MEDIC, ROGUE, EVASIVE, CLAIRVOYANT, NECROMANCER
}


public class Hero extends Person{
	private Heroability ability;
	private int currentHealth = 100;
	private int maximumHealth = 100;
	private boolean living = true;
	
	public int getCurrentHealth() {
		return currentHealth;
	}
// not too sure about this function
	public void setCurrentHealth(int currentHealth) {
		if (maximumHealth > currentHealth) {
			this.currentHealth = currentHealth; 
		} else {
			System.out.println("Maximum health achieved");
		}
	}

	public int getMaximumHealth() {
		return maximumHealth;
	}

	public void setMaximumHealth(int maximumHealth) {
		this.maximumHealth = maximumHealth;
	}
	
	public boolean getLiving() {
		return living;
	}
	
	public void setLiving(boolean living) {
		this.living = living;
	}
	
	public String toString() {
		String output = new String("This person is named: " + getPersonName() + " and currently has " + getCurrentHealth() +  " health.");
		return output; 
	}

	public Hero(String name, Heroability type) {
		super(name);
		ability = type;
		
	}
	
	public void useability( Hero Chosenhero) {
		
	}
	
	

}
