package priorityqueue;

import java.util.Scanner;

/**
 * class for defining the element of the queue.
 * 
 * @author shubhamjoshi
 *
 */
class Data {
	String job;
	int priority;

	/** Constructor **/
	public Data(String job, int priority) {
		this.job = job;
		this.priority = priority;
	}

	/** toString() **/
	public String toString() {
		return "Job Name : " + job + "\nPriority : " + priority;
	}
}