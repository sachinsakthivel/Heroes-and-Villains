import java.util.*;

public class Team {
	/* team class*/
	private String teamName;
	private int teamLength;
	private ArrayList<Hero> team = new ArrayList<Hero>();
	private int Coins;
	private ArrayList<Hero> Ward = new ArrayList<Hero>();
	private ArrayList<Item> invList = new ArrayList<Item>();
	private ArrayList<Hero> Graveyard = new ArrayList<Hero>();
	
	public Team(String name, int length) {
		teamName = name;
		setTeamLength(length);
		Coins = 500;
		setInventory();
		
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
		Graveyard.add(superhero);
		team.remove(superhero);
	}
	
	public String toString() {
		String output = new String("Name of the Team is: " + getteamName());
		output += "\n" + "\n" + "Coins: " + Coins;
		output += "\n" + "\n" + "Heroes:";
		for (Hero superhero: team) {
			output += "\n" + superhero + "\n";
		}
		output += "\n" + "\n" + "Items:";
		String invOutPut = "";
		for (Item chosenItem: invList) {
			if (chosenItem.getItemStock() > 0) {
				 invOutPut += "\n" + chosenItem + "\n";
			}
		} if (invOutPut == "") {invOutPut = "\n" + "You currently have no Items." + "\n";} 
		return output + invOutPut;
	}


	public void checkDead(GameEnvironment game) {
		if (team.size() == 0 && Ward.size() == 0) {
			ExitSCREEN ExitScreen = new ExitSCREEN();
			ExitScreen.frame.setVisible(true);
		}
	}


	public int getCoins() {
		return Coins;
	}

	public void setCoins(int coins) {
		Coins = coins;
	}
	
	public void moveToWard(Hero hero) {
		Ward.add(hero);
		this.removeOffTeam(hero);
	}
	
	public void releaseFromWard(Hero hero) {
		this.addToTeam(hero);
		Ward.remove(hero);
		System.out.println("Hero: "+hero.getPersonName()+ " has been released from Healing Ward and is ready to fight again." + "\n");
	}
	
	public ArrayList<Hero> getWard() {
		return Ward;
	}
	
	public ArrayList<Hero> getGrave() {
		return Graveyard;
	}

	public int getTeamLength() {
		return teamLength;
	}

	public void setTeamLength(int teamLength) {
		this.teamLength = teamLength;
	}

}
