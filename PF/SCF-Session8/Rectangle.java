package Com;

import java.util.ArrayList;

public class Rectangle implements Shape{

	private String type = "Rectangle";
	private int x_Coordinate;
	private int y_Coordinate;
	private int length;
	private int breadth;
	private int id;
	
	public Rectangle(int x_Coordinate,int y_Coordinate, int length,int breadth,int id){
		this.x_Coordinate = x_Coordinate;
		this.y_Coordinate = y_Coordinate;
		this.length = length;
		this.breadth = breadth;
		this.id = id;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getLength(){
		return this.length;
	}
	

	public int getBreadth(){
		return this.breadth;
	}
	
	public double getArea(){
		return ((this.length) * (this.breadth));
	}
	
	public double getPerimeter(){
		return (2*((this.length)+(this.breadth)));
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
