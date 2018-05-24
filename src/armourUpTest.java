import static org.junit.Assert.*;

import org.junit.Test;

public class armourUpTest {

	@Test
	public void testArmourUp() {
		armourUp testArmour = new armourUp();
		assertEquals("Armour Piece", testArmour.getItemName());
		assertEquals(120, testArmour.getItemPrice());
		assertEquals(0, testArmour.getItemStock());
	}

	
	@Test
	public void testUse() {
		Hero testHero = new Hero("Timmy the test dummy");
		armourUp testArmour = new armourUp();
		String out = "Insufficient amount of "+testArmour.getItemName()+".\nPlease Buy Some from Shop";
		assertEquals(out, testArmour.use(testHero));
		testArmour.setItemStock(3);
		String newOut = "Power Up Successful";
		assertEquals(newOut, testArmour.use(testHero));
		testArmour.setItemStock(-2);
		assertEquals(out, testArmour.use(testHero));
	}

}
