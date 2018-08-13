package part1;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class EvaluatePostfixTest {

	@Test
	public void testAdditionPass() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertEquals(129, ep.getExpressionValue("124 + 5"));
		} catch (EmptyStackException e) {
			System.out.println("Stack is empty so we cannot pop a element from it.. Sorry!!..");
			System.out.println(e);
		}
	}

	@Test
	public void testAdditionFail() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertNotEquals(130, ep.getExpressionValue("124 5 +"));
		} catch (EmptyStackException e) {
			System.out.println("Stack is empty so we cannot pop a element from it.. Sorry!!..");
			System.out.println(e);
		}
	}

	@Test
	public void testMultiplicationPass() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertEquals(20, ep.getExpressionValue("4 5 *"));
		} catch (EmptyStackException e) {
			System.out.println("Stack is empty so we cannot pop a element from it.. Sorry!!..");
			System.out.println(e);
		}
	}

	@Test
	public void testMultiplicationFail() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertNotEquals(130, ep.getExpressionValue("4 5 *"));
		} catch (EmptyStackException e) {
			System.out.println("Stack is empty so we cannot pop a element from it.. Sorry!!..");
			System.out.println(e);
		}
	}

	@Test
	public void testSubtractionPass() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertEquals(7, ep.getExpressionValue("12 5 -"));
		} catch (EmptyStackException e) {
			System.out.println("Stack is empty so we cannot pop a element from it.. Sorry!!..");
			System.out.println(e);
		}
	}

	@Test
	public void testSubtractionFail() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertNotEquals(130, ep.getExpressionValue("12 5 -"));
		} catch (EmptyStackException e) {
			System.out.println("Stack is empty so we cannot pop a element from it.. Sorry!!..");
			System.out.println(e);
		}
	}

	@Test
	public void testDivisionPass() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertEquals(2, ep.getExpressionValue("10 0 /"));
		} catch (ArithmeticException e) {
			System.out.println("Cannot be divided by Zero..");
			System.out.println(e);
		}
	}

	@Test
	public void testDivisionFail() {

		try {
			EvaluatePostfix ep = new EvaluatePostfix();
			assertNotEquals(1, ep.getExpressionValue("10 5 /"));
		} catch (ArithmeticException e) {
			System.out.println("Cannot be divided by Zero..");
			System.out.println(e);
		}
	}

}
