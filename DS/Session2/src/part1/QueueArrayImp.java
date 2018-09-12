package part1;

/**
 * class for Queue Implementation using array.
 * 
 * @author shubhamjoshi
 *
 */
public class QueueArrayImp {

	private int rear = -1;
	private int front = -1;
	private final int max_size = 3;

	private int[] queueArr = new int[max_size];

	/*
	 * Returns whether the element is added to the queue or not.
	 * 
	 * @params x- element to be added to queue.
	 * 
	 * @return return 1 if element is pushed else throw exception.
	 */
	public int enQueue(int x) throws ArrayIndexOutOfBoundsException {

		if (front == -1) {
			front = 0;
			rear = 0;
			queueArr[rear] = x;
			return 1;
		} else if (rear == max_size - 1 && front != 0) {
			rear = 0;
			queueArr[rear] = x;
			return 1;
		} else if ((front == 0 && rear == (max_size - 1)) || (rear == (front - 1) % (max_size - 1))) {
			return 0;
		} else {
			rear++;
			queueArr[rear] = x;
			return 1;
		}

	}

	/*
	 * Returns whether the element is removed from the queue or not.
	 * 
	 * @return return 1 if element is removed else 0.
	 */
	public int deQueue() {

		if (front == -1 || front == max_size) {
			return 0;
		} else {
			front++;
			return 1;
		}

	}

	/*
	 * Returns whether the queue is empty or not.
	 * 
	 * @return returns true if empty else return false.
	 */
	public boolean isEmpty() {

		if (front == -1 || front == max_size) {
			return true;
		}
		return false;

	}

	/*
	 * Returns whether the queue is full or not.
	 * 
	 * @return returns true if full else return false.
	 */
	public boolean isFull() {

		if (((rear != -1 && (front != -1))) && (rear == front)) {
			return true;
		}
		return false;
	}

}
