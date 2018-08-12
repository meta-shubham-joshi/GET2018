package Com;

import java.util.Date;

public class Point {
	
	private int max__X_Coordinate = 1000;
	private int max_Y_Coordinate = 1000;
	
	private int min_X_Coordinate = 0;
	private int min_Y_Coordinate = 0;
	
	private int x_Coordinate;
	private int y_Coordinate;
	
	Date date;
	
	public Point(int x_Coordinate, int y_Coordinate){
		
		this.x_Coordinate = x_Coordinate;
		this.y_Coordinate = y_Coordinate;
		
		date = new Date();
	}
	
	public int getXCoordinate(){
		return this.x_Coordinate;
	}
	
	public int getYCoordinate(){
		return this.y_Coordinate;
	}
	
	public Date getDate(){
		return this.date;
	}

}
