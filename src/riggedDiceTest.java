import static org.junit.Assert.*;

import org.junit.Test;

public class riggedDiceTest {

	@Test
	public void testUse() {
		Hero testHero = new Hero("Timmy the test dummy");
		riggedDice testArmour = new riggedDice();
		String out = "Insufficient amount of "+testArmour.getItemName()+".\nPlease Buy Some from Shop";
		assertEquals(out, testArmour.use(testHero));
		assertEquals(0, testHero.getDice());
		testArmour.setItemStock(3);
		String newOut = "Power Up Successful";
		assertEquals(newOut, testArmour.use(testHero));
		assertEquals(1, testHero.getDice());
		testArmour.setItemStock(-2);
		assertEquals(out, testArmour.use(testHero));
		assertEquals(1, testHero.getDice());
	}

	@Test
	public void testRiggedDice() {
		riggedDice testArmour = new riggedDice();
		assertEquals("Weighted Dice", testArmour.getItemName());
		assertEquals(60, testArmour.getItemPrice());
		assertEquals(0, testArmour.getItemStock());
	}

}
