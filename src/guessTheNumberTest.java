import static org.junit.Assert.*;

import org.junit.Test;

public class guessTheNumberTest {

	@Test
	public void testGuessTheNumber() {
		guessTheNumber testGame = new guessTheNumber();
		assertTrue(testGame.getGameName() instanceof String);
		assertTrue(testGame.getGameRules() instanceof String);
		assertTrue(testGame.gameDescription() instanceof String);
	}


	@Test
	public void testCheck() {
		guessTheNumber testGame = new guessTheNumber();
		assertEquals(true, testGame.check(2, 2));
		assertEquals(true, testGame.check(3, 4));
		assertEquals(false, testGame.check(4,3));
		
	}

}
