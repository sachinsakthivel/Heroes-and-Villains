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
		game.launchHospitalSCREEN(game.getHomeBase());
		/*userInput = -1;
		while (userInput != 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 2);
			if (userInput == 1) {
			chosenHero = HelperFunctions.heroPick(game.getParty().getTeam());
			chosenItem = HelperFunctions.itemPick(game.getParty().getInv(), healStartIndex, healEndIndex);*/
/*			healingprocedure(game.getParty());
			System.out.println("You want to Heal Anyone Else?");
			} else if (userInput == 2) {
				visitWard(game.getParty().getWard());
			} else {
				System.out.println("Be Careful Out There, these are Dangerous Times");
			}*/
	}
			
	
	public String healingprocedure(Team team, Hero chosenHero, Item chosenItem) {
		if (chosenItem.getItemStock() == 0) {
			String out = "Insuffient Required Tickets, Please buy some from Shop";
			return out;
		}else if (chosenHero.getCurrentHealth() == chosenHero.getMaximumHealth()) {
			String out = "Chosen Hero has no need for Healing, Hero is already at Full Health.";
			return out;
		} else {
			String out = chosenItem.use(chosenHero);
			team.moveToWard(chosenHero);
			timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
				    team.releaseFromWard(chosenHero);
				  }
				}, chosenItem.getItemDuration()*60*1000);
			return out;
		}
	}
	
	public String visitWard(ArrayList<Hero> ward) {
		if (ward.size() > 0) {
			String output = "Heroes Currently being treated and are resting in Hospital Ward:" + "\n\n";
			for (Hero patient: ward) {
				output += "Person Name: " + patient.getPersonName() + "\n";
			}
			return output;
		} else {
			String output = "There are currenlty no Heroes Healing in Hospital Ward." + "\n";
			return output;
		}
	}

}
