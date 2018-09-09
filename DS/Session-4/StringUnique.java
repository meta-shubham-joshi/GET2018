package question2;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author User28
 *
 */
public class StringUnique {

	final int MAX_NO_CHARS = 256;
	Map<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * Counting unique characters in the string.
	 * 
	 * @param str
	 *            - input string.
	 * 
	 * @return the number of unique characters in the string.
	 */
	public int countUniqueChars(String str) {

		try {

			str = str.toLowerCase();

			// initialising count array with 0.s
			int[] count = new int[MAX_NO_CHARS];

			// if the no of unique characters in string is already computed
			// earlier.
			if (map.containsValue(str)) {
				return map.get(str);
			}

			int i;
			int uniqueCount = 0;

			for (i = 0; i < str.length(); i++) {
				if (count[(int) str.charAt(i)] == 0) {
					count[(int) str.charAt(i)] = 1;
					uniqueCount++;
				}
			}
			map.put(str, uniqueCount);

			return uniqueCount;
		}

		catch (NullPointerException e) {
			System.out.println("String is null!!..");
			return -1;
		}

	}
}