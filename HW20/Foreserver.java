//Rubin Peci
//APCS PD.1
//HW20 - For the LOVE of Strings
//2017-10-19

public class Foreserver {

	public static String fenceF(int posts) {
		String retStr = "";

		if (posts == 0)     //if posts is 0, it should print out an empty string
			return retStr; 

		retStr += "|";     //otherwise, we add the very first fence post, and build it from there

		for (int i = 1; i < posts; i ++) {        //I start with a value of 1 for i so if they input 1, the for loop is skipped and it just prints "|"
			retStr += "--|";                      //otherwise it keeps adding "--|", building the fence
		}										  //incrementing i until it it reaches the input

		return retStr;                            //return the final result
	}

	public static String reverseF(String s) {
		String retStr = "";                           //instantiate the return string

		for (int i = s.length() - 1; i >= 0; i--) {  //count down from the last part of the string until I reach zero
			retStr += s.substring(i, i+1);		          //i keep adding just the last character of the string, who's index is equal to the value of i
		}
		return retStr;								  //return the final result
	} 

	public static String reverseR(String s) {
		if (s.length() == 0)   //our base case is an empty string, in which case we just return that empty string 
			return s;
		else
			return s.substring(s.length() - 1) + reverseR(s.substring(0,s.length()-1)); //otherwise, we get the last character in the string
																						//and then we run the function again on everything but
																						//the last character, cutting it down by one until we get a string of length 0
	}

	public static void main (String[] args) {
		System.out.println("====Testing fenceF====");
		System.out.println("fenceF(0): " + fenceF(0));   //return ""
		System.out.println("fenceF(1):  " + fenceF(1));  //return "|"
		System.out.println("fenceF(10): " + fenceF(10)); //return "|--|" x 10
		System.out.println("fenceF(25): " + fenceF(25)); //return "|--|" x 25

		System.out.println("\n====Testing reverseF====");
		System.out.println("reverseF('abcd'): " + reverseF("abcd"));                                                 	//return "dcba"
		System.out.println("reverseF('racecar'): " + reverseF("racecar")); 											 	//return "racecar"
		System.out.println("reverseF('Mr. Brown has a cool earring'): " + reverseF("Mr. Brown has a cool earring")); 	//return "gnirrae looc a sah nworb .rm"
		System.out.println("reverseF('PIG'): " + reverseF("PIG"));														//return "GIP"

		System.out.println("\n====Testing reverseR====");
		System.out.println("reverseR('abcd'): " + reverseR("abcd"));													//return "dcba"		
		System.out.println("reverseR('racecar'): " + reverseR("racecar"));												//return "racecar"
		System.out.println("reverseR('Mr. Brown has a cool earring'): " + reverseR("Mr. Brown has a cool earring")); 	//return "gnirrae looc a sah nworb .rm"  
		System.out.println("reverseR('PIG'): " + reverseR("PIG"));														//return "GIP"	
		
	}

}
