public class StatsDriver {
	public static void main(String args[]) {
		//Testing the int mean method
		System.out.println("int mean(1, 4)\n" + Stats.mean(1, 4)); // Returns 2
		
		//Testing the double mean method
		System.out.println("\ndouble mean(1.0, 4.0)\n" + Stats.mean(1.0, 4.0)); // Returns 2.5

		//Testing the int max method
		System.out.println("\nint max(1, 4)\n" + Stats.max(1, 4)); // Returns 4
		System.out.println("\nint max(1, 1)\n" + Stats.max(1, 1)); // Returns 1

		//Testing the double max method
		System.out.println("\ndouble max(1.4, 4.6)\n" + Stats.max(1.4, 4.6)); // Returns 4.6
		System.out.println("\ndouble max(23.3, 23.3)\n" + Stats.max(23.3, 23.3)); // Returns 23.3

		//Testing the int geoMean method
		System.out.println("\nint geoMean(6, 3)\n" + Stats.geoMean(6, 3)); // Returns 4
		System.out.println("\nint geoMean(8, 2)\n" + Stats.geoMean(8, 2)); // Also Returns 4
		
		//Testing the double geoMean method
		System.out.println("\ndouble geoMean(7.8, 9.1)\n" + Stats.geoMean(7.8, 9.1)); //
		System.out.println("\ndouble geoMean(10.1, 10.1)\n" + Stats.geoMean(10.1, 10.1)); // Returns 10.1

		//================3 Parameters==================// 
		System.out.println("\n=================3 Parameters==================\n");
		//Testing int max(a, b, c)
		System.out.println("\nint max(1, 2, 3)\n" + Stats.max(1, 2, 3)); //Returns 3
		System.out.println("\nint max(1, 2, 2)\n" + Stats.max(1, 2, 2)); //Returns 2
		System.out.println("\nint max(1, 1, 1)\n" + Stats.max(1, 1, 1)); //Returns 1

		//Testing double max(a, b, c)
		System.out.println("\ndouble max(1.0, 1.5, 7.66)\n" + Stats.max(1.0, 1.5, 7.66)); // Returns 7.66
		System.out.println("\ndouble max(1.1, 2.3, 2.3)\n" + Stats.max(1.1, 2.3, 2.3)); // Returns 2.3
		System.out.println("\ndouble max(.19, .19, .19)\n" + Stats.max(.19,.19,.19)); // Returns .19
		System.out.println("\ndouble max(.19, 1, 2)\n" + Stats.max(.19, 1, 2));
		// For the last test case, it appears to automatically convert the ints into doubles, because it won't lose precision

		//Testing int geoMean(a, b, c)
		System.out.println("\nint geoMean(2, 4, 3)\n" + Stats.geoMean(2, 4, 3)); // Returns 2	
		System.out.println("\nint geoMean(2, 2, 2)\n" + Stats.geoMean(2, 2, 2)); // Returns 2
		System.out.println("\nint geoMean(-3, 10, 3)\n" + Stats.geoMean(-3, 10, 3)); // Returns 0 (why?) 
		// Doing some research shows that it's not possible to calculate the geoMean of a negative number, which is why this returns a 0

		//Testing double geoMean(a, b, c)
		System.out.println("\ndouble geoMean(13.4, 12.1, 17.3)\n" + Stats.geoMean(13.4, 12.1, 17.3)); // Returns 14.10301898703674
		System.out.println("\ndouble geoMean(12.4, 12.4, 12.4)\n" + Stats.geoMean(12.4, 12.4, 12.4)); // Returns 12.39999999999999999999999999 (?)
		System.out.println("\ndouble geoMean(-13.2, 10.1, 9.41)\n" + Stats.geoMean(-13.4, 10.1, 9.41)); // Returns NAN - as explained above

 
	}
}
