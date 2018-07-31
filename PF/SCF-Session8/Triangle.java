package Com;

import java.util.ArrayList;

public class Triangle {

	private String type = "Triangle";
	private int x_Coordinate;
	private int y_Coordinate;
	private int base;
	private int height;
	private int id;
	
	public Triangle(int x_Coordinate,int y_Coordinate, int base,int height,int id){
		this.x_Coordinate = x_Coordinate;
		this.y_Coordinate = y_Coordinate;
		this.base = base;
		this.height = height;
		this.id = id;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getId(){
		return this.id;
	}

	public int getBase(){
		return this.base;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	
	public double getArea(){
		return (0.5*(this.base)*(this.height));
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
