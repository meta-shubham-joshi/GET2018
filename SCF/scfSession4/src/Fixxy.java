package scfSession4.src;

public class Fixxy {

	/*
	 * Give the rearranged array
	 * 
	 * @param arr-input array
	 * 
	 * @param x-input integer
	 * 
	 * @param y-input integer
	 * 
	 * @return Returns the rearranged array
	 */
	public int[] fixXY(int[] arr, int x, int y) {
		int counter = 0;
		for (int itr = 0; itr < arr.length - 1; itr++) {
			if (arr[itr] == x && arr[itr + 1] != y) {
				int temp = arr[itr + 1];

				while (counter < arr.length) {
					if (arr[counter] == y) {
						arr[counter] = temp;
						counter = itr + 2;
						break;
					}
					counter++;
				}
				arr[itr + 1] = y;
			}
		}
		return arr;
	}

}
