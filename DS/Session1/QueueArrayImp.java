package Queue;

public class QueueArrayImp {

	private int rear = 0;
	private final int max_size = 5;

	private int[] queueArr = new int[max_size];

	/*
	 * Returns whether the element is added to the queue or not.
	 * 
	 * @params x- element to be added to queue.
	 * 
	 * @return return 1 if element is pushed else throw exception.
	 */
	public int enQueue(int x) throws ArrayIndexOutOfBoundsException {

		if (rear < max_size) {
			queueArr[rear++] = x;
			System.out.println("Element added successfully to the Queue!!..");
			return 1;
		}

		throw new ArrayIndexOutOfBoundsException("Queue is full so element cannot be added!!..");

	}

	/*
	 * Returns whether the element is removed from the queue or not.
	 * 
	 * @return return 1 if element is removed else 0.
	 */
	public int deQueue() {

		if (rear != 0) {
			for (int i = 0; i < rear - 1; i++) {
				queueArr[i] = queueArr[i + 1];
			}
			rear--;
			System.out.println("Element is successfully removed from the queue!!..");
			return 1;
		}

		System.out.println("Queue is empty so element cannot be removed!!..");
		return 0;

	}

	/*
	 * Returns whether the queue is empty or not.
	 * 
	 * @return returns true if empty else return false.
	 */
	public boolean isEmpty() {

		if (rear == 0) {
			System.out.println("Queue is empty!!..");
			return true;
		}
		System.out.println("Queue is not empty!!..");
		return false;

	}

	/*
	 * Returns whether the queue is full or not.
	 * 
	 * @return returns true if full else return false.
	 */
	public boolean isFull() {

		if (rear == (max_size - 1)) {
			System.out.println("Queue is full!!..");
			return true;
		}
		System.out.println("Queue is not full!!..");
		return false;
	}

	/*
	 * Displaying the queue values.
	 */
	public void display() {

		for (int i = 0; i < rear; i++) {
			System.out.println("Element " + i + " : " + queueArr[i]);
		}
		System.out.println("**************************");
		System.out.println("                ");
	}

}
