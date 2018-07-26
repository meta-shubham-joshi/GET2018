import static org.junit.Assert.*;

import org.junit.Test;


public class SparseMatrixTest {

	@Test
	public void test() {
		
		int arr[][] =
		    {
		        {0 , 0 , 3 , 0 , 4 },
		        {0 , 0 , 5 , 7 , 0 },
		        {0 , 0 , 0 , 0 , 0 },
		        {0 , 2 , 6 , 0 , 0 }
		    };
		
		SparseMatrix sm = new SparseMatrix(arr);
		
	}

}
