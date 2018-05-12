import java.util.*;

public class Team {
	/* team class*/
	//HAVEN'T FIGURED OUT POWERUPS
	private String teamName;
	private int teamLength;
	private boolean dead;
	private ArrayList<Hero> team = new ArrayList<Hero>();
	private int Coins;
	
	private ArrayList<Item> invList = new ArrayList<Item>();
	private String heroName;
	
	public Team(String name, int length) {
		teamName = name;
		teamLength = length;
		Coins = 500;
		dead = false;
		setTeamList();
		setInventory();
		
	}
	
	public void setTeamList() {
		for (int i = 0; i < teamLength; i++ ) {
			Scanner reader = new Scanner(System.in);
			System.out.println("What would you like the name of Hero no."+(i+1)+" ?:");
			heroName = reader.next();
			Hero newHero = new Hero(heroName);
			addToTeam(newHero);
		}
	}
	
	public void setInventory() {
		invList.add(new lesserHeals());
		invList.add(new avgHeals());
		invList.add(new greaterHeals());
		invList.add(new Maps());
		invList.add(new armourUp());
		invList.add(new riggedDice());
		invList.add(new maxHealthUp());
		invList.add(new hypSuggestSkill());
	}
	
	public ArrayList<Item> getInv(){
		return invList;
	}
	public void setInv(ArrayList<Item> updateInv) {
		invList = updateInv;
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
		String output = new String("Name of the Team is: " + getteamName());
		output += "\n" + "\n" + "Heroes:";
		for (Hero superhero: team) {
			output += "\n" + superhero.getPersonName() + " : " +  superhero.getCurrentHealth() + " Health";
		}
		output += "\n" + "\n" + "Items:";
		for (Item chosenItem: invList) {
			output += "\n" + chosenItem + "\n";
		}
		return output;
	}


	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public int getCoins() {
		return Coins;
	}

	public void setCoins(int coins) {
		Coins = coins;
	}

}
