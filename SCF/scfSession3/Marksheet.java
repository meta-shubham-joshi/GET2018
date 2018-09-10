package scfSession3;

/**
 * 
 * @author shubhamjoshi
 *
 */
public class Marksheet {

	/*
	 * Calculate the average of all grades.
	 * 
	 * @params arr Contains the grades of all students
	 * 
	 * @params n No of students
	 * 
	 * @return float returns average
	 */
	public float avgGrades(int[] arr, int n) {
		float avg = 0;

		for (int i = 0; i < n; i++) {
			avg = avg + arr[i];
		}
		avg = avg / n;
		return avg;

	}

	/*
	 * Find the maximum of all grades.
	 * 
	 * @params arr Contains the grades of all students
	 * 
	 * @params n No of students
	 * 
	 * @return float returns maximum grade
	 */
	public float maxGrade(int[] arr, int n) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	/*
	 * Find the minimum of all grades.
	 * 
	 * @params arr Contains the grades of all students
	 * 
	 * @params n No of students
	 * 
	 * @return float returns minimum grade
	 */
	public float minGrade(int[] arr, int n) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		return min;
	}

	/*
	 * Calculate percent student passed
	 * 
	 * @params arr Contains the grades of all students
	 * 
	 * @params n No of students
	 * 
	 * @return float returns percent student passed
	 */
	public float percentOfStudentPassed(int[] arr, int n) {
		int count = 0;
		float percentpassed;
		for (int i = 0; i < n; i++) {
			if (arr[i] >= 40)
				count++;

		}

		percentpassed = (count * 100) / n;
		return percentpassed;

	}

}
