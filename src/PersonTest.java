import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testPerson() {
		Person Testperson = new Person("Timmy");
		assertEquals("Timmy", Testperson.getPersonName());
		assertEquals(true, Testperson.getLiving());
		Testperson.setLiving(false);
		assertEquals(false, Testperson.getLiving());
		
	}

}
