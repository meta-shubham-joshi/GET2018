package part1;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * class for converting infix expression to the postfix expression.
 * 
 * @author shubhamjoshi
 *
 */
public class InfixToPostfix {

	/**
	 * To get the precedence of the operator.
	 * 
	 * @param operator
	 *            operator as string.
	 * @return the precedence of the operator.
	 */
	public int getPrecedence(String operator) {

		if (operator.equals("+") || operator.equals("-")) {
			return 5;
		} else if (operator.equals("*") || operator.equals("/")) {
			return 6;
		} else if (operator.equals("==") || operator.equals("!=")) {
			return 3;
		} else if (operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">=")) {
			return 4;
		} else if (operator.equals("&&")) {
			return 2;
		} else if (operator.equals("||")) {
			return 1;
		} else if (operator.equals("!")) {
			return 7;
		} else if (operator.equals("(") || operator.equals(")")) {
			return 8;
		} else {
			return -1;
		}

	}

	/**
	 * converts infix expression to postfix expression.
	 * 
	 * @param expression
	 *            - infix expression
	 * @return - Postfix expression
	 * @throws EmptyStackException
	 * @throws NumberFormatException
	 */
	public String infixToPostfix(String expression) throws EmptyStackException, NumberFormatException {

		StringTokenizer st = new StringTokenizer(expression);
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder("");

		for (int i = 0; st.hasMoreTokens(); i++) {
			String token = st.nextToken();
			if (this.getPrecedence(token) > 0) {
				if (stack.isEmpty()) {
					stack.push(token);
				} else if (token.equals(")")) {
					String op = stack.pop();
					while (!op.equals("(")) {
						sb.append(op + " ");
						op = stack.pop();
					}
				} else {
					while (!stack.peek().equals("(")
							&& (this.getPrecedence(stack.peek()) > this.getPrecedence(token))) {
						sb.append(stack.pop() + " ");
					}
					stack.push(token);
				}
			} else {
				Integer.parseInt(token);
				sb.append(token + " ");
			}
		}
		if (!stack.empty()) {
			while (!stack.empty()) {
				sb.append(stack.pop() + " ");
			}
		}
		return sb.toString();
	}

}
