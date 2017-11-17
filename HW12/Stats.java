// Rubin Peci
// APCS Pd. 1
// HW12 stAstically sPeaking
//2017-10-05

public class Stats {
	
	public static int mean(int a, int b) {
		return  (int)((a + b)/ 2);	
	}

	public static double mean(double a, double b) {
		return (double)((a+b) / 2);
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}else {
			return b;
		}
	}

	public static double max(double a, double b) { 
		if (a > b) {
			return a;
		}else {
			return b;
		}
	}

	public static int geoMean(int a, int b) {
		return (int)Math.sqrt(a * b);
	}

	public static double geoMean(double a, double b) {
		return Math.sqrt(a * b);
	}	
	
	public static void main(String args[]) {
		//Testing the int mean method
		System.out.println("int mean(1, 4)\n" + mean(1, 4)); // Returns 2
		
		//Testing the double mean method
		System.out.println("\ndouble mean(1.0, 4.0)\n" + mean(1.0, 4.0)); // Returns 2.5

		//Testing the int max method
		System.out.println("\nint max(1, 4)\n" + max(1, 4)); // Returns 4
		System.out.println("\nint max(1, 1)\n" + max(1, 1)); // Returns 1

		//Testing the double max method
		System.out.println("\ndouble max(1.4, 4.6)\n" + max(1.4, 4.6)); // Returns 4.6
		System.out.println("\ndouble max(23.3, 23.3)\n" + max(23.3, 23.3)); // Returns 23.3

		//Testing the int geoMean method
		System.out.println("\nint geoMean(6, 3)\n" + geoMean(6, 3)); // Returns 4
		System.out.println("\nint geoMean(8, 2)\n" + geoMean(8, 2)); // Also Returns 4
		
		//Testing the double geoMean method
		System.out.println("\ndouble geoMean(7.8, 9.1)\n" + geoMean(7.8, 9.1)); //
		System.out.println("\ndouble geoMean(10.1, 10.1)\n" + geoMean(10.1, 10.1)); // Returns 10.1
	}
}
