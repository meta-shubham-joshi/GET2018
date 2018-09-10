package scfSession4.src;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestMirrorTest {

	@Test
	public void largestMirrorTest() {

		try {
			int input1[] = new int[] { 1, 2, 3, 8, 9, 3, 2, 1 };
			int input2[] = new int[] { 7, 1, 4, 9, 7, 4, 1 };
			int input3[] = new int[] { 1, 2, 1, 4 };
			int input4[] = new int[] { 1, 4, 5, 3, 5, 4, 1 };

			LargestMirror lm = new LargestMirror();

			assertEquals(3, lm.largestMirror(input1));
			assertEquals(2, lm.largestMirror(input2));
			assertEquals(3, lm.largestMirror(input3));
			assertEquals(7, lm.largestMirror(input4));
		} catch (Exception e) {
			System.out.println("Incorrect input is given");
		}

	}

}
