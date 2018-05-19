
public class Necromancer extends Hero {
	
	private static int maxHealth = 80;
	private static int Armour = 0;
	private static int Luck = 0;
	private static int abilityCount = 3;
	
	public Necromancer(String name) {
		super(name);
		this.setType("Necromancer");
		this.setMaximumHealth(maxHealth);
		this.setCurrentHealth(maxHealth);
		this.setAbilityCount(abilityCount);
	}
	
	public static String background() {
		String output = "Master of the Mystic Arts. Deciever of Death.";
		output += "\nCan revive dead Heroes. \nCan only do this "+abilityCount+" times.";
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
		Hero chosenHero = HelperFunctions.heroPick(team.getGrave());
		chosenHero.setLiving(true);
		chosenHero.setCurrentHealth(chosenHero.getMaximumHealth());
		team.getTeam().add(chosenHero);
		team.getGrave().remove(chosenHero);
		}
	}
	
	
}