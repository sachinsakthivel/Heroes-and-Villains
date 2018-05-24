import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VillainTest {


	@Test
	public void testSetDamage() {
		Villain testVillain = new Villain();
		testVillain.setDamage(34);
		assertEquals(34, testVillain.getDamage());
	}

	@Test
	public void testSetStrikes() {
		Villain testVillain = new Villain();
		testVillain.setStrikes(4);
		assertEquals(4, testVillain.getStrikes());
	}

	@Test
	public void testSetTaunt() {
		Villain testVillain = new Villain();
		testVillain.setTaunt("Rooar");
		assertEquals("Rooar", testVillain.getTaunt());
	}


	@Test
	public void testGamePreference() {
		Villain testVillain = new Villain();
		int choice = testVillain.gamePreference();
		assertEquals(true, (choice >= 0 && choice <= 2));

	}

	@Test
	public void testCheckdeath() {
		Villain testVillain = new Villain();
		assertEquals(false, testVillain.checkdeath());
		testVillain.setStrikes(0);
		assertEquals(true, testVillain.checkdeath());
		assertEquals(false, testVillain.getLiving());
		testVillain.setStrikes(-3);
		assertEquals(true, testVillain.checkdeath());
		assertEquals(false, testVillain.getLiving());
	}

}
