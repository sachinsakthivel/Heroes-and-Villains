import static org.junit.Assert.*;

import org.junit.Test;

public class rockPaperScissorsTest {

	@Test
	public void testRockPaperScissors() {
		rockPaperScissors testGame = new rockPaperScissors();
		assertTrue(testGame.getGameName() instanceof String);
		assertTrue(testGame.getGameRules() instanceof String);
		assertTrue(testGame.gameDescription() instanceof String);
	}

	@Test
	public void testPlayHeroInt() {
		rockPaperScissors testGame = new rockPaperScissors();
		testGame.play(1);
		testGame.play(2);
		testGame.play(3);
	}

	@Test
	public void testVillianPick() {
		rockPaperScissors testGame = new rockPaperScissors();
		testGame.VillianPick();
	}

	@Test
	public void testResults() {
		rockPaperScissors testGame = new rockPaperScissors();
		assertTrue(testGame.results() instanceof String);
	}

}
