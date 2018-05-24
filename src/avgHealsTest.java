import static org.junit.Assert.*;

import org.junit.Test;

public class avgHealsTest {

	@Test
	public void testUse() {
		Hero testHero = new Hero("Timmy the fuckboi");
		avgHeals testHeal = new avgHeals();
		String out = "Insufficient amount of "+testHeal.getItemName()+". \nPlease Buy Some from Shop";
		assertEquals(out, testHeal.use(testHero));
		testHeal.setItemStock(3);
		testHero.setCurrentHealth(20);
		testHeal.use(testHero);
		String out2 = "Healing Procedure Has Started";
		out2 += " \n\nHero: "+testHero.getPersonName()+ " has been moved into Healing Ward from Team." + "\n";
		assertEquals(out2, testHeal.use(testHero));
		assertEquals( 70, testHero.getCurrentHealth());
		testHero.setCurrentHealth(testHero.getMaximumHealth());
		assertEquals(100 , testHeal.use(testHero));
	}

	@Test
	public void testAvgHeals() {
		avgHeals testHeal = new avgHeals();
		assertEquals("Average Heal Tickets", testHeal.getItemName());
		assertEquals(50 , testHeal.getItemPrice());
		assertEquals(0 , testHeal.getItemStock());
	}

}
