// Rubin Peci
// APCS PD. 1
// HW19 - gcd in THREE ways for the price of one
// 2017-10-19

public class Stats {

	public static int gcd(int a, int b) {
		int i = 1;
		int min = Math.min(a,b);
		int gcd = 1;
		while ( i <= min ) {
			if (a % i == 0 && b % i == 0)
				gcd = i;
			i ++;
		}
		return gcd;
	}

	//The following methods make use of Euclid's algorithm for find the GCD of two numbers - it consists of taking two numbers, seeing if they are divisble
	//If not, then you subtract the smaller one from the larger, check if either of them are zero, and then return the non-zero value
	//if they both are > 0, then u repeat the subtraction, continously subtracting the smaller one from the larger - in terms of code - this is the same
	//thing as a == b, because if you subtract a from b and b now equals zero, you know that a's value is the same as b's, so in my gcdEW, this is why
	//I use while(a != b) instead of while(a != 0 && b != 0)



	//This recursive method starts off with establish which number is smaller and larger, because the order of a and b isn't specificed
	//If one # divides into the other, then that # is the gcd
	//Otherwise, we have to subtract the smaller one from the maximum, see if that makes the maximum zero, other wise we run the whole function over again
	
	public static int gcdER(int a, int b) {
		int min = Math.min(a,b);    //establish which one is the bigger and smaller one
		int max = Math.max(a,b);

		if (max % min == 0)   //Check their divisibility
			return min;
		else
			max -= min;          //subtract the smaller from the larger
			if (max == 0)
				return min;      // if it's equal to zero return the smaller
			else
				return gcdER(min, max);     //otherwise run thru the same fucntion again with the new numbers
	}


	//The while loop implementation is far simpler than the recursive, but it took me quite a while to get working
	//If a == b, then we know we can return either of them as our gcd, but if not, we go through the process of subtracting the smaller from the larger
	//This keeps happening until one of them is equal, and if not, we keep subtracting until they get equal, then we return either one of them
	//it doesn't matter which because they will be equal
	
	public static int gcdEW(int a, int b) {
		if (a % b == 0) 
			return b;
												// check if either of them divide each other
		else if (b % a == 0)
			return a;
														
		while (a != b) {          // other wise we loop thru subtracting the smaller one from the bigger one until they end up equal to each other
			if (a > b)
				a -= b;
			else
				b -= a;
		}
		return a;   // we could return a or b, i just chose a 
	}

	
	public static void main(String[] args) {
		// diagnostic test cases let the user know what is being inputted and the result for that function - they all are the same input
		// so the outputs should be the same
		
		System.out.println("====Testing gcd (brute force method)====");
		System.out.println("gcd(15,20) = " + gcd(15,20));
		System.out.println("gcd(60, 100) = " + gcd(60,100));
		System.out.println("gcd(10,100) = " + gcd(10, 100));
		System.out.println("gcd(17, 303) = "  + gcd(17, 303) + "\n");

		System.out.println("====Testing gcdER (recursive Euclidean method)====");
		System.out.println("gcdER(15,20) = " + gcdER(15,20));
		System.out.println("gcdER(60,100) = " + gcdER(60,100));
		System.out.println("gcdER(10,100) = " + gcdER(10, 100));
		System.out.println("gcdER(17, 303) = " + gcdER(17, 303) + "\n");

		System.out.println("====Testing gcdEW (loop Euclidean method)====");
		System.out.println("gcdEW(15,20) = " + gcdEW(15,20));
		System.out.println("gcdEW(60,100) = " + gcdEW(60,100));
		System.out.println("gcdEW(10,100) = " + gcdEW(10, 100));
		System.out.println("gcdEQ(17, 303) = " + gcdEW(17, 303));
	}
}
