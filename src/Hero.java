
public class Hero extends Person{
	
	private int currentHealth;
	private int maximumHealth;
	private int Dice;
	private int Skill;
	private int Armour;
	private boolean living;
	
	public Hero(String name) {
		super(name);
		this.maximumHealth = 100;
		this.living = true;
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
		String output = new String("This person is named: " + getPersonName() +"	Current Health: " + getCurrentHealth() + "	Maximum Health: "+ getMaximumHealth());
		output += "\nArmour: " + getArmour() + "	Dice Upgrade: " + getDice()+ "		Hypnotic Skill Upgrade: " + getSkill();
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
