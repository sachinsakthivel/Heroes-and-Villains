import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HeroTest {

	@Test
	public void testSetMaximumHealth() {
		Hero testHero = new Hero("Timmy");
		testHero.setMaximumHealth(120);
		assertEquals(120, testHero.getMaximumHealth());
	}

	@Test
	public void testSetCurrentHealth() {
		Hero testHero = new Hero("Timmy");
		testHero.setCurrentHealth(45);
		assertEquals(45, testHero.getCurrentHealth());
	}

	@Test
	public void testCheckdeath() {
		Hero testHero = new Hero("Timmy");
		testHero.setCurrentHealth(20);
		testHero.checkdeath();
		assertEquals(true, testHero.getLiving());
		testHero.setCurrentHealth(0);
		testHero.checkdeath();;
		assertEquals(false, testHero.getLiving());
		testHero.setCurrentHealth(-24);
		testHero.checkdeath();
		assertEquals(false, testHero.getLiving());
	}

	@Test
	public void testToString() {
		Hero testHero = new Hero("Timmy");
		String out = "This person is named: " + testHero.getPersonName() + "\nType: " + testHero.getType() +"\nHealth: " + testHero.getCurrentHealth() + "/"+ testHero.getMaximumHealth();
		out += "\nArmour: " + testHero.getArmour() + "\nLuck: " + (testHero.getSkill() + testHero.getDice());
		assertEquals(out, testHero.toString());
	}

	@Test
	public void testSetSkill() {
		Hero testHero = new Hero("Timmy");
		testHero.setSkill(3);
		assertEquals(3, testHero.getSkill());
		
	}

	@Test
	public void testSetArmour() {
		Hero testHero = new Hero("Timmy");
		testHero.setArmour(4);
		assertEquals(4, testHero.getArmour());
	}

	@Test
	public void testSetType() {
		Hero testHero = new Hero("Timmy");
		testHero.setType("Unknown");
		assertEquals("Unknown", testHero.getType());
	}
	
	@Test
	public void testSetDice() {
		Hero testHero = new Hero("Timmy");
		testHero.setDice(10);
		assertEquals(10, testHero.getDice());
	}
	

}
