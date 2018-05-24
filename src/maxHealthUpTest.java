import static org.junit.Assert.*;

import org.junit.Test;

public class maxHealthUpTest {

	@Test
	public void testUse() {
		Hero testHero = new Hero("Timmy the test dummy");
		maxHealthUp testItem = new maxHealthUp();
		String out = "Insufficient amount of "+testItem.getItemName()+".\nPlease Buy Some from Shop";
		assertEquals(out, testItem.use(testHero));
		assertEquals(100, testHero.getMaximumHealth());
		testItem.setItemStock(3);
		String newOut = "Power Up Successful";
		assertEquals(newOut, testItem.use(testHero));
		assertEquals(120, testHero.getMaximumHealth());
		testItem.setItemStock(-2);
		assertEquals(out, testItem.use(testHero));
		assertEquals(120, testHero.getMaximumHealth());
	}

	@Test
	public void testMaxHealthUp() {
		maxHealthUp testItem = new maxHealthUp();
		assertEquals("MaxHealthUp Potions", testItem.getItemName());
		assertEquals(80, testItem.getItemPrice());
		assertEquals(0, testItem.getItemStock());
	}

}
