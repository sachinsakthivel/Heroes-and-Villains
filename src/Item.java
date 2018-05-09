import java.util.*;


public class Item {
	private String ItemName;
	private int ItemPrice;
	private int ItemStock;
	
	public Item(String Name, int Price, int Stock) {
		setItemName(Name);
		setItemPrice(Price);
		setItemStock(Stock);
	}
	
	public void use(Hero chosenHero) {
		
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(int itemPrice) {
		ItemPrice = itemPrice;
	}


	public int getItemStock() {
		return ItemStock;
	}

	public void setItemStock(int itemStock) {
		ItemStock = itemStock;
	}
	
}
