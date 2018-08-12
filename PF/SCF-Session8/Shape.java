package Com;

import java.util.ArrayList;

public interface Shape {
	
	public double getArea();
	
	public double getPerimeter();
	
	public ArrayList<Integer> getOrigin();
	
	public int isPointEnclosed();
	
	public int getId();
	
	public int getType();
	
	public int getDate();

}
