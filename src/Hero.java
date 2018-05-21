
public class Hero extends Person{
	
	private int currentHealth;
	private int maximumHealth;
	private int Dice;
	private int Skill;
	private int Armour;
	private boolean isActive;
	private String type;
	private int abilityCount;
	
	public Hero(String name) {
		super(name);
		this.maximumHealth = 100;
		currentHealth = maximumHealth;
		Dice = 0;
		Skill = 0;
		Armour = 0;
		isActive = false;
		
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
		String output = new String("This person is named: " + getPersonName() + "	Type: " + getType() +"\nHealth: " + getCurrentHealth() + "/"+ getMaximumHealth());
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


	public boolean getisActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void ability(Team team) {
		if (!this.getisActive()) {
			System.out.println("This Hero Does not Have any Active Abilities");
		}
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getAbilityCount() {
		return abilityCount;
	}


	public void setAbilityCount(int abilityCount) {
		this.abilityCount = abilityCount;
	}

	

}
