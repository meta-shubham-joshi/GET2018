package scfSession5;

public class MathematicalOperations {

	/*
	 * returns the least highest commmon factor of the two numbers.
	 * 
	 * @param num1- First number.
	 * 
	 * @param num2- Second number.
	 * 
	 * @return return the hcf of the two numbers.
	 */
	public int highestCommonFactor(int num1, int num2) {

		// num1 and num2 are divisible by 0
		if (num1 == 0 || num2 == 0)
			return 0;

		// base case
		if (num1 == num2)
			return num1;

		// num1 is greater
		if (num1 > num2)
			return highestCommonFactor(num1 - num2, num2);

		return highestCommonFactor(num1, num2 - num1);
	}

	/*
	 * returns the least commmon multiple of the two numbers.
	 * 
	 * @param num1- First number.
	 * 
	 * @param num2- Second number.
	 * 
	 * @return return the lcm of the two numbers.
	 */

	public int leastCommonMultiple(int num1, int num2) {

		return (num1 * num2) / highestCommonFactor(num1, num2);
	}

}
