
public class Hospital extends Locations {
	
	private int userInput;
	private Hero chosenHero;
	private Item chosenItem;
	private int healStartIndex = 0;
	private int healEndIndex = 3;
	
	public Hospital() {
		super("General Hosptial");
	}
	
	public void travel(Team team) {
		travelledto();
		System.out.println("Welcome to the General Hosptial of this City");
		userInput = -1;
		while (userInput != 0) {
			menuOptions();
			userInput = HelperFunctions.InputValidator(0, 1);
			if (userInput == 1) {
			chosenHero = HelperFunctions.heroPick(team.getTeam());
			chosenItem = HelperFunctions.itemPick(team.getInv(), healStartIndex, healEndIndex);
			System.out.println(chosenHero);
			System.out.println(chosenItem);
			System.out.println("You want to Heal Anyone Else?");
			} else {
				System.out.println("Be Careful Out There, these are Dangerous Times");
			}
			
		}		
	}
	
	public void menuOptions() {
		System.out.println("0 - Return To HomeBase");
		System.out.println("1 - Heal a Hero");
		System.out.println("2 - Visit the Hero Ward");
	}

}
