import java.util.*;

public class Team {
	/* team class*/
	//HAVEN'T FIGURED OUT POWERUPS
	private String teamName;
	private boolean dead;
	private ArrayList<Hero> team = new ArrayList<Hero>();
	private int LesserHealNum;
	private int AverageHealNum;
	private int GreaterHealNum;
	private int MapNum;
	
	
	public Team(String name, int length) {
		teamName = name;
		
	}
	
	public String getteamName() {
		return teamName;
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
	
	public void removeOffTeam(Hero superhero) {
		team.remove(superhero);
	}
	
	public String toString() {
		String output = new String("This is the " + getteamName());
		for (Hero superhero: team) {
			output += superhero.getPersonName() + ": " +  superhero.getCurrentHealth() + " Health";
		}
		return output;
	}

	public int getLesserHealNum() {
		return LesserHealNum;
	}

	public void setLesserHealNum(int lesserHealNum) {
		LesserHealNum = lesserHealNum;
	}

	public int getGreaterHealNum() {
		return GreaterHealNum;
	}

	public void setGreaterHealNum(int greaterHealNum) {
		GreaterHealNum = greaterHealNum;
	}

	public int getAverageHealNum() {
		return AverageHealNum;
	}

	public void setAverageHealNum(int averageHealNum) {
		AverageHealNum = averageHealNum;
	}

	public int getMapNum() {
		return MapNum;
	}

	public void setMapNum(int mapNum) {
		MapNum = mapNum;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	
}
