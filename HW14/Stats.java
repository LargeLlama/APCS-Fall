// Rubin Peci
// APCS Pd. 1
// HW13 May ah Hahv S'maur, Please? 
//2017-10-05

public class Stats {
	
	public static int mean(int a, int b) {
		return  (int)((a + b)/ 2.0);	
	}

	public static double mean(double a, double b) {
		return ((a+b) / 2.0);
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	public static double max(double a, double b) { 
		if (a > b) {
			return a;
		}
		return b;
	}

	public static int geoMean(int a, int b) {
		return (int)Math.sqrt(a * b);
	}
	// Type casting is required because Math.sqrt() will return a double if the product is not a perfect square
	public static double geoMean(double a, double b) {
		return Math.sqrt(a * b);
	}	

	//=============== 3 PARAMETER METHODS ========================//

	public static int max(int a, int b, int c) {
		 return max(max(a, b), max(b, c));	
	}

	public static double max(double a, double b, double c) {
		return max(max(a, b), max(b, c));	
	}
	// I just use the previous max function I built to simplify the code into one line, where it returns the max of max(a,b) and max(b,c)

	public static int geoMean(int a, int b, int c) {
		return (int) Math.pow((a * b * c), 1.0/3.0);
	}
	// Typecasting is necessary here because the cube root of a number that isn't a perfect cube will be a double

	public static double geoMean(double a, double  b, double c) {
		return Math.pow((a * b * c), 1.0/3.0);
	}
}
