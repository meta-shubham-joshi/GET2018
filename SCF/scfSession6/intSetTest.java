package scfSession6;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class intSetTest {

	@Test
	public void testisMemberpass() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };

		intSet obj1 = new intSet(arr1);
		assertEquals(true, obj1.isMember(4));

	}

	@Test
	public void testisMemberfail() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };

		intSet obj1 = new intSet(arr1);
		assertNotEquals(true, obj1.isMember(8));

	}

	@Test
	public void testsizepass() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };

		intSet obj1 = new intSet(arr1);
		int len = arr1.length;

		assertEquals(len, obj1.size());

	}

	@Test
	public void testsizefail() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };

		intSet obj1 = new intSet(arr1);
		int len = 4;
		assertNotEquals(len, obj1.size());

	}

	@Test
	public void testsubsetpass() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };
		int arr2[] = { 1, 2, 3 };

		intSet obj1 = new intSet(arr1);
		intSet obj2 = new intSet(arr2);

		assertEquals(true, obj1.isSubSet(obj2));
	}

	@Test
	public void testsubsetfail() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };
		int arr2[] = { 1, 2, 3 };

		intSet obj1 = new intSet(arr1);
		intSet obj2 = new intSet(arr2);

		assertNotEquals(false, obj1.isSubSet(obj2));
	}

	@Test
	public void testcomplementpass() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };
		int i;

		int[] arr2 = new int[994];

		arr2[0] = 7;

		for (i = 1; i < 994; i++)
			arr2[i] = arr2[i - 1] + 1;

		intSet obj1 = new intSet(arr1);

		assertArrayEquals(arr2, obj1.getComplement());
	}

	@Test
	public void testcomplementfail() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };
		int i;

		int[] arr2 = new int[1000 - arr1.length];

		arr2[0] = arr1[arr1.length - 1];

		for (i = 1; i < 1000 - arr1.length; i++)
			arr2[i] = arr2[i - 1];

		intSet obj1 = new intSet(arr1);

		assertFalse(Arrays.equals(arr2, obj1.getComplement()));

	}

	@Test
	public void testUnionpass() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };
		int arr2[] = { 1, 2, 8, 9 };
		int arr3[] = { 1, 2, 3, 4, 5, 6, 8, 9, 0, 0 };

		intSet obj1 = new intSet(arr1);
		intSet obj2 = new intSet(arr2);
		intSet obj3 = new intSet(arr3);

		assertArrayEquals(arr3, obj3.union(obj1, obj2));

	}

	@Test
	public void testUnionfail() {

		int arr1[] = { 1, 2, 3, 4, 5, 6 };
		int arr2[] = { 1, 2, 8, 9 };
		int arr3[] = { 1, 2, 3, 4, 5, 8, 9 };

		intSet obj1 = new intSet(arr1);
		intSet obj2 = new intSet(arr2);
		intSet obj3 = new intSet(arr3);
		assertFalse(Arrays.equals(arr3, obj3.union(obj1, obj2)));

	}

}
