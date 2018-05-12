import java.util.*;

public class HelperFunctions {
	
	
	public int InputValidator(int lower, int upper) {
		System.out.println("Please input an integer that Corresponds to your Option.");
		int userInput = -1;
		boolean validInput = false;
		Scanner inputStream = new Scanner(System.in);
		while (!validInput) {
			if (inputStream.hasNextInt()) {
				userInput = inputStream.nextInt();
				if (userInput <= upper && userInput >= lower) {
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
		
	
}
