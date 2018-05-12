import java.util.*;

public class Shop extends Locations {
	
	private int LesserHealNum;
	private int AverageHealNum;
	private int GreaterHealNum;
	private int ArmourNum;
	private int DiceNum;
	private int HealthUpNum;
	private int SkillNum;
	private int MapNum;
	private int input;
	
	public Shop() {
		super("Wanderer's Shop");
		Random rand  = new Random();
		LesserHealNum =  rand.nextInt(4) + 7;
		AverageHealNum =  rand.nextInt(3) + 2;
		GreaterHealNum = rand.nextInt(2) + 1;
		ArmourNum = rand.nextInt(5) + 9;
		DiceNum = rand.nextInt(4) + 1;
		HealthUpNum = rand.nextInt(3) + 2;
		SkillNum = rand.nextInt(4) + 1;
		MapNum = 6;
	}
	
	public void travel(Team team) {
		travelledto();
		Scanner reader = new Scanner(System.in);
		input = -1;
		System.out.println("Welcome Stranger, What're you Buying?");
		while (input != 0) {
			System.out.println("You have currently " + team.getCoins() + " coins left.");
			menuOptions(team);
			input = reader.nextInt();
			if (input == 1) {
				buy(LesserHealNum, team, input);
			}
			else if (input == 2) {
				buy(AverageHealNum, team, input);
			}
			else if (input == 3) {
				buy(GreaterHealNum, team, input);
			}
			else if (input == 4) {
				buy(MapNum, team, input);
			}
			else if (input == 5) {
				buy(ArmourNum, team, input);
			}
			else if (input == 6) {
				buy(DiceNum, team, input);
			}
			else if (input == 7) {
				buy(HealthUpNum, team, input );
			}
			else if (input == 8) {
				buy(SkillNum, team, input);
			}
			else {
				System.out.println("Pleasure doing business with ya, Stranger");
			}
			
		}
	}
	
	public void menuOptions(Team team) {
		System.out.println("0 - Return To Home Base");
		System.out.println("1 - Buy a Lesser Heal Ticket ("+LesserHealNum+" left in Stock) (You own: "+team.getInv().get(0).getItemStock()+") (Price: "+team.getInv().get(0).getItemPrice()+" coins)");
		System.out.println("2 - Buy an Average Heal Ticket ("+AverageHealNum+" left in Stock) (You own: "+team.getInv().get(1).getItemStock()+") (Price: "+team.getInv().get(1).getItemPrice()+" coins)");
		System.out.println("3 - Buy a Greater Heal Ticket ("+GreaterHealNum+" left in Stock) (You own: "+team.getInv().get(2).getItemStock()+") (Price: "+team.getInv().get(2).getItemPrice()+" coins)");
		System.out.println("4 - Buy a Map ("+MapNum+" left in Stock) (You own: "+team.getInv().get(3).getItemStock()+") (Price: "+team.getInv().get(3).getItemPrice()+" coins)");
		System.out.println("5 - Buy Armour ("+ArmourNum+" left in Stock) (You own: "+team.getInv().get(4).getItemStock()+") (Price: "+team.getInv().get(4).getItemPrice()+" coins)");
		System.out.println("6 - Buy Weighted Dice ("+DiceNum+" left in Stock) (You own: "+team.getInv().get(5).getItemStock()+") (Price: "+team.getInv().get(5).getItemPrice()+" coins)");
		System.out.println("7 - Buy a MaxHealthUp Potions ("+HealthUpNum+" left in Stock) (You own: "+team.getInv().get(6).getItemStock()+") (Price: "+team.getInv().get(6).getItemPrice()+" coins)");
		System.out.println("8 - Buy a Hypnotic Suggestion Manual ("+SkillNum+" left in Stock) (You own: "+team.getInv().get(7).getItemStock()+") (Price: "+team.getInv().get(7).getItemPrice()+" coins)");
	}
	
	public void buy(int itemNum, Team team, int input) {
		if (itemNum < 1) {
			System.out.println("Sorry Stranger, Out of Stock");
		}
		else if ( team.getInv().get(input-1).getItemPrice() > team.getCoins()) {
			System.out.println("Not enough coins, Stranger");
		}
		else {
			int newPotionCount = team.getInv().get(input-1).getItemStock() + 1;
			team.getInv().get(input-1).setItemStock(newPotionCount);
			int coins = team.getCoins() - team.getInv().get(input-1).getItemPrice();
			team.setCoins(coins);
			System.out.println("Anything Else, Stranger");
		}
		
	}
	

}
