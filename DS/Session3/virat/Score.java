package virat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * class providing the functionality of the order of bowlers.
 * 
 * @author shubhamjoshi
 *
 */
public class Score {

	private int totalBowlers;
	private int totalNoOfBalls;
	private int quotaOfBowlers;
	PriorityQueue<Bowler> maxPQ;

	/**
	 * constructor initialising the values.
	 * 
	 * @param totalBowlers
	 *            - total bowlers in the game.
	 * @param totalNoOfBalls
	 *            - total number of balls given to virat.
	 * @param quotaOfBowlers
	 *            - balls given to each bowler.
	 */
	public Score(int totalBowlers, int totalNoOfBalls, ArrayList<Integer> quotaOfBowlers) {

		this.totalBowlers = totalBowlers;
		this.totalNoOfBalls = totalNoOfBalls;

		this.maxPQ = new PriorityQueue<Bowler>(totalBowlers, new BowlerComparator());

		for (int i = 0; i < quotaOfBowlers.size(); i++) {
			this.maxPQ.add(new Bowler(i, quotaOfBowlers.get(i)));
		}
	}

	/**
	 * function to get order of bowlers.
	 * 
	 * @return the list of order of bowlers.
	 */
	public ArrayList<Integer> getOrderOfBowlers() {
		ArrayList<Integer> orderOfBowlers = new ArrayList<Integer>();

		while (totalNoOfBalls != 0) {

			if (maxPQ.peek() != null) {
				Bowler bowler = maxPQ.peek();
				bowler.totalBalls -= 1;

				int bowlerno = bowler.bowlerNo;
				int totalBalls = bowler.totalBalls;

				orderOfBowlers.add(bowler.bowlerNo);

				maxPQ.poll();

				maxPQ.add(new Bowler(bowlerno, totalBalls));

				totalNoOfBalls--;
			} else {
				System.out.println("No more Balls left for virat to play!!..");
			}
		}
		return orderOfBowlers;

	}

}
