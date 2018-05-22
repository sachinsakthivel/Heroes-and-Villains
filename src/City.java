import java.util.*;

public class City {
	private boolean isFinal;
	private Shop shop;
	private Hospital hospital;
	private PowerUpDen power;;
	private VillainsLair lair;
	private int userInput = -1;
	ArrayList<Locations> places;
	
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
		randomEvent();
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
	
	public void randomEvent() {
		System.out.println("Random Events not implemented Yet");
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



}
