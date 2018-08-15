package scfSession4.src;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitArrayTest {

	@Test
	public void splitArrayTest() {
		try {
			SplitArray obj = new SplitArray();

			int[] arr1 = new int[] { 1, 1, 1, 2, 1 };
			int[] arr2 = new int[] { 2, 1, 1, 2, 1 };
			int[] arr3 = new int[] { 10, 10 };

			assertEquals(3, obj.splitArray(arr1));
			assertEquals(-1, obj.splitArray(arr2));
			assertEquals(1, obj.splitArray(arr3));

		} catch (Exception e) {
			System.out.println("Incorrect Input!!..");
		}
	}

}
