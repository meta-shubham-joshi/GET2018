package Stack;

public class StackLinkedListImp {

	LinkedList top = null;

	/*
	 * Returns whether the element is pushed to the stack or not.
	 * 
	 * @params x- element to be pushed.
	 * 
	 * @return return 1 if element is pushed.
	 */
	public int push(int x) {

		LinkedList node = new LinkedList();
		node.data = x;

		if (top == null) {

			node.next = null;
		}

		node.next = top;
		top = node;

		System.out.println("Element added successfully!!!!....");

		return 1;
	}

	/*
	 * Returns whether the element is popped from the stack or not.
	 * 
	 * @return return 1 if element is popped else 0.
	 */
	public int pop() {

		if (top == null) {
			System.out
					.println("Stack underflow.. So element canot be removed!!..");
			return 0;
		}
		LinkedList temp = top;

		top = top.next;
		temp.next = null;

		System.out.println(" Element removed successfully!!..");
		return 1;

	}

	/*
	 * Returns whether the stack is empty or not.
	 * 
	 * @return returns true if empty else return false.
	 */
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}
		return false;
	}

	/*
	 * Returns the top element of the stack else return 0;
	 * 
	 * @return return the top element of the stack.
	 */
	public int top() {

		if (top == null) {
			System.out.println("Since stack is empty.. No top element!!..");
			return 0;

		}
		return top.data;
	}

	/*
	 * Displaying the stack values.
	 */
	public void display() {

		LinkedList traverse = top;
		while (traverse != null) {
			System.out.println("Element " + " : " + traverse.data);
			traverse = traverse.next;
		}
		System.out.println("**************************");
		System.out.println("                ");
	}

}
