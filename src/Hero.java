
public class Hero extends Person{
	
	private int currentHealth;
	private int maximumHealth;
	private boolean living;
	
	public Hero(String name) {
		super(name);
		this.maximumHealth = 100;
		this.living = true;
		this.currentHealth = 100;
		typeChoice();
		
	}
	
	public void typeChoice() {
		System.out.println("Type selection is not implemented yet");
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public int getMaximumHealth() {
		return maximumHealth;
	}
	
	public void setMaximumHealth(int maxHealth) {
		this.maximumHealth = maxHealth;
	}
	
	// not too sure about this function
	public void setCurrentHealth(int Health) {
		this.currentHealth = Health;
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

	

}
