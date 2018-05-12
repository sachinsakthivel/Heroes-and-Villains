import java.util.*;

public class HelperFunctions {
	
	
	public static int InputValidator(int lower, int upper) {
		int userInput = -1;
		boolean validInput = false;
		Scanner inputStream = new Scanner(System.in);
		while (!validInput) {
			if (inputStream.hasNextInt()) {
				userInput = inputStream.nextInt();
				if (userInput >= lower && userInput <= upper) {
					validInput = true;
				} else {
					System.out.println("Input not in valid range, Please input a integer from the range "+ lower + " to " + upper+".");
				}
			} else {
				inputStream.next();
				System.out.println("Not a valid Integer, Please Input a Integer.");
			}
		}
		return userInput;
	}
	
	public static Hero heroPick(Team team) {
		System.out.println("Which Hero would you Like to Pick?");
		int i = 1;
		int userInput = -1;
		for (Hero hero: team.getTeam()) {
			System.out.println(i + " - " + hero);
			i++;
		}
		userInput = InputValidator(1, team.getTeam().size());
		return team.getTeam().get(userInput-1);
	}
		
}
