package part1;

import java.util.EmptyStackException;
import java.util.StringTokenizer;
import java.util.Stack;

/**
 * class to evaluate the postfix expression.
 * 
 * @author shubhamjoshi
 *
 */
public class EvaluatePostfix extends StackArrayImp {

	public int operation(int op1, int op2, String token) throws ArithmeticException {

		char ch = token.charAt(0);
		switch (ch) {

		case '+':
			return (op1 + op2);

		case '-':
			return (op1 - op2);

		case '*':
			return (op1 * op2);

		case '/':
			return (op1 / op2);

		default:
			System.out.println("Invalid operation given");
		}
		return 0;

	}

	/**
	 * To get the value for the expression.
	 * 
	 * @param expression-
	 *            input string.
	 * @return
	 * @throws EmptyStackException
	 * @throws NumberFormatException
	 */
	public int getExpressionValue(String expression) throws EmptyStackException, NumberFormatException {

		StringTokenizer st = new StringTokenizer(expression);
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; st.hasMoreTokens(); i++) {
			String token = st.nextToken();

			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int op1;
				int op2;
				op2 = stack.pop();

				op1 = stack.pop();

				stack.push(this.operation(op1, op2, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}
