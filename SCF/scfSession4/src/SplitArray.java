package scfSession4.src;

public class SplitArray {

	/*
	 * Give the index of the splitting array
	 * 
	 * @params arr-input array
	 * 
	 * @return Returns the index of the splitting array
	 */
	public int splitArray(int[] arr) {
		int sum = 0;
		int leftsum = 0;
		int i;

		for (i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}

		for (i = 0; i < arr.length; i++) {
			sum -= arr[i];

			if ((leftsum + arr[i]) == sum) {
				return i + 1;
			}
			leftsum = leftsum + arr[i];
		}
		return -1;
	}

}
