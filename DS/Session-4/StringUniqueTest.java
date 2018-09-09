package question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUniqueTest {

	@Test
	public void testStringUniquePass() {

		StringUnique su = new StringUnique();

		assertEquals(6, su.countUniqueChars("shubham"));
		assertEquals(5, su.countUniqueChars("shubha"));

	}

	@Test
	public void testStringUniqueFail() {

		StringUnique su = new StringUnique();

		assertNotEquals(0, su.countUniqueChars("shubham"));
		assertNotEquals(2, su.countUniqueChars("shubha"));

	}

}
