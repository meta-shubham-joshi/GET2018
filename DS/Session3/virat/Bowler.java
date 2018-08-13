package virat;

/**
 * class for bowler.
 * 
 * @author shubhamjoshi
 *
 */
public class Bowler {

	public int bowlerNo;
	public int totalBalls;

	/**
	 * Constructor to initialise the bowler fields.
	 * 
	 * @param bowlerNo
	 *            - bowler number.
	 * @param totalBalls
	 *            - total number of balls.
	 */
	public Bowler(int bowlerNo, int totalBalls) {
		this.bowlerNo = bowlerNo;
		this.totalBalls = totalBalls;
	}

	/**
	 * getting bowler no.
	 * 
	 * @return bowler number.
	 */
	public int getbowlerNo() {
		return this.bowlerNo;
	}

	/**
	 * getting total number of balls.
	 * 
	 * @return total number of balls.
	 */
	public int getTotalBalls() {
		return this.totalBalls;
	}

}
