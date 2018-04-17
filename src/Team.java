import java.util.*;

public class Team {
	
	private String squadName;
	private boolean dead;
	private ArrayList<Hero> team = new ArrayList<Hero>();
	
	public Team() {
		
	}
	
	public String getSquadName() {
		return squadName;
	}
	
	public void setSquadName(String squadName) {
		this.squadName = squadName;
	}
	
	public ArrayList<Hero> getTeam(){
		return team;
	}
	
	public void addToTeam(Hero superhero) {
		if (!team.contains(superhero)) {
			team.add(superhero);
		} else {
			System.out.println("This hero is already in the team");
		}
	}
	
	public String toString() {
		String output = new String("This is the " + getSquadName());
		for (Hero superhero: team) {
			output += superhero.getPersonName() + ": " +  superhero.getCurrentHealth() + " Health";
		}
		return output;
	}

}
