import static org.junit.Assert.*;

import org.junit.Test;


public class SearchTest {

	@Test
	public void searchtestpass() {
		
		try{
			Search obj =new Search();
			
			int arr[]={1, 2, 3, 4, 5, 6};
			
			int anslinear = obj.linearSearch(arr, 4, 0, 5);
			int ansbinary = obj.binarySearch(arr, 4, 0, 5);
			
			assertEquals(1,anslinear);
			assertEquals(1,ansbinary);
		}
		catch(Exception e){
			System.out.println("Something wrong has happened!!..");
		}
	}
	
	@Test
	public void searchtestfail(){
		
		try{
			Search obj = new Search();
			
			int arr[]={1, 2, 3, 4, 5, 6};
			
			int anslinear = obj.linearSearch(arr, 4, 0, 5);
			int ansbinary = obj.binarySearch(arr, 4, 0, 5);
			
			assertNotEquals(0, anslinear);
			assertNotEquals(0, anslinear);
		}
		catch(Exception e){
			System.out.println("Something wrong has happened!!..");
		}
	}

}
