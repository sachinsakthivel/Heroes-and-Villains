
public class Trickster extends Hero {
	
	private static int maxHealth = 100;
	private static int Armour = 0;
	private static int Luck = 4;
	
	public Trickster(String name) {
		super(name);
		this.setDice(2);
		this.setSkill(2);
	}
	
	public static String background() {
		String output = "A Free Will with no Restrictions, Commitments or Morals.\nBlessed With Wit and loved by Lady Luck";
		output += "A Jack of All Trades, A Master of None.\nTravelling the World aimlessly without a Purpose";
		return output;
	}
	
	public static String getStats() {
		String output = "Maximum Health: " + maxHealth;
		output += "\nArmour: " + Armour;
		output += "\nLuck: " + Luck;
		return output;
		
	}
}