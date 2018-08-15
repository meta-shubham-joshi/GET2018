package scfSession4.src;

import static org.junit.Assert.*;

import org.junit.Test;

public class FixxyTest {

	@Test
	public void fixXYTest() {

		try {
			Fixxy obj = new Fixxy();

			int array1[] = new int[] { 1, 4, 1, 4, 0, 5, 5 };
			int[] result1 = obj.fixXY(array1, 4, 5);
			int arrayExpected1[] = new int[] { 1, 4, 5, 4, 5, 1, 0 };

			int array2[] = new int[] { 5, 4, 5, 5, 4, 1 };
			int[] result2 = obj.fixXY(array2, 4, 5);
			int arrayExpected2[] = new int[] { 1, 4, 5, 5, 4, 5 };

			assertArrayEquals(result1, arrayExpected1);
			assertArrayEquals(result2, arrayExpected2);
		} catch (Exception e) {
			System.out.println("Incorrect Input is given");
		}
	}

}
