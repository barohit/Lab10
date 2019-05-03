
import java.util.Scanner;

public class CircleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a radius"); 
		double radius = 0.0; 
		String input = ""; 
		input = scan.next(); 
		radius = Validator.validateRadius(input, scan); 
		Circle c = new Circle(23);  
		System.out.println("Area: " + c.getFormattedArea(c.getArea()));
		System.out.print("Circumference: " + c.getFormattedCircumference(c.getCircumference())); 
		 
		
		

	}
	
}
