import static org.junit.Assert.*;

import org.junit.Test;

public class MathematicalOperationsTest {

	@Test
	public void mathematicaloperationtestpass() {

		try {
			MathematicalOperations obj = new MathematicalOperations();

			assertEquals(6, obj.leastCommonMultiple(1, 6));
			assertEquals(1, obj.highestCommonFactor(1, 6));
		} catch (Exception e) {
			System.out.println("Something wrong has happened!!..");
		}

	}

	@Test
	public void mathematicaloperationtestfail() {

		try {
			MathematicalOperations obj = new MathematicalOperations();

			assertNotEquals(4, obj.leastCommonMultiple(1, 6));
			assertNotEquals(2, obj.highestCommonFactor(1, 6));
		} catch (Exception e) {
			System.out.println("Something wrong has happened!!..");
		}
	}

}
