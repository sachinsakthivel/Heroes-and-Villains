
public class watchDog extends Hero {
	
	private static int maxHealth = 100;
	private static int Armour = 0;
	private static int Luck = 0;
	
	public watchDog(String name) {
		super(name);
	}
	
	public static String background() {
		String output = "Eyes of a Hawk, always Watching and ever Vigilant.";
		output += "\nA Human Alarm that can catch even the most masterful Thief red-handed.";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
}