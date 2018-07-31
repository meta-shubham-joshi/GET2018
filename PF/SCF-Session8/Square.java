package Com;

import java.util.ArrayList;

public class Square implements Shape{
	
	private String type = "Square";
	private int x_Coordinate;
	private int y_Coordinate;
	private int width;
	private int id;
	
	public Square(int x_Coordinate,int y_Coordinate, int width,int id){
		this.x_Coordinate = x_Coordinate;
		this.y_Coordinate = y_Coordinate;
		this.width = width;
		this.id = id;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getId(){
		return this.id;
	}

	public int getWidth(){
		return this.width;
	}
	
	public double getArea(){
		return ((this.width) * (this.width));
	}
	
	public double getPerimeter(){
		return (4*(this.width));
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
