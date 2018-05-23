
public class mentalMonk extends Hero {
	
	private static int maxHealth = 130;
	private static int Armour = 2;
	private static int Luck = 0;
	
	public mentalMonk(String name) {
		super(name);
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
		this.setType("Mental Monk");
	}
	
	public static String background() {
		String output = "To read other first I must read myself.";
		output += "\n*maniac laugh ensues*";
		output += "\nAble to Provide insight on Villain's damage, Health and Game of Choice.";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}

}