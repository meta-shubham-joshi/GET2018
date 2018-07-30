package Com;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class ZooTest {

	
	@Test
	public void test() {
		
		
		Zoo obj = new Zoo();
		
		obj.maxZoneCapacity(10);
		
		Animal lion = new Lion("Mammal", "abcxyz", 15, 250, "roar", "white");
		
		assertEquals(1, obj.addZoneToZoo("Mammal", 5, 1, true,true));
		
		assertEquals(1,obj.addCageToZone(1,"Bear",5));
		assertEquals(1,obj.addCageToZone(1,"Tiger",5));
		
		assertEquals(1,obj.addAnimalToCage(lion, 1));
		
		assertEquals(1,obj.removeAnimal(1, "Mammal", "abcxyz"));
		 
	}

}
