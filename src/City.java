import java.util.*;

/**
 * Date: May 29th 2018
 * 
 * The main class of the Game that runs the game.
 * 
 * The game is broken down in to two sections determined by progression. Setting up the game, team and heroes
 * are linear progression while the each city would be considered circular progression. The setup GUI and the 
 * city loops are launched form this class.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class City {
	private boolean isFinal;
	private Shop shop;
	private Hospital hospital;
	private PowerUpDen power;;
	private VillainsLair lair;
	private int userInput = -1;
	private ArrayList<Locations> places;
	
	public City( boolean last) {
		isFinal = last;
		shop = new Shop();
		hospital = new Hospital();
		power = new PowerUpDen();
		lair = new VillainsLair(isFinal);
		places = new ArrayList<Locations>(Arrays.asList(shop, hospital, power, lair));
		Collections.shuffle(places);
	}


	
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
	
	public ArrayList<Locations> getplaces() {
		return places;
	}
	
	public Shop getShop() {
		return shop;
	}
	
	public VillainsLair getVillainsLair() {
		return lair;
	}
	
	public Hospital getHospital() {
		return hospital;
	}



}
