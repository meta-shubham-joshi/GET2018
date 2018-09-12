package part1;

/**
 * class implementing the stack through array.
 * 
 * @author shubhamjoshi
 *
 */
public class StackArrayImp implements Stack {

	private final int max_size = 100;
	private int[] stackArr = new int[max_size];
	private int top = -1;

	/*
	 * Returns whether the element is pushed to the stack or not.
	 * 
	 * @params x- element to be pushed.
	 * 
	 * @return return 1 if element is pushed else 0.
	 */
	public int push(int x) throws ArrayIndexOutOfBoundsException {

		++top;
		if (top < max_size) {
			stackArr[top] = x;
			return 1;
		} else {
			throw new ArrayIndexOutOfBoundsException("Stack overflow!!..");
		}
	}

	/*
	 * Returns whether the element is popped from the stack or not.
	 * 
	 * @return return 1 if element is popped else 0.
	 */
	public int pop() throws ArrayIndexOutOfBoundsException {
		if (top == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack Underflow.. Element cannot be popped..");

		} else {
			--top;
			return 1;
		}
	}

	/*
	 * Returns the top element of the stack.
	 * 
	 * @return return the top element of the stack.
	 */
	public int top() throws ArrayIndexOutOfBoundsException {

		if (top == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack is empty. So no top element..");
		}
		return stackArr[top];
	}

	/*
	 * Returns whether the stack is empty or not.
	 * 
	 * @return returns true if empty else return false.
	 */
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
}
