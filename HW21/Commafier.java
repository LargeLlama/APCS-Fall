//Rubin Peci
//APCS Pd.1
//HW21 - Something about COMMAS
//2017-10-23
//clout

public class Commafier {
	public static void main (String[] args) {
	//	System.out.println("1291345: " + commafiyR(1291345));	
	//	System.out.println("1301: " + commafiyR(1301));	

	//	System.out.println("1291345: " + commafiyF(1291345));
	//	System.out.println("1309: " + commafiyF(1309));
	

		for ( String s: args) {					//for each String in the array of Strings called "args"
			int num = (Integer.parseInt(s));	//set the integer num equal to the int value of s
			System.out.println(commafiyR(num)); //call the recursive function to print out the number as a string with commas 
			System.out.println(commafiyF(num));	//call the looping function to print out the number as a string with commas
		}
	}

	public static String commafiyR(int number) {
		String s = Integer.toString(number);	//I convert the integer into a string using the toString() method in the Integer class

		if (number < 1000)						//The base case - if the number is less than 1000, it doesnt need commas and can simply be returned as is
			return Integer.toString(number);
		return commafiyR(number / 1000) + "," + s.substring(s.length()-3);  //otherwise, we keep dividing the # by 1000 until we get 
																			//parts of it to be less than 1000, where we then add a comma and then the last three 
																			//characters in the string
	}

	public static String commafiyF(int number) {
		String s = Integer.toString(number);				//convert the integer into a string
		String retStr = "";									//initialize return string and have it set to ""

		for (int i = 0; i < s.length()-3; i++) {			//for loop to loop through the sequence
			retStr += "," + s.substring(s.length()-3);		//i add a comma plus the last 3 chars of the string
			s = s.substring(0, s.length() - 3);				//i remove the last three characters of the string and repeat until i < s.length()-3
		}
		retStr = s + retStr;								//i add the remaining chunk of s to the return string
		return retStr;										//finally, I return the retStr

	}
}
