package virat;

import java.util.Comparator;

/**
 * class implementing comaprator.
 * @author shubhamjoshi
 *
 */
public class BowlerComparator implements Comparator<Bowler>{
	
	/**
	 * to compare bowlers total number of balls.
	 */
	public int compare(Bowler s1, Bowler s2) {
        if (s1.totalBalls < s2.totalBalls)
            return 1;
        else if (s1.totalBalls > s2.totalBalls)
            return -1;
                        return 0;
	}
}


