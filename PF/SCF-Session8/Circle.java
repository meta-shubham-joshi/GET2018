package Com;

import java.util.ArrayList;

public class Circle implements Shape{

	private String type = "Circle";
	private int x_Coordinate;
	private int y_Coordinate;
	private int radius;
	private int id;
	
	public Circle(int x_Coordinate,int y_Coordinate,int radius,int id){
		this.x_Coordinate = x_Coordinate;
		this.y_Coordinate = y_Coordinate;
		this.radius = radius;
		this.id = id;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getRadius(){
		return this.radius;
	}
	
	public double getArea(){
		return (3.14* (this.radius) * (this.radius));
	}
	
	public double getPerimeter(){
		return (2*3.14*(this.radius));
	}
	
	public ArrayList<Integer> getOrigin(){
		
		ArrayList<Integer> originCoordinates = new ArrayList<Integer>();
		
		originCoordinates.add(x_Coordinate);
		originCoordinates.add(y_Coordinate);
		return originCoordinates;
		
	}
	
	public int isPointEnclosed(){
		
	}
	
	public int getDate(){
		
	}

}
