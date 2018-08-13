package Queue;

import Stack.LinkedList;

public class QueueLinkedListImp {

	LinkedList rear = null;
	LinkedList front = null;

	/*
	 * Returns whether the element is added to the queue or not.
	 * 
	 * @params x- element to be added to queue.
	 * 
	 * @return return 1 if element is pushed.
	 */
	public int enQueue(int x) {

		LinkedList node = new LinkedList();
		node.data = x;
		node.next = null;

		if (rear == null && front == null) {

			front = node;
			rear = node;
			System.out.println("Element is successfully added to the queue");
			return 1;
		}

		rear.next = node;
		System.out.println("Element is successfully added to the queue");
		return 1;
	}

	/*
	 * Returns whether the element is removed from the queue or not.
	 * 
	 * @return return 1 if element is removed else 0.
	 */
	public int deQueue() {

		LinkedList node;

		if (front != null) {
			node = front;
			front = front.next;
			node.next = null;
			System.out
					.println("Element is successfully removed from the queue");
			return 1;
		}

		System.out
				.println("Since no element in the queue....Element cannot be removed from the queue");
		return 0;
	}

	/*
	 * Returns whether the queue is empty or not.
	 * 
	 * @return returns true if empty else return false.
	 */
	public boolean isEmpty() {
		if (front == null) {
			System.out.println("Queue is empty!!..");
			return true;
		}
		System.out.println("Queue is not empty!!..");
		return false;
	}
	
	/*
	 * Displaying the queue values.
	 */
	public void display() {

		LinkedList traverse = front;
		while(traverse!=null) {
			System.out.println("Element " + " : " +  traverse.data);
			traverse = traverse.next;
		}
		System.out.println("**************************");
		System.out.println("                ");
	}


}
