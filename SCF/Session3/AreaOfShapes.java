import java.lang.*;

public class AreaOfShapes {

	/*
	 * Calulate the area of triangle.
	 * 
	 * @params width-Contain width of triangle.
	 * 
	 * @params height-Contain height of triangle.
	 * 
	 * @return double returns area of triangle.
	 */
	public double areaOfTriangle(double width, double height) {

		double area = 0;
		try {
			if (width < 0 || height < 0) {
				throw new Exception();
			}

			area = 0.5 * width * height;
		} catch (Exception e) {
			System.out.println("Width or Height of a traingle cannot be negative!..");
		}
		return area;
	}

	/*
	 * Calulate the area of rectangle.
	 * 
	 * @params width-Contain width of rectangle.
	 * 
	 * @params height-Contain height of rectangle.
	 * 
	 * @return double returns area of rectangle.
	 */
	public double areaOfRectangle(double width, double height) {

		double area = 0;
		try {
			if (width < 0 || height < 0) {
				throw new Exception();
			}
			area = width * height;
		} catch (Exception e) {
			System.out.println("Width or Height of a rectangle cannot be negative!..");
		}
		return area;

	}

	/*
	 * Calulate the area of square.
	 * 
	 * @params width-Contain width of square
	 * 
	 * @return double returns area of square
	 */
	public double areaOfSquare(double width) {

		double area = 0;
		try {
			if (width < 0) {
				throw new Exception();
			}

			area = width * width;
		} catch (Exception e) {
			System.out.println("Width of a square cannot be negative!..");
		}
		return area;

	}

	/*
	 * Calulate the area of circle.
	 * 
	 * @params width-Contain width of circle.
	 * 
	 * @return double returns area of circle.
	 */
	public double areaOfCircle(double radius) {
		double area = 0;
		try {
			if (radius < 0) {
				throw new Exception();
			}
			area = 3.14 * radius * radius;

		} catch (Exception e) {
			System.out.println("Radius of a circle cannot be negative!..");
		}
		return area;
	}
}
