package scfSession4.src;

public class LargestMirror {

	int largestMirror(int[] arr) {
		int maximum = 0;

		int start = 0;
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			int length = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					start = i;
					end = j;
					while ((end != -1 && start != arr.length) && (arr[start] == arr[end])) {
						start = start + 1;
						end = end - 1;
						length++;
					}
				}
				if (maximum < length) {
					maximum = length;
				}
			}
		}
		return maximum;

	}
}
