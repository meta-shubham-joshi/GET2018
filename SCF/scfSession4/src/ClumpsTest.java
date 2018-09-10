package scfSession4.src;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClumpsTest {

	@Test
	public void clumpsTest() {

		try {
			Clumps ct = new Clumps();

			int[] arr1 = new int[] { 1, 2, 2, 3, 4, 4 };
			int[] arr2 = new int[] { 1, 1, 2, 1, 1 };
			int[] arr3 = new int[] { 1, 1, 1, 1, 1 };

			assertEquals(2, ct.clumps(arr1));
			assertEquals(2, ct.clumps(arr2));
			assertEquals(1, ct.clumps(arr3));
		} catch (Exception e) {
			System.out.println("Incorrect input is given!!..");
		}

	}

}
