import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensTest {

	@Test
	public void NQueenstestpass() {

		try {
			NQueens nq = new NQueens();
			int[][] inputboard = new int[4][4];

			boolean val = nq.solveNUtils(inputboard, 0);

			assertEquals(true, val);
		} catch (Exception e) {
			System.out.println("Something wrong has happened!!..");
		}
	}

	@Test
	public void NQueenstestfail() {

		try {
			NQueens nq = new NQueens();
			int[][] inputboard = new int[4][4];

			boolean val = nq.solveNUtils(inputboard, 0);

			assertNotEquals(false, val);
		} catch (Exception e) {
			System.out.println("Something wrong has happened!!..");
		}
	}

}
