import javax.swing.JOptionPane;

public class Hero extends Person{
	
	private int currentHealth;
	private int maximumHealth;
	private int Dice;
	private int Skill;
	private int Armour;
	private String type;
	
	public Hero(String name) {
		super(name);
		this.maximumHealth = 100;
		currentHealth = maximumHealth;
		Dice = 0;
		Skill = 0;
		Armour = 0;
		
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
			JOptionPane.showMessageDialog(null, "Hero: " +this.getPersonName()+"has been Killed by the Villain" + "\n");
			this.setLiving(false);
		}
	}

	public String toString() {
		String output = new String("This person is named: " + getPersonName() + "\nType: " + getType() +"\nHealth: " + getCurrentHealth() + "/"+ getMaximumHealth());
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

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	

}
