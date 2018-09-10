package scfSession3;

/**
 * 
 * @author shubhamjoshi
 *
 */
public class StringOperation {

	/*
	 * Compares two strings.
	 * 
	 * @param str1-first string.
	 * 
	 * @param str2-Second string.
	 * 
	 * @return comparison of two strings.
	 */
	public int compareStr(String str1, String str2) {
		try {
			int flag = 0;
			if (str1.length() == 0 || str2.length() == 0) {
				throw new NullPointerException();
			}

			if (str1.length() != str2.length())
				return 0;

			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					flag = 1;
					break;
				}

			}

			if (flag == 0)
				return 1;
			else
				return 0;
		} catch (NullPointerException e) {
			System.out.println("String cannot be null.");
			return 0;
		}

	}

	/*
	 * Reverse the string.
	 * 
	 * @param str-string
	 * 
	 * @return reverse of string.
	 */
	public String reverseStr(String str) {
		try {
			if (str.length() == 0) {
				throw new NullPointerException();
			}

			String strRev = "";

			for (int i = str.length() - 1; i >= 0; i--) {
				strRev = strRev + str.charAt(i);
			}

			return strRev;
		} catch (NullPointerException e) {
			System.out.println("String cannot be null.");
			return null;
		}

	}

	/*
	 * Change the case of string.
	 * 
	 * @param str-first string
	 * 
	 * @return change upper case to lower case and vice versa
	 */
	public String changeCase(String str) {
		try {
			if (str.length() == 0) {
				throw new NullPointerException();
			}

			char[] strnew = str.toCharArray();

			for (int i = 0; i < strnew.length; i++) {
				if (strnew[i] >= 'A' && strnew[i] <= 'Z') {
					strnew[i] = (char) (strnew[i] + 32);
				} else if (strnew[i] >= 'a' && strnew[i] <= 'z') {
					strnew[i] = (char) (strnew[i] - 32);
				} else {
					System.out
							.println("The given string contains letters other than alphabets so it cannot be converted to other case!..");
					return str;
				}

			}
			String ans = strnew.toString();
			return ans;
		} catch (NullPointerException e) {
			System.out.println("String cannot be null.");
			return null;
		}

	}

	/*
	 * Returns the largest word.
	 * 
	 * @param str-input string.
	 * 
	 * @return largest word of string.
	 */
	public String largestWord(String str) {
		try {
			if (str.length() == 0) {
				throw new NullPointerException();
			}

			String[] arrOfStr = str.split(" ");
			String output = arrOfStr[0];

			for (int i = 0; i < arrOfStr.length; i++) {
				if (output.length() <= arrOfStr[i].length()) {
					output = arrOfStr[i];
				}
			}
			return output;
		}

		catch (NullPointerException e) {
			System.out.println("String cannot be null.");
			return null;
		}

	}

}
