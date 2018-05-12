
public class PowerUpDen extends Locations{
	
	private HelperFunctions misc = new HelperFunctions();
	private Hero chosenHero;
	private Item chosenItem;
	private int userInput;
	private int PowerUpStartIndex = 4;
	private int PowerUpEndIndex = 7;
	
	public PowerUpDen() {
		super("Power Up Den");
	}
	
	public void travel(Team team) {
		travelledto();
		userInput = -1;
		System.out.println("Howdy y'all, Welcome to Miky's Workshop and Upgrade Station!!");
		while (userInput != 0) {
			menuOptions();
			userInput = misc.InputValidator(0, 1);
			if (userInput == 1) {
				chosenHero = misc.heroPick(team);
				chosenItem = misc.itemPick(team, PowerUpStartIndex, PowerUpEndIndex);
			} else {
				System.out.println("Be Careful Out there, y'all better come back, ya hear?");
			}
		}
	}
	
	public Item itemPick(Team team, int startIndex, int endIndex) {
		System.out.println("Which Item would you like to Use?"); 
			int u = 1;
			int userInput = -1;
			for (int i = startIndex; i < endIndex; i++ ) {
				System.out.println(u + " - " + team.getInv().get(i));
				u++;
			}
			userInput = InputValidator(1, (startIndex-endIndex));
			return team.getInv().get(userInput);
	}
	
	public void menuOptions() {
		System.out.println("0 - Travel Back to Homebase");
		System.out.println("1 - Power Up a Hero");
	}

}
