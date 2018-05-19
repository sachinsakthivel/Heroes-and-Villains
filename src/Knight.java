
public class Knight extends Hero {
	
	private static int maxHealth = 100;
	private static int Armour = 10;
	private static int Luck = 0;
	
	public Knight(String name) {
		super(name);
		this.setArmour(Armour);
	}
	
	public static String background() {
		String output = "Clad from Head to Toe, in Titanium.\nA Living Breathing Shield with an Unwavering Will";
		output += "\nStanding Tall with Pride at the Frontlines.\nNever Wavering and Protecting those who are weaker from Harm.";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
}

