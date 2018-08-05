
import java.util.*;

public class Main {

	public static void main(String args[]) {
		StringOperation strop = new StringOperation();
		System.out.println("1: COMPARE STRINGS");
		System.out.println("2: REVERSE STRING");
		System.out.println("3: CHANGE CASE OF THE STRING");
		System.out.println("4: LARGEST WORD IN THE STRING");

		Scanner sc = new Scanner(System.in);
		int x;

		System.out.println("Enter the operation you want to perform:");
		x = sc.nextInt();
		String str1;
		String str2;

		switch (x) {
		case 1:
			System.out.println("Enter String1: ");
			str1 = sc.next();
			System.out.println("Enter String2: ");
			str2 = sc.next();
			int val = strop.compareStr(str1, str2);
			if (val == 1)
				System.out.println("String1 and String2 are equal.");
			else
				System.out.println("String1 and String2 are not equal.");
			break;

		case 2:
			System.out.println("Enter String1: ");
			str1 = sc.next();
			str2 = strop.reverseStr(str1);
			System.out.println("Reversed String is:");
			System.out.println(str2);
			break;

		case 3:
			System.out.println("Enter String1: ");
			str1 = sc.next();
			str2 = strop.changeCase(str1);
			System.out.println("Reversed String is:");
			System.out.println(str2);
			break;

		case 4:
			System.out.println("Enter String1: ");
			sc.nextLine();
			str1 = sc.nextLine();
			str2 = strop.largestWord(str1);
			System.out.println("Largest word in string is:");
			System.out.println(str2);
			break;

		default:
			System.out.println("Wrong operation is choosen....");
		}

	}
}
