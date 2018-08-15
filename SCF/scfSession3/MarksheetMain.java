package scfSession3;

import java.util.Scanner;

/**
 * 
 * @author shubhamjoshi
 *
 */
public class MarksheetMain {

	public static void main(String args[]) {

		Marksheet ms = new Marksheet();
		int x, val;
		float avgmarks;
		float maxmarks;
		float minmarks;
		float percentpassed;

		System.out.println("Enter the number of students in the class:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] studentmarks = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the marks of " + i + " student:");
			sc.nextLine();
			try {
				val = sc.nextInt();
				if (val < 0)
					throw new Exception();
				studentmarks[i] = val;
			} catch (Exception e) {
				System.out
						.println("Marks of a student cannot be negative or anything else.Please Reenter!!..");
				i--;
			}
		}

		System.out.println("Enter the operation you want to perform:");
		System.out.println("1: AVERAGE OF ALL GRADES");
		System.out.println("2: MAXIMUM OF ALL GRADES");
		System.out.println("3: MINIMUM OF ALL GRADES");
		System.out.println("4: PERCENT OF STUDENTS PASSED");

		x = sc.nextInt();

		switch (x) {
		case 1:
			avgmarks = ms.avgGrades(studentmarks, n);
			System.out.println("Average of all grades is:" + avgmarks);
			break;

		case 2:
			maxmarks = ms.maxGrade(studentmarks, n);
			System.out.println("Maximum of all grades is:" + maxmarks);
			break;

		case 3:
			minmarks = ms.minGrade(studentmarks, n);
			System.out.println("Minimum of all grades is:" + minmarks);
			break;

		case 4:
			percentpassed = ms.percentOfStudentPassed(studentmarks, n);
			System.out.println("Percentage of all students passed is:"
					+ percentpassed);
			break;

		default:
			System.out.println("Invalid operation selected!!..");
		}

	}
}
