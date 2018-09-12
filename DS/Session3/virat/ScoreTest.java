package virat;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void testScore() {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(5);
		list.add(4);
		list.add(6);
		list.add(9);
		
		Score sc = new Score(5, 4, list);

		ArrayList<Integer> orderResult = sc.getOrderOfBowlers();
		ArrayList<Integer> expectedResult = new ArrayList<Integer>();

		expectedResult.add(4);
		expectedResult.add(0);
		expectedResult.add(4);
		expectedResult.add(0);

		if (orderResult.size() == expectedResult.size()) {
			for (int i = 0; i < expectedResult.size(); i++) {
				assertEquals(expectedResult.get(i), orderResult.get(i));
			}
		} else {
			System.out.println("Invalid Output!!!!....");
		}

	}

}
