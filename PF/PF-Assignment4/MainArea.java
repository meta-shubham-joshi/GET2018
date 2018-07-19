import java.util.Scanner;


public class MainArea {
	
	public static void main(String args[])
	{
		AreaOfShapes ma = new AreaOfShapes();
		
		double width;
		double height;
		double radius;
		double ans;
		
		System.out.println("Enter the operation you want to perform:");
		System.out.println("1: AREA OF TRIANGLE");
		System.out.println("2: AREA OF RECTANGLE");
		System.out.println("3: AREA OF SQUARE");
		System.out.println("4: AREA OF CIRCLE");
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		switch(x)
		{
		case 1: System.out.println("Enter width: ");
				width=sc.nextInt();
				System.out.println("Enter height: ");
				height=sc.nextInt();
				ans = ma.areaOfTriangle(width,height);
				System.out.println("Area of Triangle is:");
				System.out.printf("%.2f",ans);
				break;
		
		case 2: System.out.println("Enter width: ");
				width=sc.nextInt();
				System.out.println("Enter height: ");
				height=sc.nextInt();
				ans = ma.areaOfRectangle(width,height);
				System.out.println("Area of Rectangle is:");
				System.out.printf("%.2f",ans);
				break;
        
		case 3: System.out.println("Enter width: ");
				width=sc.nextInt();
				ans = ma.areaOfSquare(width);
				System.out.println("Area of square is:");
				System.out.printf("%.2f",ans);
				break;
		
		case 4: System.out.println("Enter Radius: ");
				radius=sc.nextInt();
				ans = ma.areaOfCircle(radius);
				System.out.println("Area of circle is:");
				System.out.printf("%.2f",ans);
				break;

		}
}
}
