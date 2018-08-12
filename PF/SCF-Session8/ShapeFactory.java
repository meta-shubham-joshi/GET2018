package Com;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {

	public static Shape getShape(String shapeType, Point point,
			ArrayList<Integer> list,int id) {

		Shape shape = null;

		try {
			if (shapeType.equalsIgnoreCase(EnumShape.shape.SQUARE.name())) {
				int width = list.get(0);
				return new Square(point.getXCoordinate(), point.getYCoordinate(), width, id);
				
			} else if (shapeType.equalsIgnoreCase(EnumShape.shape.RECTANGLE
					.name())) {
				int length = list.get(0);
				int width = list.get(1);
				return new Rectangle(point.getXCoordinate(), point.getYCoordinate(), length, width, id);
				
			} else if (shapeType
					.equalsIgnoreCase(EnumShape.shape.CIRCLE.name())) {
				int radius = list.get(0);
				return new Circle(point.getXCoordinate(), point.getYCoordinate(), radius, id);
				
			} else if (shapeType.equalsIgnoreCase(EnumShape.shape.TRIANGLE
					.name())) {

			}
		} catch (Exception e) {
			System.out.println("Nothing");
		}

	}

}
