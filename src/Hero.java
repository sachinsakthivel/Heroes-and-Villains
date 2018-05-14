
public class Hero extends Person{
	
	private int currentHealth;
	private int maximumHealth;
	private int Dice;
	private int Skill;
	private int Armour;
	
	public Hero(String name) {
		super(name);
		this.maximumHealth = 100;
		this.currentHealth = 100;
		this.Dice = 0;
		this.Skill = 0;
		this.Armour = 0;
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
	
	public void setCurrentHealth(int Health) {
		this.currentHealth = Health;
	}
	
	
	public void checkdeath() {
		if (currentHealth < 1) {
			System.out.println("This Hero has Died.");
			this.setLiving(false);
		}
	}

	public String toString() {
		String output = new String("This person is named: " + getPersonName() +"\nCurrent Health: " + getCurrentHealth() + "\nMaximum Health: "+ getMaximumHealth());
		output += "\nArmour: " + getArmour() + "\nLuck: " + (getSkill() + getDice());
		return output; 
	}

	public int getDice() {
		return Dice;
	}

	public void setDice(int dice) {
		Dice = dice;
	}

	public int getSkill() {
		return Skill;
	}

	public void setSkill(int skill) {
		Skill = skill;
	}

	public int getArmour() {
		return Armour;
	}

	public void setArmour(int armour) {
		Armour = armour;
	}

	

}
