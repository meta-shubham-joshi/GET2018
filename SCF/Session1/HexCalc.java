
import java.util.Scanner;
import java.lang.*;

public class HexCalc implements ArithematicHex {

	/*
	 * Converts hexadecimal to decimal.
	 * 
	 * @params str- string input.
	 * 
	 * @return return the computed decimal value in hexadecimal form as string.
	 */
	public int hexadecToDecimal(String str) {
		int v = 0;
		int total = 0;
		int pow = 0;

		str = str.toUpperCase();

		for (int i = str.length() - 1; i >= 0; i--) {

			char c = str.charAt(i);
			if (c >= '0' && c <= '9')
				v = c - '0';
			else if (c >= 'A' && c <= 'F') {
				v = 10 + (c - 'A');
			}

			total += v * Math.pow(16, pow);
			pow++;
		}
		return total;
	}

	/*
	 * Converts decimal number to hexadecimal number.
	 * 
	 * @params num- input number.
	 * 
	 * @return return the computed hexadecimal value as string.
	 */
	public String decToHexaDec(int num) {

		int rem;
		String hex = "";

		char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		while (num > 0) {
			rem = num % 16;
			hex = hexChars[rem] + hex;
			num = num / 16;
		}
		return hex;
	}

	/*
	 * Adding hexadecimal numbers.
	 * 
	 * @params n1- input string1.
	 * 
	 * @params n2- input string2.
	 * 
	 * @return Returns the computed sum as string.
	 */
	public String add(String n1, String n2) {

		int val1 = hexadecToDecimal(n1);
		int val2 = hexadecToDecimal(n2);
		int result = val1 + val2;
		String res = decToHexaDec(result);
		return res;
	}

	/*
	 * Subtracting hexadecimal numbers.
	 * 
	 * @params n1- input string1.
	 * 
	 * @params n2- input string2.
	 * 
	 * @return Returns the computed subtraction as string.
	 */
	public String sub(String n1, String n2) {

		int val1 = hexadecToDecimal(n1);
		int val2 = hexadecToDecimal(n2);
		int result = Math.abs(val1 - val2);
		String res = decToHexaDec(result);
		return res;
	}

	/*
	 * Multiplying hexadecimal numbers.
	 * 
	 * @params n1- input string1.
	 * 
	 * @params n2- input string2.
	 * 
	 * @return Returns the computed multiplication as string.
	 */
	public String mul(String n1, String n2) {

		int val1 = hexadecToDecimal(n1);
		int val2 = hexadecToDecimal(n2);
		int result = val1 * val2;
		String res = decToHexaDec(result);
		return res;
	}

	/*
	 * Dividing hexadecimal numbers.
	 * 
	 * @params n1- input string1.
	 * 
	 * @params n2- input string2.
	 */
	public void div(String n1, String n2) {

		int val1 = hexadecToDecimal(n1);
		int val2 = hexadecToDecimal(n2);

		try {
			int result = val1 / val2;
			String res = decToHexaDec(result);
			System.out.println("Division of the numbers is:");
			System.out.println(res);

		} catch (ArithmeticException e) {
			System.out.println("Can't be divided by Zero" + e);
		}
	}

	/*
	 * Compares hexadecimal numbers.
	 * 
	 * @params n1- input string1.
	 * 
	 * @params n2- input string2.
	 */
	public void comp(String n1, String n2) {

		int result = n1.compareTo(n2);
		if (result < 0) {
			System.out.println("n1 is lesser than n2");
		} else if (result > 0) {
			System.out.println("n1 is greater than n2");
		} else {
			System.out.println("n1 is equal to n2");
		}
	}

	public static void main(String args[]) {

		HexCalc obj = new HexCalc();

		Scanner sc = new Scanner(System.in);

		System.out.println("1: ADD");
		System.out.println("2: SUB");
		System.out.println("3: MUL");
		System.out.println("4: DIV");
		System.out.println("5: COMPARE");

		System.out.println("Enter the operation you want to perform:");
		int x = sc.nextInt();
		String n1, n2;
		String ans;

		switch (x) {
		case 1:
			System.out.println("Enter the first number:");
			n1 = sc.next();
			System.out.println("Enter the second number:");
			n2 = sc.next();
			ans = obj.add(n1, n2);
			System.out.println("Addition of the numbers is:");
			System.out.println(ans);
			break;

		case 2:
			System.out.println("Enter the first number:");
			n1 = sc.next();
			System.out.println("Enter the second number:");
			n2 = sc.next();
			ans = obj.sub(n1, n2);
			System.out.println("Subtraction of the numbers is:");
			System.out.println(ans);
			break;

		case 3:
			System.out.println("Enter the first number:");
			n1 = sc.next();
			System.out.println("Enter the second number:");
			n2 = sc.next();
			ans = obj.mul(n1, n2);
			System.out.println("Multiplication of the numbers is:");
			System.out.println(ans);
			break;

		case 4:
			System.out.println("Enter the first number:");
			n1 = sc.next();
			System.out.println("Enter the second number:");
			n2 = sc.next();
			obj.div(n1, n2);
			break;

		case 5:
			System.out.println("Enter the first number:");
			n1 = sc.next();
			System.out.println("Enter the second number:");
			n2 = sc.next();
			obj.comp(n1, n2);
			break;

		default:
			System.out.println("Operation number choosen is wrong!!!!....");
		}
	}
}
