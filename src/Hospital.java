import java.util.*;

/**
 * Date: May 22nd 2018
 * 
 * This class creates Location, Hospital.
 * 
 * The Hospital class's parent class is Locations. This class facilitates the healing of wounded 
 * Heros in the Team. Healing items are needed to Heal Heroes and when being healed the Heroes 
 * are moved off the Team and into Ward.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Hospital extends Locations {
	
	private Timer timer = new Timer();
	
	/**
	 * Constructor method for Hospital.
	 * Sets the locations Name to "General Hospital" using parent class, Locations.
	 */
	public Hospital() {
		super("General Hospital");
	}
	
	public void travel(GameEnvironment game) {
		travelledto();
		game.launchHospitalSCREEN(game.getHomeBase());
	}
			
	
	/**
	 * This method Heals Heroes using Items over a Duration specified by the Item and returns a 
	 * String variable 'out' to notify the User of the action.
	 * @param team Input variable 'team' of type team containing current status and data of Team.
	 * @param chosenHero Input variable 'chosenHero' of type Hero which is the Hero to be healed.
	 * @param chosenItem Input variable 'chosenItem' of type Item which the Item which determines 
	 * the health restored and the duration taken to Heal.
	 * @return Returns String variable 'out' which notify the User of the action.
	 */
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
	
	/**
	 * This method provides the User the capability to check on Heroes who are currently being 
	 * Healed.
	 * @param ward Input variable 'ward' of type ArrayList's (which contain Heroes), current
	 * status. 
	 * @return Returns a String variable 'output' which notifies the User if there are any Heros 
	 * in ward and shows their details, if else notifies the User the Ward is empty.
	 */
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
