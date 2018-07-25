import java.lang.Math;

public final class Polynomial {

	private int[][] arr;

	/*
	 * Constructor to initialise the array
	 */
	public Polynomial(int[][] Array) {
		
		int size = Array.length;
		arr = new int[size][2];
		int i;

		for (i = 0; i < Array.length; i++) {
			this.arr[i][0] = Array[i][0];
			this.arr[i][1] = Array[i][1];
		}
	}

	/*
	 * Evaluating the length of the array.
	 */
	public float evaluate(float num) {

		float ans = 0;
		int i;

		for (i = 0; i < this.arr.length; i++) {

			ans += (this.arr[i][0]) * (Math.pow(num, this.arr[i][1]));
		}

		return ans;
	}

	/*
	 * Return the degree of the polynomial
	 */
	public int degree() {

		return this.arr[0][0];
	}

	/*
	 * Method to add two polynomial.
	 */
	public int[][] addPoly(int[][] arr1, int[][] arr2) {

		int i;
		int j;
		int k = 0;

		int size = arr1.length >= arr2.length ? arr1.length : arr2.length;

		int[][] ans = new int[size][2];

		for (i = 0, j = 0; i < arr1.length && j < arr2.length;) {

			if (arr1[i][1] > arr2[j][1]) {
				ans[k][0] = arr1[i][0];
				ans[k][1] = arr1[i][1];
				k++;
				i++;
			} else if (arr1[i][1] < arr2[j][1]) {
				ans[k][0] = arr2[j][0];
				ans[k][1] = arr2[j][1];
				k++;
				j++;
			} else if (arr1[i][1] == arr2[j][1]) {
				ans[k][0] = arr1[i][0] + arr2[j][0];
				ans[k][1] = arr1[i][1];
				k++;
				i++;
				j++;
			}

		}

		while (i < arr1.length) {
			ans[k][0] = arr1[i][0];
			ans[k][1] = arr1[i][1];
			k++;
			i++;
		}

		while (j < arr2.length) {
			ans[k][0] = arr2[j][0];
			ans[k][1] = arr2[j][1];
			k++;
			j++;
		}
		return ans;

	}

	/*
	 * Methods to multiply two polynomial.
	 */

	public int[] multiplyPoly(int[][] arr1, int[][] arr2) {

		int size = arr1[0][1] + arr2[0][1];

		int[] ans = new int[size+1];
		int i;
		int j;
		try{
		for (i = 0; i < arr1.length; i++) {

			for (j = 0; j < arr2.length; j++) {

				ans[arr1[i][1] + arr2[j][1]] += (arr1[i][0] * arr2[j][0]);

			}
		}
	}catch(Exception e ){
		System.out.println("Error message : "+ e.getMessage());
	}
		
		return ans;

	}
}
