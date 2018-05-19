
public class Tank extends Hero {
	
	private static int maxHealth;
	private static int Armour;
	private static int Luck;
	
	public Tank(String name) {
		super(name);
		maxHealth = 125;
		Armour = 5;
		Luck = 0;
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(Armour);
		this.setArmour(Armour);
	}
	
	public static String background() {
		String output = "Back story of the Tank is not decided yet.";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
}
