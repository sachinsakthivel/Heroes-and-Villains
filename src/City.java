import java.util.*;

/**
 * Date: May 29th 2018
 * 
 * The main class of the Game that runs the game.
 * 
 * each city would be considered circular progression. The setup GUI and the 
 * city loops are launched form this class.
 * 
 * The game is broken down in to two sections determined by progression. Setting up the game, team and heroes
 * are linear progression while the each city would be considered circular progression. The setup GUI and the 
 * city loops are launched form this class.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class City {
	
	/**
	 * Boolean variable to verify if the current city is the final city of the play through to 
	 * create the final Villain.
	 */
	private boolean isFinal;
	/**
	 * Shop variable for current city. 
	 */
	private Shop shop;
	/**
	 * Hospital variable for current city
	 */
	private Hospital hospital;
	/**
	 * PowerUp Dean variable for current city.
	 */
	private PowerUpDen power;
	/**
	 * VillainsLair variable for current city.
	 */
	private VillainsLair lair;
	/**
	 * ArrayList variable 'places' contains the 4 locations mentioned above.
	 */
	private ArrayList<Locations> places;
	
	
	/**
	 * Constructor method for City class.
	 * All location objects are created with checking if the Final Villain is needed. All 
	 * Locations are included in places ArrayList and is shuffled to provide variation in the 
	 * Loaction's direction of travel.
	 * @param last Boolean variable which determines if the current city is the last city of 
	 * the play through, If true the villain is created as a Final Villain.
	 */
	public City( boolean last) {
		isFinal = last;
		shop = new Shop();
		hospital = new Hospital();
		power = new PowerUpDen();
		lair = new VillainsLair(isFinal);
		places = new ArrayList<Locations>(Arrays.asList(shop, hospital, power, lair));
		Collections.shuffle(places);
	}


	
	/**
	 * This methods uses a map and makes all location in the current City discovered.
	 * Check Team Inventory for maps and if present travels to each location to make each 
	 * location discovered. Else, alerts the user to the lack of maps in the Team Inventory
	 * @param team Input Team variable which carries all the information of the current team 
	 * in the play through.
	 * @return Returns a String Variable out notifying the user if the map was successfully 
	 * or not.
	 */
	public String useMap(Team team) {
		if (team.getInv().get(3).getItemStock() > 0) {
			for (Locations place: places) {
				place.travelledto();
			}
			team.getInv().get(3).setItemStock(team.getInv().get(3).getItemStock() - 1);
			String out = "Successfully, Used a Map. \n\nAll Possible travel Destinations have been Discovered.";
			return out;
		} else {
			String out = "Insuffient Maps.\n\nPlease Buy some More from Shop";
			return out;
		}
	}
	
	/**
	 * When the Team travels from any location to the HomeBase an Random Event occurs.
	 * Positive Random Events  provides the team with additional Items or Gold, while negative
	 * Random Events takes Items or Gold from the Team Inventory. If the Watch Dog Hero Type is 
	 * present in the Team Negative Random Events doesn't occur although the user will be 
	 * notified of the failed negative Random Event.
	 * @param team Input Team variable which carries all the information of the current team 
	 * in the play through.
	 * @return Returns a String Variable out notifying the user of a Random Event that occured.
	 */
	public String randomEvent(Team team) {
		String output = "After the arduous journey to the Home Base of the City; the Heroes rested their minds and bodies.";
		output += "\n\n....As the Night Passed, Strangers using the cover of darkness sneaked closer.";
		Random Chance = new Random();
		int event = Chance.nextInt(10) + 1;
		int itemIndex = Chance.nextInt(team.getInv().size());
		Item chosenItem = team.getInv().get(itemIndex);
		if (event <= 4) {
			chosenItem.setItemStock(chosenItem.getItemStock() + event);
			output += "\n\n As the Heroes woke just before Dawn; They noticed "+event+" "+chosenItem.getItemName()+" placed near them.";
			output += "\nA gift given by the citizens of the City, too terrified to give it in person, in case of repercussions from the Villain.";
		} else {
			if (team.typeCheck("WatchDog")) {
				output += "\nAs the Theives tried to steal Items for the Heroes, the ever Vigiliant WatchDog Discovered them and ate them.";	
			} else {
				int stealItem = Chance.nextInt(2) +1;
				if (chosenItem.getItemStock() < stealItem) {
					int stolenCoins =  Chance.nextInt(40) + 1;
					if (team.getCoins() < stolenCoins) {
						output += "\nAfter searching all the pockets of the Heroes, and finding a measly amount of Coins, the Thieves took Pity on them and game them a Coin.";
						team.setCoins(team.getCoins() + 1);
					} else {
						team.setCoins(team.getCoins() - stolenCoins);
						output += "\nUnable to find any valuable items, the Thieves stole "+stolenCoins+" Coins.";
					}
				} else {
					team.getInv().get(itemIndex).setItemStock(team.getInv().get(itemIndex).getItemStock() - stealItem);
					output += "When the Heroes woke up, they realised that they've been robbed. The Thieves took "+stealItem+" of "+chosenItem.getItemName()+" taken.";
				}
			}
		}
		output += "\n\n What would you like to do Now?";
		return output;
	}
	
	/**
	 * This method returns the ArrayList 'places' in its current shuffled state.
	 * @return  Returns the ArrayList variable 'places'
	 */
	public ArrayList<Locations> getplaces() {
		return places;
	}
	
	/**
	 * This method returns the shop in its current state which includes its attributes such as
	 * Item stocks.
	 * @return Returns Shop variable 'shop'.
	 */
	public Shop getShop() {
		return shop;
	}
	
	/**
	 * This method returns the VillainsLair in its current state which includes its attributes 
	 * such as Villains current Health in the form of Strikes.
	 * @return Returns VillainsLair variable 'lair'.
	 */
	public VillainsLair getVillainsLair() {
		return lair;
	}
	
	/**
	 * This method returns the Hospital in its current state which includes its attributes such 
	 * as the HeroWard.
	 * @return Returns Hospital variable 'hospital'.
	 */
	public Hospital getHospital() {
		return hospital;
	}



}
