import java.util.*;

public class Hospital extends Locations {
	
	private Timer timer = new Timer();
	
	public Hospital() {
		super("General Hosptial");
	}
	
	public void travel(GameEnvironment game) {
		travelledto();
		game.launchHospitalSCREEN(game.getHomeBase());
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
