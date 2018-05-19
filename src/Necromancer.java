
public class Necromancer extends Hero {
	
	private static int maxHealth = 80;
	private static int Armour = 0;
	private static int Luck = 0;
	
	public Necromancer(String name) {
		super(name);
	}
	
	public static String background() {
		String output = "Master of the Mystic Arts. Deciever of Death.";
		output += "\n";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
	
	
}