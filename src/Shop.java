import java.util.*;

public class Shop {
	
	private int LesserHealNum;
	private int AverageHealNum;
	private int GreaterHealNum;
	private int MapNum;
	private int input;
	
	public Shop () {
		Random rand  = new Random();
		LesserHealNum =  rand.nextInt((12 - 7) + 1) + 7;
		AverageHealNum =  rand.nextInt((6 - 2) + 1) + 2;
		GreaterHealNum = rand.nextInt((1 - 3) + 1) + 2;
		MapNum = 6;
		input = -1;
	}
	
	public void travel(Team superteam) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome Stranger, What're you Buying?");
		while (input != 0) {
			menuOptions();
			if (input != 0) {
				buy(reader.nextInt(), superteam.getCoins());
				System.out.println("Anything else, Stranger?");
			}
			
		}
	}
	
	public void menuOptions() {
		
		System.out.println("0 - Return To Home Base");
		System.out.println("1 - Buy a Lesser Heal Ticket");
		System.out.println("2 - Buy an Average Heal Ticket");
		System.out.println("3 - Buy a Greater Heal Ticket");
		System.out.println("4 - Buy a Map");
				
	}
	
	public void buy(int choice, int coins) {
		if (choice == 1) {
		}
	}

}
