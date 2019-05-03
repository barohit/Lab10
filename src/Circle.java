public class Circle {
	
	double rad = 0.0; 
	final double PI_VAL = Math.PI; 
	
	public Circle(double radius) {
		rad = radius; 
	}
	
	public double getCircumference() {
		return 2 * PI_VAL * rad; 
	}
	
	public double getArea() {
		return rad * rad * PI_VAL; 
	}
	
	public static String formatNumber(double x) { // the mess is to handle the case of any form of or length of number
		String num = Double.toString(x);
		String newNum = ""; 
		int thousandthsDigit = 0;
		int hundredthsLocation = -1; 
		int hundredthsDigit =  0; 
		 
		
		
		try { 
			hundredthsLocation = num.indexOf('.') + 2;
			hundredthsDigit = Character.getNumericValue(num.charAt(hundredthsLocation)); 
			thousandthsDigit = Character.getNumericValue(num.charAt(hundredthsLocation + 1)); 
		
		} catch (StringIndexOutOfBoundsException e) {
			thousandthsDigit = 0;  
			if (hundredthsLocation == -1) {
				return num + 0; 
			}
		}
		if (thousandthsDigit >= 5 && hundredthsDigit != 9) {
			hundredthsDigit++; 
		}
		
		if (hundredthsDigit == 9 && thousandthsDigit >=5) {
			 int currentPlace = hundredthsLocation; 
			 int zeroCounter = 1; 
			 boolean decimalPoint = false; 
			 int decimalPointCounter = 0; 
			 String zeros = ""; 
			 String decimalZeros = ""; 
			 try {
				 while (Character.getNumericValue(num.charAt(currentPlace)) == 9 || num.charAt(currentPlace) == '.') {
					 if (decimalPoint == false) {
						 zeros = ""; 
					 } else {
						 zeros = "."; 
						 decimalZeros = ""; 
						 decimalPointCounter++; 
					 }
					 
					 if (num.charAt(currentPlace) == '.') {
						 currentPlace--; 
						 decimalPoint = true; 
						 continue; 
					 }
					 if (decimalPoint == false) {
						 for (int i = 0; i < zeroCounter; i++) { 
							 zeros += 0; 
						 }
					 } else {
						 for (int i = 0; i < decimalPointCounter; i++) {
							 decimalZeros += 0; 
						 }
						 for (int i = 0; i < zeroCounter; i++) { 
							 zeros += 0; 
						 }
						zeros = decimalZeros + zeros;  
	 
						 
						 
					 }
					 num = num.substring(0, currentPlace) + zeros; 
					 currentPlace--; 
					 if (decimalPoint == false) {
						 zeroCounter++; 
					 }
					 
				 }
				 newNum = num.substring(0, currentPlace) + (Character.getNumericValue(num.charAt(currentPlace)) + 1) + zeros; 
			 } catch (StringIndexOutOfBoundsException e) {
				 newNum = newNum.replace('9', '0'); 
				 newNum = 1 + zeros; 
			 }
		} else {
		newNum = num.substring(0, hundredthsLocation); 
		newNum += String.valueOf(hundredthsDigit); 
		}
		return newNum; 
		
		
		
	}
	
	public String getFormattedCircumference(double circumference) {
		return formatNumber(circumference); 
	}
	
	public String getFormattedArea(double area) {
		return formatNumber(area); 
	}

}
