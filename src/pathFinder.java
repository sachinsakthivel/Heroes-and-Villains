
public class pathFinder extends Hero {
	
	private static int maxHealth = 120;
	private static int Armour = 0;
	private static int Luck = 0;
	
	public pathFinder(String name) {
		super(name);
		this.setType("Path Finder");
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
	}
	
	public static String background() {
		String output = "Guides who lead the way for the team, they have excellent analysis skills, exceptional memory "; 
		output += "\nWill Automatically reveal all the Possible Locations that can be travelled to from the HomeBase";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}	
	
}