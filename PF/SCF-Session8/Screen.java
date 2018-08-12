package Com;

import java.util.ArrayList;

public class Screen {
	
	ArrayList<Shape> list = new ArrayList<Shape>();
	
	/*
	 * Adding a shape to a screen.
	 */
	public int addShapeToScreen(Shape shape){
		if(shape!=null){
			list.add(shape);
			System.out.println("Shape is successfully added to screen");
			return 1;
		}
		System.out.println("Since shape object is null..Shape cannot be add to screen!!!!!.......");
		return 0;
	}
	
	/*
	 * Deleting a shape from a screen of a particular type.
	 */
	public int deleteShapeFromScreen(Shape shape,int id){
		
		if(shape!=null){
			for(Shape obj: list){
				if((obj.getId())==id){
					list.remove(obj);
					System.out.println("Shape is successfully removed from the screen");
					return 1;
				}
		}
			}
		System.out.println("Since shape object is null..Shape cannot be removed from the screen!!!!!.......");
		return 0;
	
	}
	
	/*
	 * Deleting all the shapes of a particular type on the screen.
	 */
	public int deleteShapeTypeFromScreen(Shape shape,String type){
		
		if(shape!=null){
			for(Shape obj: list){
				if((type.equals(obj.getType()))){
					list.remove(obj);
					System.out.println("Shape" + obj.getId() + " is successfully removed from the screen");
					return 1;
				}
		}
			}
		System.out.println("Since shape object is null..Shape cannot be removed from the screen!!!!!.......");
		return 0;
	
	}
	
	public void sortAscendingOrderByPerimeter(Shape shape){
		
		int size = list.size();
		int[] arrId = new int[size];
		
		for(int i=0;i<list.size()-1;i++){
			
			int min_index = i;
			
			for(int j=i+1;j<list.size();j++){
				
				if(list.get(j).getArea()<list.get(min_index).getArea()){
					min_index = j;
				}
			}
			
			
		}
		
		
		
	}
	
	public 
	
	

}
