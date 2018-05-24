import java.util.*;

/**
 * Date: May 17th 2018
 * 
 * This class creates Location, Shop.
 * 
 * The Shop class's parent class is Locations. This class creates a Shop for each City. Renews 
 * stock of each item when a city is created. Allows the User to buy Items from the Shop in 
 * exchange for Gold.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Shop extends Locations {
	
	/**
	 * Integer ArrayList containing stocks of each Item available in the shop.
	 */
	private int[] ShopList;
	
	/**
	 * Constructor method for Shop.
	 * Sets the locations Name to "Wanderer's Shop" using parent class, Locations.
	 * Randomizes the stock of each item and equates the stock list to Integer ArrayList variable 
	 * 'ShopList'. 
	 */
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
	}
		
		
	/**
	 * This method lets the User to buy Items from the Shop.
	 * An item is bought if enough gold is present and the Item is taken off from the Stock and 
	 * added to the Team Inventory. Returns a String output which notifies the User of the result
	 * of the action.
	 * 
	 * @param team The current team status is inputed to get attributes such as Inventory and Gold.
	 * @param input Input variable which determines which Item is being purchased.
	 * @return Returns a String variable 'out' which notifies the User of the result.
	 */
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
	
	/**
	 * This method returns the Integer ArrayList 'ShopList' which contain Stocks of each item in
	 * the Shop.
	 * @return Returns the Integer ArrayList 'ShopList'.
	 */
	public int[] getShopList() {
		return ShopList;
	}
	
	/**
	 * This method updates the stocks by using Integer ArrayList variable input 'StockList', so 
	 * that the 'ShopList' is updated.
	 * @param StockList Integer ArrayList variable input 'StockList' containing updated Stock 
	 * information.
	 */
	public void setShopList(int[] StockList) {
		ShopList = StockList;
	}
	

}
