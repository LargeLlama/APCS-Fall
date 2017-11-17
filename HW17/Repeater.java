//Rubin Peci
//APCS PD.1
//HW17 - Do I repeat myself?
//2017-10-16

public class Repeater {


	public static void main(String[] args) {

		System.out.println("====Testing an input of 0 for both functions!====");
		System.out.println(fenceR(0)); //tests the zero case in both functions - should just print an empty string
		System.out.println(fenceW(0));

		System.out.println("====Testing an input of 1 for both functions!====");
		System.out.println(fenceR(1)); //tests the base case for the recursive function
		System.out.println(fenceW(1)); //tests the while loop - both should print "|"

		System.out.println("====Testing an input of 10 for both functions!====");
		System.out.println(fenceR(10)); //tests the functions with a number that will actually make the recursive call
		System.out.println(fenceW(10)); //tests the while loop to make sure both print out the same thing 

		System.out.println("====Testing an input of 25 for both functions!====");
		System.out.println(fenceR(25)); //just for fun!
		System.out.println(fenceW(25));

	}


	public static String fenceW(int numPosts) {
		int i = 1; //i should be set to one because it accounts for the input of 0
		
		String retStr = "";  //instantiate our return string to be an empty string
		if (numPosts < 1) 
			return retStr; //if it is zero, it simply returns a blank string, otherwise it keeps going through the function

		while (i < numPosts) {  //as long as i is less than the input it keeps adding to the return string
			retStr += "|--";   //add the necessary characters to the string
			i ++; //increment i by one so it eventually meets the value of numPosts given
		}	

		retStr += "|"; // the additional "|" is needed because the final returnStr is missing it

		return retStr;
	}

	public static String fenceR(int numPosts) {

		if (numPosts < 1)      // accounts for the case where 0 is inputted, returning an empty string
			return "";
		else if (numPosts == 1) // the base case - if the function reaches an input of 1, it simply prints a single "|"
			return "|";
		else
			return "|--" + fenceR(numPosts - 1); //otherwise, it will continue to run through the function, returning "|--"
												 //plus what the function would return with the input being decreased by one
	}
	// also, I noticed that if-else statements don't actually require brackets, which i noticed when looking at some of your sample code, so I tested it out 
	// here and it works! that was a surprise
}
