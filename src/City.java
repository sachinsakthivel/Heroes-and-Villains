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
	
	public void HomeBase(GameEnvironment game) {
		System.out.println("Welcome To Your Home Base");
		while (userInput !=0 && lair.getVillain().getLiving()) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 6);
			if (userInput == 0) {
				System.out.println("Thank you for Playing.");
				System.exit(0);
			}
			else if (userInput == 1) {
				places.get(0).travel(game);
			} else if (userInput == 2) {
				places.get(1).travel(game);
			} else if (userInput == 3) {
				places.get(2).travel(game);
			} else if (userInput == 4) {
				places.get(3).travel(game);
			} else if (userInput == 5) {
				String out = useMap(game.getParty());
				System.out.println(out);
			} else {
				System.out.println(game.getParty());
			}
		}
	}
	
	public void menuOptions() {
		System.out.println("What would you like to do? (Input the Number that Corresponds with your Choice) ");
		System.out.println("0 - Quit Game");
		System.out.println("1 - Travel North - Destination: " + places.get(0).getName());
		System.out.println("2 - Travel East - Destination: " + places.get(1).getName());
		System.out.println("3 - Travel West - Destination: " + places.get(2).getName());
		System.out.println("4 - Travel South - Destination: "+ places.get(3).getName());
		System.out.println("5 - Use a Map");
		System.out.println("6 - Look at Team Status and Item Descriptions");
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
				output += "\nAs the Theives tried to steal Items for the Heroes, the ever Vigiliant WatchDog Discovered them and Scared them Off.";	
			} else {
				int stealItem = Chance.nextInt(2) +1;
				if (chosenItem.getItemStock() < stealItem) {
					int stolenCoins =  Chance.nextInt(40) + 1;
					team.setCoins(team.getCoins() - stolenCoins);
					output += "\nUnable to find any valuable items, the Thieves stole "+stolenCoins+" Coins.";
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
