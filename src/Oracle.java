
public class Oracle extends Hero {
	
	private static int maxHealth = 90;
	private static int Armour = 0;
	private static int Luck = 0;
	private static int abilityCount = 5;
	
	public Oracle(String name) {
		super(name);
		this.setActive(true);
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
		this.setType("Oracle");
		this.setAbilityCount(abilityCount);
	}
	
	public static String background() {
		String output = "A Person of Faith, God's Gifted Child.";
		output += "\nHas the Power make Miracles Happen.";
		output += "Miracles that Heal a Person's Mind, Body and Soul Completly and Instantly. Can Only do this "+abilityCount+" times.";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
	
	public void ability(Team team) {
		if (this.getAbilityCount() < 1) {
			System.out.println("Hero Cannot Use their Ability Any More.");
		} else {
		Hero chosenHero = HelperFunctions.heroPick(team.getTeam());
		chosenHero.setCurrentHealth(chosenHero.getMaximumHealth());
		System.out.println(chosenHero + " has been fully Healed.");
		}
	}
}