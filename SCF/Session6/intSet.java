import java.util.Arrays;

public final class intSet implements UniversalSet {

	private final int[] arr;

	/*
	 * Initialising the value in the array and checking repeating or not and
	 * storing in the class array.
	 * 
	 * @params Array- input array
	 */
	public intSet(int Array[]) {

		int i = 0;
		int j = 0;

		arr = new int[Array.length];

		while (i < Array.length) {

			if (isMember(Array[i])) {
				i++;
			} else {
				this.arr[j] = Array[i];
				j++;
				i++;
			}
		}
	}

	/*
	 * Returning whether the given value is a element of the array or not.
	 * 
	 * @params val-value to be checked.
	 * 
	 * @return return true if present else false.
	 */
	public boolean isMember(int val) {

		for (int i = 0; i < this.arr.length; i++) {

			if (this.arr[i] == val)
				return true;
			
		}
		return false;
	}

	/*
	 * Returns the size of the array.
	 */
	public int size() {

		return this.arr.length;
	}

	/*
	 * check whether it is a subset or not.
	 * 
	 * @params s1- object which contains the array.
	 * 
	 * @return Return 1 if it is a subset else return 0.
	 */
	public boolean isSubSet(intSet s1) {

		int len1 = this.arr.length;
		int len2 = s1.arr.length;

		int i;
		int j;

		for (i = 0; i <= (len1 - len2); i++) {
			int k = i;
			for (j = 0; j < len2; j++) {

				if (this.arr[k] != s1.arr[j]) {
					break;
				} else {
					k++;
				}

			}
			if (j == len2)
				return true;
		}
		return false;

	}

	/*
	 * Return the complemented set.
	 * 
	 * @return Returns the array which is complementary of the array.
	 */
	public int[] getComplement() {

		int i;
		int[] hash = new int[1001];
		int[] ans = new int[994];
		int k = 0;

		for (i = 0; i < this.arr.length; i++)
			hash[this.arr[i]] = 1;

		for (i = 1; i <= 1000; i++) {
			if (hash[i] == 0) {
				ans[k++] = i;
			}
		}

		return ans;
	}

	/*
	 * Return the union of the array.
	 * 
	 * @params s1-input array first.
	 * 
	 * @params s2-input array second.
	 * 
	 * @return Return the union of the two array.
	 */
	public int[] union(intSet s1, intSet s2) {

		int i;
		int j;
		int k = 0;

		Arrays.sort(s1.arr);
		Arrays.sort(s2.arr);

		int size = s1.arr.length >= s2.arr.length ? s1.arr.length : s2.arr.length;
		int[] array = new int[s1.arr.length + s2.arr.length];

		for (i = 0, j = 0; i < s1.arr.length && j < s2.arr.length;) {

			if (s1.arr[i] < s2.arr[j]) {
				array[k++] = s1.arr[i];
				i++;
			} else if (s1.arr[i] > s2.arr[j]) {
				array[k++] = s2.arr[j];
				j++;
			} else {
				array[k++] = s1.arr[i];
				i++;
				j++;
			}
		}

		while (i < s1.arr.length) {
			array[k++] = s1.arr[i];
			i++;
		}

		while (j < s2.arr.length) {
			array[k++] = s2.arr[j];
			j++;
		}
		return array;

	}

}
