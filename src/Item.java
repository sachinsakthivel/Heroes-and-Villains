/**
 * The parent class for all items.
 * The class provides Object Item attributes such as Item Name, Price, Stock, Duration and Description.  
 * Includes getter and setter methods for Attributes.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 * Date: May 3rd 2018
 */

public class Item {
	
	/**
	 * String variable for Name of the Item
	 */
	private String ItemName;
	/**
	 * Integer variable for Price of Item
	 */
	private int ItemPrice;
	/**
	 * Integer variable for Stock of Item
	 */
	private int ItemStock;
	/**
	 * Integer variable for duration of some Items
	 */
	private int ItemDuration;
	/**
	 * String variable for a brief description of the Item.
	 */
	private String ItemDescription;
	
	
	/**
	 * Constructor method for Item class
	 * Item Duration for all items are set to 1 by default as not all items has a effect that is
	 * applied over a time period.
	 * @param Name String variable of Item Name
	 * @param Price Integer variable of Item Price
	 * @param Stock Integer variable of Item Stock
	 */
	public Item(String Name, int Price, int Stock) {
		setItemName(Name);
		setItemPrice(Price);
		setItemStock(Stock);
		setItemDuration(-1);
	}
	
	/**
	 * The use() method is specified for each Item Type. 
	 * @param chosenHero Hero chosen to which the item will be applied.
	 * @return Returns String variable "Not Working".
	 */
	public String use(Hero chosenHero) {
		return "Not Working";
	}

	/**
	 * This method return the Item's Name.
	 * @return String variable Item's name.
	 */
	public String getItemName() {
		return ItemName;
	}

	/**
	 * This method sets the Item's Name to 'itemName'.
	 * @param itemName String variable of Item's name.
	 */
	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	/**
	 * This method return the Item's Price.
	 * @return Integer variable of Item's Price.
	 */
	public int getItemPrice() {
		return ItemPrice;
	}

	/**
	 * This method sets the Item's Price to 'itemPrice'.
	 * @param itemPrice Integer variable of Item Price.
	 */
	public void setItemPrice(int itemPrice) {
		ItemPrice = itemPrice;
	}

	/**
	 * This method return the Item's Stock.
	 * @return Integer variable of Item's Stock.
	 */
	public int getItemStock() {
		return ItemStock;
	}

	/**
	 * This method sets the Items's Stock to 'itemStock'.
	 * @param itemStock Integer of variable of Item Stock.
	 */
	public void setItemStock(int itemStock) {
		ItemStock = itemStock;
	}

	/**
	 * This method return the Item's Duration.
	 * @return Integer variable of Item's Duration.
	 */
	public int getItemDuration() {
		return ItemDuration;
	}

	/**
	 * This method sets the Item's Duration to 'itemDuration'.
	 * @param itemDuration Integer of variable of Item's Duration.
	 */
	public void setItemDuration(int itemDuration) {
		ItemDuration = itemDuration;
	}

	/**
	 * This method return the Item's Description.
	 * @return String variable Item's Description.
	 */
	public String getItemDescription() {
		return ItemDescription;
	}

	/**
	 * This method sets the Item's Description to 'itemDescription'.
	 * @param itemDescription String variable of Item's Description.
	 */
	public void setItemDescription(String itemDescription) {
		ItemDescription = itemDescription;
	}
	
}
