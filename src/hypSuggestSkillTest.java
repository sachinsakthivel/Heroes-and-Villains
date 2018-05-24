import static org.junit.Assert.*;

import org.junit.Test;

public class hypSuggestSkillTest {

	@Test
	public void testUse() {
		Hero testHero = new Hero("Timmy the test dummy");
		hypSuggestSkill testItem = new hypSuggestSkill();
		String out = "Insufficient amount of "+testItem.getItemName()+".\nPlease Buy Some from Shop";
		assertEquals(out, testItem.use(testHero));
		assertEquals(0, testHero.getSkill());
		testItem.setItemStock(3);
		String newOut = "Power Up Successful";
		assertEquals(newOut, testItem.use(testHero));
		assertEquals(1, testHero.getSkill());
		testItem.setItemStock(-2);
		assertEquals(out, testItem.use(testHero));
		assertEquals(1, testHero.getSkill());
		
	}

	@Test
	public void testHypSuggestSkill() {
		hypSuggestSkill testItem = new hypSuggestSkill();
		assertEquals("Hypnotic Suggestion Skillbook", testItem.getItemName());
		assertEquals(90, testItem.getItemPrice());
		assertEquals(0, testItem.getItemStock());
	}

}
