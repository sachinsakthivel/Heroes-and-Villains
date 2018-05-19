
public class Oracle extends Hero {
	
	private static int maxHealth = 90;
	private static int Armour = 0;
	private static int Luck = 0;
	
	public Oracle(String name) {
		super(name);
		this.setActive(true);
	}
	
	public static String background() {
		String output = "A Person of Faith, God's Gifted Child.";
		output += "\nHas the Power make Miracles Happen.";
		output += "Miracles that Heal a Person's Mind, Body and Soul Completly and Instantly.";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
	
	public void ability(Team team) {
		Hero chosenHero = HelperFunctions.heroPick(team.getTeam());
		chosenHero.setCurrentHealth(chosenHero.getMaximumHealth());
		System.out.println(chosenHero + " has been fully Healed.");
	}
}