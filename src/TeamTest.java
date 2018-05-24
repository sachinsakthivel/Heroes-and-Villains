import static org.junit.Assert.*;

import org.junit.Test;

public class TeamTest {

	@Test
	public void testAddToTeam() {
		Team testTeam = new Team("The T-team", 3);
		Hero testHero = new Hero("Timmy");
		testTeam.addToTeam(testHero);
		assertTrue((testTeam.getTeam().contains(testHero)));
		int newCoins = testTeam.getCoins() +1;
		testTeam.setCoins(newCoins);
		assertEquals(testTeam.getCoins(), newCoins );
		testTeam.addToTeam(testHero);
		assertEquals(1, testTeam.getTeam().size());
	}

	@Test
	public void testRemoveOffTeam() {
		Team testTeam = new Team("The T-team", 3);
		Hero testHero = new Hero("Timmy");
		testTeam.addToTeam(testHero);
		assertTrue((testTeam.getTeam().contains(testHero)));
		testTeam.removeOffTeam(testHero);
		assertFalse(testTeam.getTeam().contains(testHero));
		testTeam.removeOffTeam(testHero);
		assertEquals(testTeam.getTeam().size(), 0);
	}

	@Test
	public void testCheckDead() {
		Team testTeam = new Team("The T-team", 3);
		Hero testHero = new Hero("Timmy");
		testTeam.addToTeam(testHero);
		assertFalse(testTeam.checkDead(null));
		testTeam.moveToWard(testHero);
		assertFalse(testTeam.checkDead(null));
		testTeam.releaseFromWard(testHero);
		testTeam.removeOffTeam(testHero);
		assertTrue(testTeam.checkDead(null));
	}
	

	@Test
	public void testTypeCheck() {
		Team testTeam = new Team("The T-team", 3);
		pathFinder pathguy = new pathFinder("Tomas");
		mentalMonk krillin = new mentalMonk("DBZEVO");
		testTeam.addToTeam(krillin);
		assertTrue(testTeam.typeCheck(krillin.getType()));
		assertFalse(testTeam.typeCheck(pathguy.getType()));
		testTeam.addToTeam(pathguy);
		assertTrue(testTeam.typeCheck(pathguy.getType()));
		testTeam.removeOffTeam(krillin);
		assertFalse(testTeam.typeCheck(krillin.getType()));
	}

	@Test
	public void testNameCheck() {
		Team testTeam = new Team("The T-team", 3);
		Hero testHero = new Hero("Timmy");
		assertFalse(testTeam.nameCheck(testHero.getPersonName()));
		testTeam.addToTeam(testHero);
		assertTrue(testTeam.nameCheck(testHero.getPersonName()));
		Hero testHero2 = new Hero("timmy");
		assertFalse(testTeam.nameCheck(testHero2.getPersonName()));
		testTeam.addToTeam(testHero2);
		testTeam.removeOffTeam(testHero);
		assertFalse(testTeam.nameCheck(testHero.getPersonName()));
		
	}



}
