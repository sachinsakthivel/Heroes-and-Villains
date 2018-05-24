import static org.junit.Assert.*;

import org.junit.Test;

public class diceRollsTest {

	@Test
	public void testPlay() {
		Hero testHero = new Hero("Tom");
		diceRolls testDice = new diceRolls();
		boolean gameWon = testDice.play(testHero);
	}

	@Test
	public void testDiceRolls() {
		diceRolls testDice = new diceRolls();
		assertTrue(testDice.getGameName() instanceof String);
		assertTrue(testDice.getGameRules() instanceof String);
		assertTrue(testDice.gameDescription() instanceof String);
	}

	@Test
	public void testResults() {
		diceRolls testDice = new diceRolls();
		assertTrue(testDice.results() instanceof String);
	}

}
