import java.util.*;

public class Villain extends Person {
	
	private int damageAmount;
	private String tauntPhrase;
	private int strikes;
	private static ArrayList<String> possibleNames = new ArrayList<String>(Arrays.asList("Angel Slayer", "Whitewash", "Cyclone", "Jester of Years", "Red Saint", "Vex", "Discord", "Inferno",
			"Moors Stalker", "Nashville Psycho", "Blink"));
	private static ArrayList<String> possibleTaunts = new ArrayList<String>(Arrays.asList("I had a brother who fought like you. Keyword: Had. ",
			"Aye! I might be a vain bastard, but you know what allows me to own this keep? You want to know my secret for gaining constant income? Idiots like you.",
			"Why are you standing there? Do you want my autograph before you die?",
			"You interfering hussy!",
			"Would you like to know how you all will Die?",
			"I cannot be caged. I cannot be controlled. Understand this as you die, ever pathetic, ever fools!",
			"YOU'RE GOING TO BE MY NEW MEAT BICYCLE!",
			"THE NIGHT WIND CAN ALWAYS CARRY ONE MORE SCREAM.",
			"There is a fine line between bravery and foolishness, I do not on which side you Heroes stand upon, Show me!"));
	private static Random rand = new Random();
	
	public Villain() {
		super(possibleNames.get(rand.nextInt(possibleNames.size())));
		damageAmount = rand.nextInt(15) + 20;
		tauntPhrase = possibleTaunts.get(rand.nextInt(possibleTaunts.size()));
		strikes = 3;
	}
	
	public int getDamage() {
		return damageAmount;
	}
	
	public void setDamage(int damage) {
		damageAmount = damage;
	}
	
	public int getStrikes() {
		return strikes;
	}
	
	public void setStrikes(int newStrike) {
		strikes = newStrike;
	}
	
	public String getTaunt() {
		return tauntPhrase;
	}
	
	public void setTaunt(String taunt) {
		tauntPhrase = taunt;
	}
	
	public void checkStrikes() {
		if (strikes == 0) {
			this.setLiving(false);
		}
	}
	
	public int gamePreference() {
		return rand.nextInt(2);
	}
	
	public void checkdeath() {
		if (strikes == 0) {
			this.setLiving(false);
			System.out.println("Congratualations, You have Defeated the Villain of This City!!");
		}
	}
	
	
	public String toString() {
		String output = new String("Welcome Heroes, I am known as '" +this.getPersonName()+"'.");
		output += "\n" + this.getTaunt() + "\n";
		return output;
	}
	
}