import java.util.*;

public class finalVillain extends Villain{
	
	private Random rand = new Random();

	public finalVillain() {
		super();
		this.setStrikes(5);
		this.setTaunt("So, You're are the ones who have been causing my allies so much trouble. *shakes his head* I need to find better allies." );
	}
	
	public int gamePreference() {
		if (this.getStrikes() > 3) {
			return rand.nextInt(2);
		} else if (this.getStrikes() == 3) {
			return 0;
		} else if (this.getStrikes() == 2) {
			return 1;
		} else {
			return 2;
		}
	}

	public String toString() {
		String output = new String("This is the end of the Road, I am Known as " +this.getPersonName()+".");
		output += "\n" + this.getTaunt();
		return output;
	}

}