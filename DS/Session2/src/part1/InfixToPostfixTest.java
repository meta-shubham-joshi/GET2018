package part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

	@Test
	public void testInfixToPostfixPass() {

		InfixToPostfix ip = new InfixToPostfix();
		String res1 = "3 4 5 * 6 / +";
		String res2 = "37+*56*";
		assertEquals(res1, ip.infixToPostfix("3 + 4 * 5 / 6"));
		assertEquals(res2, ip.infixToPostfix("( 3 + 7 ) * ( 5 * 6 ) "));
	}

	@Test
	public void testInfixToPostfixFail() {

		InfixToPostfix ip = new InfixToPostfix();
		String res1 = "3 4 5 * 6 / +";
		String res2 = "37+*56*";
		assertNotEquals(res1, ip.infixToPostfix("3 + 4 * 5 / 6"));
		assertNotEquals(res2, ip.infixToPostfix("( 3 + 7 ) * ( 5 * 6 ) "));
	}

}
