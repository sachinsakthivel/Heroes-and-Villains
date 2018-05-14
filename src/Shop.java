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
		int LesserHealNum =  rand.nextInt(4) + 7;
		int AverageHealNum =  rand.nextInt(3) + 2;
		int GreaterHealNum = rand.nextInt(2) + 1;
		int ArmourNum = rand.nextInt(5) + 9;
		int DiceNum = rand.nextInt(4) + 1;
		int HealthUpNum = rand.nextInt(3) + 2;
		int SkillNum = rand.nextInt(4) + 1;
		int MapNum = 1;
		int[] StockList = {LesserHealNum, AverageHealNum, GreaterHealNum, MapNum, ArmourNum, DiceNum, HealthUpNum, SkillNum};
		ShopList = StockList;
		
	}
	
	public void travel(Team team) {
		travelledto();
		input = -1;
		System.out.println("Welcome Stranger, What're you Buying?" + "\n");
		while (input != 0) {
			System.out.println("You have currently " + team.getCoins() + " coins left.");
			menuOptions(team);
			input = HelperFunctions.InputValidator(0, 8);
			if (input !=0) {
				ShopList = buy(ShopList, team, input);
			} else {
				System.out.println("Pleasure doing business with ya, Stranger" + "\n");
			}
			
		}
	}
	
	public void menuOptions(Team team) {
		System.out.println("What would you like to do? (Input the Number that Corresponds with your Choice) ");
		System.out.println("0 - Return To Home Base" + "\n");
		int i = 1;
		for (Item item: team.getInv()) {
			System.out.println(i+" - Buy One "+ item.getItemName() + " ("+ShopList[i-1]+ " left in Stock) (You own: "+team.getInv().get(i-1).getItemStock()+") (Price: "+team.getInv().get(i -1).getItemPrice()+" coins)");
			System.out.println(item.getItemDescription() + "\n");
			i++;
		}
	}
		
	public int[] buy(int[] itemList, Team team, int input) {
		if (itemList[input -1] < 1) {
			System.out.println("Sorry Stranger, Out of Stock");
			return itemList;
		}
		else if (team.getInv().get(input-1).getItemPrice() > team.getCoins()) {
			System.out.println("Not enough coins, Stranger");
			return itemList;
		}
		else {
			int newItemCount = team.getInv().get(input-1).getItemStock() + 1;
			team.getInv().get(input-1).setItemStock(newItemCount);
			int coins = team.getCoins() - team.getInv().get(input-1).getItemPrice();
			team.setCoins(coins);
			itemList[input-1] -= 1;
			System.out.println("Anything Else, Stranger?" + "\n");
			return itemList;
		}
		
	}
	

}
