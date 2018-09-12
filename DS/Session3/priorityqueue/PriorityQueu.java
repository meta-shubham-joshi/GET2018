package priorityqueue;

/**
 * priority queue class.
 * 
 * @author shubhamjoshi
 *
 */
class PriorityQueu {
	private Data[] heap;
	private int heapSize, capacity;

	/** Constructor **/
	public PriorityQueu(int capacity) {
		this.capacity = capacity + 1;
		heap = new Data[this.capacity];
		heapSize = 0;
	}

	/** function to clear **/
	public void clear() {
		heap = new Data[capacity];
		heapSize = 0;
	}

	/** function to check if empty **/
	public boolean isEmpty() {
		return heapSize == 0;
	}

	/** function to check if full **/
	public boolean isFull() {
		return heapSize == capacity - 1;
	}

	/** function to get Size **/
	public int size() {
		return heapSize;
	}

	/**
	 * function to insert task.
	 * 
	 * @param job
	 *            - job in the form of string.
	 * @param priority
	 *            - priority number.
	 */
	public void insert(String job, int priority) {
		Data newJob = new Data(job, priority);

		heap[++heapSize] = newJob;
		int pos = heapSize;
		while (pos != 1 && newJob.priority > heap[pos / 2].priority) {
			heap[pos] = heap[pos / 2];
			pos /= 2;
		}
		heap[pos] = newJob;
	}

	/** function to remove task **/
	public Data remove() {
		int parent, child;
		Data item, temp;
		if (isEmpty()) {
			System.out.println("Heap is empty");
			return null;
		}

		item = heap[1];
		temp = heap[heapSize--];

		parent = 1;
		child = 2;
		while (child <= heapSize) {
			if (child < heapSize && heap[child].priority < heap[child + 1].priority)
				child++;
			if (temp.priority >= heap[child].priority)
				break;

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = temp;

		return item;
	}
}
