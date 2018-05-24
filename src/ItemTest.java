import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testSetItemName() {
		Item testItem = new Item("testItem", 20, 30);
		testItem.setItemName("blah");
		assertEquals("blah", testItem.getItemName());
	}

	@Test
	public void testSetItemPrice() {
		Item testItem = new Item("testItem", 20, 30);
		testItem.setItemPrice(45);
		assertEquals(45, testItem.getItemPrice());
	}

	@Test
	public void testSetItemStock() {
		Item testItem = new Item("testItem", 20, 30);
		testItem.setItemStock(54);
		assertEquals(54, testItem.getItemStock());
	}

	@Test
	public void testSetItemDuration() {
		Item testItem = new Item("testItem", 20, 30);
		assertEquals(-1, testItem.getItemDuration());
		testItem.setItemDuration(39);
		assertEquals(39, testItem.getItemDuration());
		
	}

	@Test
	public void testSetItemDescription() {
		Item testItem = new Item("testItem", 20, 30);
		testItem.setItemDescription("Not an item");
		assertEquals("Not an item", testItem.getItemDescription());
	}

}
