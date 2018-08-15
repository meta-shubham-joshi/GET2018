package scfSession6;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

	@Test
	public void testevaluatepass() {

		int arr1[][] = { { 5, 3 }, { 2, 2 }, { 1, 1 }, { 1, 0 } };

		Polynomial obj = new Polynomial(arr1);
		assertEquals(9, obj.evaluate(1), 0.2);
	}

	@Test
	public void testevaluatefail() {

		int arr1[][] = { { 5, 3 }, { 2, 2 }, { 1, 1 }, { 1, 0 } };

		Polynomial obj = new Polynomial(arr1);
		assertNotEquals(4, obj.evaluate(4));
	}

	@Test
	public void testdegreepass() {

		int arr1[][] = { { 5, 3 }, { 2, 2 }, { 1, 1 }, { 1, 0 } };

		Polynomial obj = new Polynomial(arr1);
		assertEquals(5, obj.degree());
	}

	@Test
	public void testdegreefail() {

		int arr1[][] = { { 5, 3 }, { 2, 2 }, { 1, 1 }, { 1, 0 } };

		Polynomial obj = new Polynomial(arr1);
		assertNotEquals(9, obj.degree());
	}

	@Test
	public void testaddpolypass() {

		int arr1[][] = { { 5, 3 }, { 2, 2 }, { 1, 1 }, { 1, 0 } };
		int arr2[][] = { { 4, 3 }, { 1, 1 }, { 1, 0 } };
		int arr3[][] = { { 9, 3 }, { 2, 2 }, { 2, 1 }, { 2, 0 } };

		Polynomial obj = new Polynomial(arr3);

		assertArrayEquals(arr3, obj.addPoly(arr1, arr2));
	}

	@Test
	public void testmultiplypolypass() {

		int arr1[][] = { { 5, 4 }, { 7, 1 } };
		int arr2[][] = { { 2, 1 }, { 1, 0 } };
		int[] arr3 = { 0, 7, 14, 0, 5, 10 };

		Polynomial obj = new Polynomial(arr1);
		int i;
		int[] ans = obj.multiplyPoly(arr1, arr2);

		System.out.println("valus of size of  array is : " + ans.length);
		for (i = 0; i < ans.length; i++) {
			System.out.println("valus of answer array is : " + ans[i]);
		}

		assertArrayEquals(arr3, obj.multiplyPoly(arr1, arr2));
	}

}
