import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

	public static double validateRadius (String radius, Scanner scnr) {  
		boolean validated = false; 
		double d = 0.1; 
		while (validated == false) {
			try {
				d = Double.parseDouble(radius); 
				if (d <= 0.0) {
					throw new InputMismatchException(); 
				} else {
					validated = true; 
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Error, this is not a valid radius. Please try again: "); 
				scnr.nextLine(); 
				radius = scnr.next();  
				continue; 
				
			} 
		
		}
		return d; 
	}
}
