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
	boolean trade = false;
	private int[] ShopList;
	
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
		int[] StockList = {LesserHealNum, AverageHealNum, GreaterHealNum, MapNum, ArmourNum, DiceNum, HealthUpNum, SkillNum};
		ShopList = StockList;
		
	}
	
	public void travel(Team team) {
		travelledto();
		input = -1;
		System.out.println("Welcome Stranger, What're you Buying?");
		while (input != 0) {
			System.out.println("You have currently " + team.getCoins() + " coins left.");
			menuOptions(team);
			input = HelperFunctions.InputValidator(0, 8);
			if (input == 1) {
				trade = buy(LesserHealNum, team, input);
				if (trade) {LesserHealNum--;}
			}
			else if (input == 2) {
				trade = buy(AverageHealNum, team, input);
				if (trade) {AverageHealNum--;}
			}
			else if (input == 3) {
				trade = buy(GreaterHealNum, team, input);
				if (trade) {GreaterHealNum--;}
			}
			else if (input == 4) {
				trade = buy(MapNum, team, input);
				if (trade) {MapNum--;}
			}
			else if (input == 5) {
				trade = buy(ArmourNum, team, input);
				if (trade) {ArmourNum--;}
			}
			else if (input == 6) {
				trade = buy(DiceNum, team, input);
				if (trade) {DiceNum--;}
			}
			else if (input == 7) {
				trade = buy(HealthUpNum, team, input );
				if (trade) {HealthUpNum--;}
			}
			else if (input == 8) {
				trade = buy(SkillNum, team, input);
				if (trade) {SkillNum--;}
			}
			else {
				System.out.println("Pleasure doing business with ya, Stranger");
			}
			
		}
	}
	
	public void menuOptions(Team team) {
		System.out.println("0 - Return To Home Base" + "\n");
		int i = 1;
		for (Item item: team.getInv()) {
			System.out.println(i+" - Buy One "+ item.getItemName() + " ("+ShopList[i-1]+ " left in Stock) (You own: "+team.getInv().get(i-1).getItemStock()+") (Price: "+team.getInv().get(i -1).getItemPrice()+" coins)");
			System.out.println(item.getItemDescription() + "\n");
			i++;
		}
	}
		
	public boolean buy(int itemNum, Team team, int input) {
		if (itemNum < 1) {
			System.out.println("Sorry Stranger, Out of Stock");
			return false;
		}
		else if ( team.getInv().get(input-1).getItemPrice() > team.getCoins()) {
			System.out.println("Not enough coins, Stranger");
			return false;
		}
		else {
			int newPotionCount = team.getInv().get(input-1).getItemStock() + 1;
			team.getInv().get(input-1).setItemStock(newPotionCount);
			int coins = team.getCoins() - team.getInv().get(input-1).getItemPrice();
			team.setCoins(coins);
			itemNum --;
			System.out.println("Anything Else, Stranger");
			return true;
		}
		
	}
	

}
