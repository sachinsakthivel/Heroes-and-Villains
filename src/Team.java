import java.util.*;

import javax.swing.JOptionPane;

/** 
 * This class is responsible for the Hero Team with which the User interacts with the game.
 * This class provides all the attributes for team such as Team Name, Size, Gold, Inventory
 * and ArrayList Ward for when Heros are being healed. The class also contains methods to edit 
 * the aforementioned attributes and other methods. (Eg. Checking whether a Hero is dead)
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 3rd 2018
 */

public class Team {
	/* team class*/
	
	/**
	 * String variable for Name of the Team
	 */
	private String teamName;
	
	/**
	 * Integer variable for Size of the Team
	 */
	private int teamLength;
	/**
	 * ArrayList containing Heros which compromises All heroes in team that are active.
	 */
	private ArrayList<Hero> team = new ArrayList<Hero>();
	/**
	 * Integer variable for the amount of Gold the Team has.
	 */
	private int Coins;
	/**
	 * ArrayList containing Heros which compromises All heroes in team that are Healing.
	 */
	private ArrayList<Hero> Ward = new ArrayList<Hero>();
	/**
	 * ArrayList containing Items and stocks of the Items which belong to the Team.
	 */
	private ArrayList<Item> invList = new ArrayList<Item>();
	/**
	 * ArrayList containing Heros which compromises All heroes in team that are dead.
	 */
	private ArrayList<Hero> Graveyard = new ArrayList<Hero>();
	
	/**
	 * Constructor method for Team class.
	 * Team Name is set using String input 'name' and Team Size is determined by Integer input
	 * 'length'. A default sum of 300 gold is given to Team upon creation. The inventory is 
	 * setup with all the Items with 0 Stock.
	 * @param name Input String variable which determines Team Name.
	 * @param length Input Integer variable which determines Team Size.
	 */
	public Team(String name, int length) {
		teamName = name;
		setTeamLength(length);
		Coins = 300;
		setInventory();
		
	}
		
	/**
	 * This method Sets up the inventory for Team with each Items stock set to 0 and adding 
	 * each Item stock to Integer ArrayList 'invList'.
	 */
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
	
	/**
	 * This method returns the Integer ArrayList 'invList' which contains data about the 
	 * Team's Inventory.
	 * @return Returns the Integer ArrayList 'invList'
	 */
	public ArrayList<Item> getInv(){
		return invList;
	}
	/**
	 * This method replaces the current 'invList' with an updated Team Inventory using input
	 * ArrayList variable 'updateInv' which contains Items.
	 * @param updateInv Input ArrayList variable 'updateInv'which contains Items is an updated
	 * Team Inventory.
	 */
	public void setInv(ArrayList<Item> updateInv) {
		invList = updateInv;
	}
	
	/**
	 * This method returns the Team Name.
	 * @return Returns String variable 'teamName'
	 */
	public String getteamName() {
		return teamName;
	}
	
	
	/**
	 * This method returns the ArrayList Team, containing active Heroes.
	 * @return Returns the ArrayList Team which contains active Heroes.
	 */
	public ArrayList<Hero> getTeam(){
		return team;
	}
	
	/**
	 * This method adds Hero type variable 'superhero' to team if the Team doesnt already contain
	 * the same Hero.
	 * @param superhero Hero type variable 'superhero', which is a new Hero being added to the 
	 * Team.
	 */
	public void addToTeam(Hero superhero) {
		if (!team.contains(superhero)) {
			team.add(superhero);
		}
	}
	
	/**
	 * Removing a Hero from Team when killed.
	 * This method removes Hero type variable 'superhero' from team and adds 'superhero' to the
	 * ArrayList containing Heroes Graveyard.
	 * @param superhero Hero type variable 'superhero', which is a new Hero being removed from 
	 * the Team.
	 */
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


	/**
	 * This method Checks whether the Team is dead in which case the User has been deefated by 
	 * the Game. It checks whether Team and Ward has any Heroes and if not returns true, else 
	 * false.
	 * @param game Input variable 'game' of type GameEnviornment, to update data about the Team.
	 * @return Returns True if no Heroes in Team or Ward, else returns false.
	 */
	public boolean checkDead(GameEnvironment game) {
		if (team.size() == 0 && Ward.size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks the Team whether a certain type of Hero is present in Team, to activate
	 *  especial abilities.
	 * @param type Input variable 'type' of Hero Type which is the Hero Type the Game is looking
	 * for.
	 * @return Returns true if Hero Type is found, else returns false.
	 */
	public boolean typeCheck(String type) {
		for (Hero superHero: team) {
			if (superHero.getType().equals(type)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks the Team whether a certain Name is already taken by a Hero in Team, to 
	 * avoid Name conflicts between Heroes.
	 * @param name Input variable 'name'  of type String which is a Name of a Hero.
	 * @return Returns true if a Hero in Team already has the 'name', else returns false.
	 */
	public boolean nameCheck(String name) {
		for (Hero superHero: team) {
			if(superHero.getPersonName().equals(name)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * This method returns the amount of Gold the Team currently has.
	 * @return Returns Integer variable 'Coins' which is the amount of Gold the Team 
	 * currently has.
	 */
	public int getCoins() {
		return Coins;
	}

	/**
	 * This method updates the Team's Gold based on the Integer input 'coins'.
	 * @param coins Integer input 'coins' updates Team's Gold.
	 */
	public void setCoins(int coins) {
		Coins = coins;
	}
	
	/** 
	 * This method removes a Hero, input 'hero', from Team and adds 'hero' to Ward. Used when 
	 * Heros are being healed in the Hospital.
	 * @param hero Input variable 'hero' of Hero type which determines which Hero is being 
	 * Transfered from Team to Ward.
	 */
	public void moveToWard(Hero hero) {
		Ward.add(hero);
		this.removeOffTeam(hero);
	}
	
	/**
	 * This method removes a Hero, input 'hero', from Ward and adds 'hero' to Team. Used when 
	 * Heros are finished being healed in the Hospital.
	 * @param hero Input variable 'hero' of Hero type which determines which Hero is being 
	 * Transfered from Ward to Team.
	 */
	public void releaseFromWard(Hero hero) {
		this.addToTeam(hero);
		Ward.remove(hero);
	}
	
	/**
	 * This method returns the ArrayList 'Ward', containing Healing Heroes.
	 * @return Returns the ArrayList 'Ward' which contains Healing Heroes.
	 */
	public ArrayList<Hero> getWard() {
		return Ward;
	}
	
	/**
	 * This method returns the ArrayList 'Graveyard', containing Dead Heroes.
	 * @return Returns the ArrayList 'Graveyard' which contains Dead Heroes.
	 */
	public ArrayList<Hero> getGrave() {
		return Graveyard;
	}

	/**
	 * This method returns the size of the Team, stored in the Integer variable 'teamLength'.
	 * @return Returns Integer variable 'teamLength'.
	 */
	public int getTeamLength() {
		return teamLength;
	}

	/**
	 * This method updates the size of the team using input Integer variable 'teamLength'.
	 * @param teamLength Input Integer variable 'teamLength' which is the updated Team Size.
	 */
	public void setTeamLength(int teamLength) {
		this.teamLength = teamLength;
	}

}
