import java.util.ArrayList;

public class PowerUpDen extends Locations{
	
	private Hero chosenHero;
	private Item chosenItem;
	private int userInput;
	private int PowerUpStartIndex = 4;
	private int PowerUpEndIndex = 8;
	
	public PowerUpDen() {
		super("Power Up Den");
	}
	
	public void travel(Team team) {
		travelledto();
		System.out.println("Howdy y'all, Welcome to Miky's Workshop and Upgrade Station!!");
		userInput = -1;
		while (userInput != 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 1);
			if (userInput == 1) {
			chosenHero = HelperFunctions.heroPick(team.getTeam());
			chosenItem = HelperFunctions.itemPick(team.getInv(), PowerUpStartIndex, PowerUpEndIndex);
			chosenItem.use(chosenHero);
			System.out.println("You want to Power Up Anyone Else?");
			} else {
				System.out.println("Be Careful Out There, y'all better come back ya hear? Good Custormers are hard to come by these days.");
			}
			
		}
	}
		
	
	public void heroOptions(ArrayList<Hero> heroList) {
		System.out.println("Which Hero would you like to Pick?: ");
		int i = 1;
		System.out.println("0 - Go Back");
		for (Hero hero: heroList) {
			System.out.println(i + " - " + hero);
			i++;
		}
		
	}
	
	public void menuOptions() {
		System.out.println("0 - Travel Back to Homebase");
		System.out.println("1 - Power Up a Hero");
	}
	
	public void  itemOptions(ArrayList<Item> InvList, int startIndex, int endIndex) {
		System.out.println("Which Item would you like to Use?"); 
			int u = 1;
			System.out.println("0 - Go Back to Hero Select");
			for (int i = startIndex; i < endIndex; i++ ) {
				System.out.println(u + " - " + InvList.get(i));
				u++;
			}
	}
			
		
	/**		
			while (userInput != 0) {
				
			
				while (userInput != 0) {
					chosenItem = HelperFunctions.itemPick(team.getInv(), PowerUpStartIndex, PowerUpEndIndex);
				}
			}
		}
		System.out.println(chosenHero);
		System.out.println(chosenItem);
		System.out.println("Be Careful Out There, y'all better come back, ya hear!. Good Customers are hard to find these days.");
	}
	
	
	public void menuOptions() {
		System.out.println("0 - Travel Back to Homebase");
		System.out.println("1 - Power Up a Hero");
	}
	
	public int heroPick(ArrayList<Hero> heroList) {
		System.out.println("Which Hero would you like to Pick?: ");
		int i = 1;
		System.out.println("0 - Go Back");
		int userInput = -1;
		for (Hero hero: heroList) {
			System.out.println(i + " - " + hero);
			i++;
		}
		userInput = HelperFunctions.InputValidator(0, heroList.size());
		chosenHero = heroList.get(userInput-1);
		userInput
	}
	**/

}
