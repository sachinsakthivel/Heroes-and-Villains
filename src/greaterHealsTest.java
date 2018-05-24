import static org.junit.Assert.*;

import org.junit.Test;

public class greaterHealsTest {

	@Test
	public void testUse() {
		Hero testHero = new Hero("Timmy the fuckboi");
		greaterHeals testHeal = new greaterHeals();
		String out = "Insufficient amount of "+testHeal.getItemName()+". \nPlease Buy Some from Shop";
		assertEquals(out, testHeal.use(testHero));
		testHeal.setItemStock(3);
		testHero.setCurrentHealth(20);
		testHeal.use(testHero);
		String out2 = "Healing Procedure Has Started";
		out2 += " \n\nHero: "+testHero.getPersonName()+ " has been moved into Healing Ward from Team." + "\n";
		assertEquals(out2, testHeal.use(testHero));
		testHero.setCurrentHealth(testHero.getMaximumHealth());
		assertEquals(out2 , testHeal.use(testHero));
	}

	@Test
	public void testGreaterHeals() {
		greaterHeals testHeal = new greaterHeals();
		assertEquals("Greater Heal Tickets", testHeal.getItemName());
		assertEquals(100 , testHeal.getItemPrice());
		assertEquals(0 , testHeal.getItemStock());
	}

}
