
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
		userInput = -1;
		System.out.println("Howdy y'all, Welcome to Miky's Workshop and Upgrade Station!!");
		while (userInput != 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 1);
			while (userInput != 0) {
				chosenHero = HelperFunctions.heroPick(team.getTeam());
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

}
