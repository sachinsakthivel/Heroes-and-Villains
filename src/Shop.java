import java.util.*;
public class Shop extends Locations {
	
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
	
	public void travel(GameEnvironment game) {
		travelledto();
		game.launchShopSCREEN(game.getHomeBase());
		/*
		input = -1;
		System.out.println("Welcome Stranger, What're you Buying?" + "\n");
		while (input != 0) {
			System.out.println("You have currently " + game.getParty().getCoins() + " coins left.");
			menuOptions(game.getParty());
			input = HelperFunctions.InputValidator(0, 8);
			if (input !=0) {
				String out= buy(game.getParty(), input);
			} else {
				System.out.println("Pleasure doing business with ya, Stranger" + "\n");
			}
			
		}
		*/
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
		
	public String buy(Team team, int input) {
		if (ShopList[input -1] < 1) {
			String out = ("Sorry Stranger, Out of Stock");
			return out;
		}
		else if (team.getInv().get(input-1).getItemPrice() > team.getCoins()) {
			String out = ("Not enough coins, Stranger");
			return out;
		}
		else {
			int newItemCount = team.getInv().get(input-1).getItemStock() + 1;
			team.getInv().get(input-1).setItemStock(newItemCount);
			int coins = team.getCoins() - team.getInv().get(input-1).getItemPrice();
			team.setCoins(coins);
			ShopList[input-1] -= 1;
			String out = ("Anything Else, Stranger?" + "\n");
			return out;
		}
		
	}
	

}
