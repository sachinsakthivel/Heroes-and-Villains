
public class Guardian extends Hero {
	
	private static int maxHealth = 200;
	private static int Armour = 0;
	private static int Luck = 0;
	
	public Guardian(String name) {
		super(name);
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
		this.setType("Guardian");
	}
	
	public static String background() {
		String output = "Blessed by the Gods with a body almost Inhumanly Strong.\nTrained with Unwavering Determination to make his Body Tougher than Steel.";
		output += "\nThese Soldiers stand at the pinnacle of Human Might";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
}
