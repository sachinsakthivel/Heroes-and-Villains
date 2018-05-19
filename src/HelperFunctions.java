import java.util.*;

public class HelperFunctions {
	
	public static Hero heroCreate(int userPick, String name) {
		if (userPick == 1 ) {
			Guardian newHero = new Guardian(name);
			return newHero;
		} else if (userPick == 2) {
			Knight newHero = new Knight(name);
			return newHero;
		} else if (userPick == 3) {
			Trickster newHero = new Trickster(name);
			return newHero;
		} else if (userPick == 4) {
			watchDog newHero = new watchDog(name);
			return newHero;
		} else if (userPick == 5) {
			Necromancer newHero = new Necromancer(name);
			return newHero;
		} else {
			Oracle newHero = new Oracle(name);
			return newHero;
		}
	}
	
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
	
	public static Hero heroPick(ArrayList<Hero> heroList) {
		System.out.println("Which Hero would you Like to Pick?");
		int i = 1;
		int userInput = -1;
		for (Hero hero: heroList) {
			System.out.println(i + " - " + hero + "\n");
			i++;
		}
		userInput = InputValidator(1, heroList.size());
		return heroList.get(userInput-1);
	}
	
	public static Item itemPick(ArrayList<Item> InvList, int startIndex, int endIndex) {
		System.out.println("Which Item would you like to Use?"); 
			int u = 1;
			int userInput = -1;
			for (int i = startIndex; i < endIndex; i++ ) {
				System.out.println(u + " - " + InvList.get(i)+ "\n");
				u++;
			}
			userInput = InputValidator(1, (endIndex-startIndex));
			return InvList.get(userInput + startIndex -1);
	}
		
}
