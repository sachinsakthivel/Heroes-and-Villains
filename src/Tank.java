
public class Tank extends Hero {
	
	public Tank(String name) {
		super(name);
		int maxHealth = 125;
		int Armour = 5;
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(Armour);
		this.setArmour(Armour);
	}
}
