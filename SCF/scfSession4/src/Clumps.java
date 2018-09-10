package scfSession4.src;

public class Clumps {

	/*
	 * Give the number of clumps in array
	 * 
	 * @params arr-input array
	 * 
	 * @params size-sizee of the array
	 * 
	 * @return Returns the number of clumps in the array
	 */
	public int clumps(int[] arr) {
		int clumps = 0;
		int i = 0;

		for (i = 0; i <= (arr.length - 1); i++) {
			if (i == 0 && arr[i] == arr[i + 1]) {
				clumps++;
			} else if ((i - 1) >= 0 && (arr[i] != arr[i - 1] && arr[i] == arr[i + 1]) && (i + 1) < (arr.length)) {
				clumps++;
			}
		}
		return clumps;

	}

}
