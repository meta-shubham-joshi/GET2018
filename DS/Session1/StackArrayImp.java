package Stack;

public class StackArrayImp implements Stack {

	private final int max_size = 5;
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
			System.out
					.println("Element is successfully added to the stack!!..");
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
			throw new ArrayIndexOutOfBoundsException(
					"Stack Underflow.. Element cannot be popped..");

		} else {
			--top;
			System.out.println("Element popped successfully..");
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
			throw new ArrayIndexOutOfBoundsException(
					"Stack is empty. So no top element..");
		}
		return stackArr[top];
		/*
		 * Have to handle in try catch block in test case..
		 * catch(ArrayIndexOutOfBoundsException e){ sopln(e); }
		 */
	}

	/*
	 * Returns whether the stack is empty or not.
	 * 
	 * @return returns true if empty else return false.
	 */
	public boolean isEmpty() {
		if (top == -1) {
			System.out.println("Stack is empty");
			return true;
		}
		System.out.println("Stack is not empty");
		return false;
	}

	/*
	 * Displaying the stack values.
	 */
	public void display() {

		for (int i = 0; i <= top; i++) {
			System.out.println("Element " + i + " : " + stackArr[i]);
		}
		System.out.println("**************************");
		System.out.println("                ");
	}

}
