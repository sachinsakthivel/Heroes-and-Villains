import java.util.*;

public class Hospital extends Locations {
	
	private int userInput;
	private Hero chosenHero;
	private Item chosenItem;
	private int healStartIndex = 0;
	private int healEndIndex = 3;
	private ArrayList<Hero> Ward = new ArrayList<Hero>();
	private Timer timer = new Timer();
	
	public Hospital() {
		super("General Hosptial");
	}
	
	public void travel(Team team) {
		travelledto();
		System.out.println("Welcome to the General Hosptial of this City");
		userInput = -1;
		while (userInput != 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 2);
			if (userInput == 1) {
			chosenHero = HelperFunctions.heroPick(team.getTeam());
			chosenItem = HelperFunctions.itemPick(team.getInv(), healStartIndex, healEndIndex);
			healingprocedure(team);
			System.out.println("You want to Heal Anyone Else?");
			} else if (userInput == 2) {
				visitWard();
			} else {
				System.out.println("Be Careful Out There, these are Dangerous Times");
			} 
			
		}		
	}
	
	public void menuOptions() {
		System.out.println("0 - Return To HomeBase");
		System.out.println("1 - Heal a Hero");
		System.out.println("2 - Visit the Hero Ward");
	}
	
	public void healingprocedure(Team team) {
		if (chosenItem.getItemStock() == 0) {
			System.out.println("Insuffient Required Tickets, Buy from Shop");
		}else if (chosenHero.getCurrentHealth() == chosenHero.getMaximumHealth()) {
			System.out.println("Chosen Hero has no need for Healing, Hero is at Full Health.");
		} else {
			chosenItem.use(chosenHero);
			moveToWard(team ,chosenHero);
			timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
				    releaseFromWard(team, chosenHero);
				  }
				}, chosenItem.getItemDuration()*60*1000);
		}
	}
	
	public void moveToWard(Team team, Hero hero) {
		Ward.add(hero);
		team.removeOffTeam(hero);
		System.out.println("Hero: "+hero.getPersonName()+ " has been moved to Healing Ward from Team.");
	}
	
	public void releaseFromWard(Team team, Hero hero) {
		team.addToTeam(hero);
		Ward.remove(hero);
		System.out.println("Hero: "+hero.getPersonName()+ " has been released from Healing Ward and is ready to fight again.");
	}
	
	public void visitWard() {
		if (Ward.size() > 0) {
			for (Hero patient: Ward) {
				System.out.println("Person Name: " + patient.getPersonName());
			}
		} else {
			System.out.println("There are currenlty no Heroes Healing in Ward.");
		}
	}

}
