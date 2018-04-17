
public class Person {
	
	private String personName;
	private int currentHealth = 100;
	private int maximumHealth = 100;
	private boolean living = true;
	
	public Person(String name) {
		personName = name;
		
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

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
	
	
	
	
	
	
	

}
