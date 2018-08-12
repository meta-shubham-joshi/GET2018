import java.util.*;
import java.util.List;

public class JobScheduler {

	private int waiting_Time;
	private int completion_Time;
	private int turn_Around_Time;
	private int last_Completed_Time;
	private int arrival_Time;
	private int burst_Time;

	/*
	 * Constructor to initialising the arrival time and burst time.
	 * 
	 * @params arrival_time - Arrival Time.
	 * 
	 * @params burst_time - Burst Time.
	 */
	public JobScheduler(int arrival_Time, int burst_Time) {

		this.arrival_Time = arrival_Time;
		this.burst_Time = burst_Time;
	}

	/*
	 * Calculating completion time for the process.
	 * 
	 * @params jobs- contains all the Jobs.
	 * 
	 * @return return the completion time.
	 */
	public int completionTime(JobScheduler jobs) {

		jobs.completion_Time = jobs.arrival_Time + jobs.waiting_Time + jobs.burst_Time;
		return jobs.completion_Time;
	}

	/*
	 * Calculating waiting time for the process
	 * 
	 * @params jobs- contains all the Jobs.
	 * 
	 * @params previousJob- contains the reference to previous job.
	 * 
	 * @return return the waiting time.
	 */
	public int waitTime(JobScheduler jobs, JobScheduler previousJob) {

		if (jobs.arrival_Time < previousJob.last_Completed_Time) {

			jobs.waiting_Time = previousJob.last_Completed_Time - jobs.arrival_Time;
			jobs.last_Completed_Time = previousJob.last_Completed_Time + jobs.burst_Time;
		} else {

			jobs.waiting_Time = 0;
			jobs.last_Completed_Time = previousJob.last_Completed_Time
					+ (jobs.arrival_Time - previousJob.last_Completed_Time) + jobs.burst_Time;
		}
		return jobs.waiting_Time;
	}

	/*
	 * Calculating turn around time for the process
	 * 
	 * @params jobs- contains all the Jobs.
	 * 
	 * @return return the turn around time.
	 */
	public int turnAroundTime(JobScheduler jobs) {

		jobs.turn_Around_Time = jobs.completion_Time - jobs.arrival_Time;
		return jobs.turn_Around_Time;
	}

	/*
	 * Calculating average waiting time.
	 * 
	 * @params job- contains list of all the Jobs.
	 * 
	 * @params pro- total number of processes.
	 * 
	 * @return return the average waiting time.
	 */
	public static float avgWaitingTime(List<JobScheduler> job, int pro) {

		float total = 0;

		for (JobScheduler jobs : job) {
			total += jobs.waiting_Time;
		}
		return (total / pro);
	}

	/*
	 * Calculating maxwaitingtime for the process
	 * 
	 * @params job- contains list of all the Jobs.
	 * 
	 * @return return the maximum waiting time.
	 */
	public static int maxWaitTimePeriod(List<JobScheduler> job) {

		int max = Integer.MIN_VALUE;
		for (JobScheduler jobs : job) {

			if (jobs.waiting_Time > max) {
				max = jobs.waiting_Time;
			}
		}
		return max;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of process:");
		int pro = sc.nextInt();

		int[][] arr = new int[pro][2];
		ArrayList<JobScheduler> obj = new ArrayList<>();

		for (int i = 0; i < pro; i++) {

			System.out.println("Enter the values of arrival time for the process");
			arr[i][0] = sc.nextInt();
			System.out.println("Enter the values of burst time for the process");
			arr[i][1] = sc.nextInt();
		}

		for (int j = 0; j < pro; j++) {

			obj.add(j, new JobScheduler(arr[j][0], arr[j][1]));
		}

		JobScheduler previousJob = obj.get(0);
		previousJob.last_Completed_Time = previousJob.arrival_Time;

		for (JobScheduler jobs : obj) {

			jobs.waiting_Time = jobs.waitTime(jobs, previousJob);
			jobs.completion_Time = jobs.completionTime(jobs);
			jobs.turn_Around_Time = jobs.turnAroundTime(jobs);
			previousJob = jobs;
		}

		for (JobScheduler jobs : obj) {

			System.out.println("Waiting Time:");
			System.out.println(jobs.waiting_Time);
			System.out.println("Completion Time:");
			System.out.println(jobs.completion_Time);
			System.out.println("Turn Around Time:");
			System.out.println(jobs.turn_Around_Time);
		}

		float avg_time = avgWaitingTime(obj, pro);
		System.out.println("Average waiting time: ");
		System.out.println(avg_time);

		int max_Wait_Time_Period = maxWaitTimePeriod(obj);
		System.out.println("Maximum waiting time period is:");
		System.out.println(max_Wait_Time_Period);
	}
}
