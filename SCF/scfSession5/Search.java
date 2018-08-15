package scfSession5;

public class Search {

	/*
	 * Searching a element using linear search.
	 * 
	 * @param arr-input array.
	 * 
	 * @param target-value to be searched.
	 * 
	 * @param start-starting index of the array.
	 * 
	 * @param end-ending index of the array.
	 * 
	 * @return return whether the element is present or not.
	 */
	public int linearSearch(int[] arr, int target, int start, int end) {

		if (start > end)
			return -1;

		if (arr[start] == target)
			return 1;

		return linearSearch(arr, target, start + 1, end);
	}

	/*
	 * Searching a element using binary search.
	 * 
	 * @param arr-input array.
	 * 
	 * @param start-starting index of the array.
	 * 
	 * @param target-element to be searched.
	 * 
	 * @param end-ending index of the array.
	 * 
	 * @return returns whether element is present or not in the array.
	 */
	public int binarySearch(int arr[], int target, int start, int end) {

		if (start > end)
			return -1;

		int mid = (start + (end)) / 2;

		if (arr[mid] == target)
			return 1;

		if (arr[mid] > target)
			return binarySearch(arr, target, start, mid - 1);
		else
			return binarySearch(arr, target, mid + 1, end);
	}
}
