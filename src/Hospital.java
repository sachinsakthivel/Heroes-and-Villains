import java.util.*;

public class Hospital extends Locations {
	
	private int userInput;
	private Hero chosenHero;
	private Item chosenItem;
	private int healStartIndex = 0;
	private int healEndIndex = 3;
	private Timer timer = new Timer();
	
	public Hospital() {
		super("General Hosptial");
	}
	
	public void travel(GameEnvironment game) {
		travelledto();
		System.out.println("Welcome to the General Hosptial of this City");
		userInput = -1;
		while (userInput != 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 2);
			if (userInput == 1) {
			chosenHero = HelperFunctions.heroPick(game.getParty().getTeam());
			chosenItem = HelperFunctions.itemPick(game.getParty().getInv(), healStartIndex, healEndIndex);
			healingprocedure(game.getParty());
			System.out.println("You want to Heal Anyone Else?");
			} else if (userInput == 2) {
				visitWard(game.getParty().getWard());
			} else {
				System.out.println("Be Careful Out There, these are Dangerous Times");
			} 
			
		}		
	}
	
	public void menuOptions() {
		System.out.println("What would you like to do? (Input the Number that Corresponds with your Choice) ");
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
			team.moveToWard(chosenHero);
			timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
				    team.releaseFromWard(chosenHero);
				  }
				}, chosenItem.getItemDuration()*60*1000);
		}
	}
	
	public void visitWard(ArrayList<Hero> ward) {
		if (ward.size() > 0) {
			for (Hero patient: ward) {
				System.out.println("Person Name: " + patient.getPersonName());
			}
		} else {
			System.out.println("There are currenlty no Heroes Healing in Ward." + "\n");
		}
	}

}
