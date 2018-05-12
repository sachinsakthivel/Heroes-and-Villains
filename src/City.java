import java.util.*;

public class City {
	private boolean isFinal;
	private Shop shop = new Shop();
	private Hospital hosptial = new Hospital();
	private PowerUpDen power = new PowerUpDen();
	private VilliansLair lair = new VilliansLair(isFinal);
	private int userInput = -1;
	ArrayList<Locations> places;
	
	public City( boolean last) {
		isFinal = last;
		places = new ArrayList<Locations>(Arrays.asList(shop, hosptial, power, lair));
		Collections.shuffle(places);
	}
	
	public void HomeBase(Team team) {
		System.out.println("Welcome To Your Home Base");
		randomEvent();
		Scanner inputStream = new Scanner(System.in);
		while (userInput !=0) {
			System.out.println("What would you like to do?");
			menuOptions();
			userInput = inputStream.nextInt();
			if (userInput == 1) {
				places.get(0).travel(team);
			} else if (userInput == 2) {
				places.get(1).travel(team);
			} else if (userInput == 3) {
				places.get(2).travel(team);
			} else if (userInput == 4) {
				places.get(3).travel(team);
			} else if (userInput == 5) {
				useMap(team);
			} else {
				System.out.println(team);
			}
		}
	}
	
	public void menuOptions() {
		System.out.println("0 - Quit Game");
		System.out.println("1 - Travel North - Destination: " + places.get(0).getName());
		System.out.println("2 - Travel East - Destination: " + places.get(1).getName());
		System.out.println("3 - Travel West - Destination: " + places.get(2).getName());
		System.out.println("4 - Travel South - Destination: "+ places.get(3).getName());
		System.out.println("5 - Use a Map");
		System.out.println("6 - Look at Team Status");
	}
	
	public void useMap(Team team) {
		if (team.getInv().get(3).getItemStock() > 1) {
			for (Locations place: places) {
				place.travelledto();
			}
		} else {
			System.out.println("Insuffient Maps.");
		}
	}
	
	public void randomEvent() {
		System.out.println("Random Events not implemented Yet");
	}

}
