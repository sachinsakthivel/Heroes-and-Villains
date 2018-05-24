import static org.junit.Assert.*;

import org.junit.Test;

public class lesserHealsTest {

	@Test
	public void testUse() {
		Hero testHero = new Hero("Timmy the fuckboi");
		lesserHeals testHeal = new lesserHeals();
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
	public void testLesserHeals() {
		lesserHeals testHeal = new lesserHeals();
		assertEquals("Lesser Heal Tickets", testHeal.getItemName());
		assertEquals(20 , testHeal.getItemPrice());
		assertEquals(0 , testHeal.getItemStock());
	}

}
