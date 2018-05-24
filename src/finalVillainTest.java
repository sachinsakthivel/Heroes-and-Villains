import static org.junit.Assert.*;

import org.junit.Test;

public class finalVillainTest {

	@Test
	public void testGamePreference() {
		finalVillain testVillain = new finalVillain();
		int choice = testVillain.gamePreference();
		assertEquals(true, (choice >= 0 && choice <= 2));
		testVillain.setStrikes(3);
		assertEquals( 0 , testVillain.gamePreference());
		testVillain.setStrikes(2);
		assertEquals(1, testVillain.gamePreference());
		testVillain.setStrikes(1);
		assertEquals(2, testVillain.gamePreference());
	}

	@Test
	public void testFinalVillain() {
		finalVillain testVillain = new finalVillain();
		String output = new String("This is the end of the Road, I am Known as " +testVillain.getPersonName()+".");
		output += "\n" + testVillain.getTaunt();
		assertEquals(output, testVillain.toString());
	}

}
