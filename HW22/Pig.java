//Rubin Peci
//APCS Pd. 1
//HW22 - since we're using different languages, questo compito e' molto divertente
//2017-10-24

/***
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";
  //A: Having a constant for the vowels allows me to loop through it to see if a string starts with a vowel.

  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
	 w = w.toLowerCase();			
	 letter = letter.toLowerCase();	//toLowercase() is used so it isn't case sensitive when checking for equality

	 return w.indexOf(letter) != -1; 
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
	 letter = letter.toLowerCase();	//same logic here, except our vowels are all lowercase so we don't need to change that (plus it's a final variable so we couldn't

	 return VOWELS.indexOf(letter) != -1; 
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
	  int count = 0;				//initialize and set value of counter variable
	  
	  for (int i = 0; i < w.length(); i++) {	//loop thru string
	
		  if (isAVowel(w.substring(i,i+1)))	//if the letter we come across is a vowel, we add one to count
			count++;

	  }

	  return count;					//return value of count

  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
  		return countVowels(w) >= 1;		//as long as it has at least 1 vowel, it has a vowel (makes use of previously written function)
  }



  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
	  String retStr = "";								//Initialize and set return string
	  
	  for (int i = 0; i < w.length(); i++) {			//loop through the string
		  
		  String currentLetter = w.substring(i,i+1);	//set the current letter to whatever index i represents
		  
		  if (isAVowel(currentLetter))					//if it is a vowel, we add it to the return string
			  retStr += currentLetter;
	  }
	  
	  return retStr;									//return the value of our return string
  }

  /*======================================
    String engToPigLatin(String) -- returns Pig Latin form of a single word
	pre: str != null and is a single word
	post: engToPigLatin("meatball") -> "eatballmay"
		  engToPigLating("also") -> "alsoway"
	======================================*/
  public static String engToPigLatin(String str) {
	  String firstLetter = str.substring(0,1);

	  if (isAVowel(firstLetter))				//checks if firstLetter is a vowel
		  return str + "way";				//if true, appends "way"
	  
	  return str.substring(1) + firstLetter + "way";	//else, move first letter to end and append "way"
  }

  public static void main( String[] args ) 
  {
		//========================TESTING hasA() method======================
		System.out.println("====TESTING hasA(string, letter)====");
		System.out.println("hasA(test,a): " + hasA("test","a"));	//return false
		System.out.println("hasA(test,e): " + hasA("test", "e"));	//return true
		
		//========================TESTING isAVowel() method==================
		System.out.println("====TESTING isAVowel(letter)====");
		System.out.println("isAVowel(a): " + isAVowel("a"));    //return true
		System.out.println("isAVowel(b): " + isAVowel("b"));	//return false

		//========================TESTING countVowels(string)=================
		System.out.println("====TESTING countVowels(string)====");
		System.out.println("countVowels(abcde): " + countVowels("abcde")); //return 2
		System.out.println("countVowels(aeiou): " + countVowels("aeiou")); //return 5
		System.out.println("countVowels(fffff): " + countVowels("fffff")); //return 5
		
		//

		//========================TESTING allVowels(string)===================
		System.out.println("====Testing allVowels(string)====");
		System.out.println("allVowels(meatball): " + allVowels("meatball")); //return "eaa"
		System.out.println("allVowels(aaaaaaaa): " + allVowels("aaaaaaaa")); //return "aaaaaaaa"
		System.out.println("allVowels(n0 v0w3ls h3r3!): " + allVowels("n0 v0w3ls h3r3!")); //return ""

		for (String s : args) {
			System.out.print(engToPigLatin(s) + " ");  //For each string/word that is included in the execution, run the engToPigLatin on it, then add a space
		}

		System.out.println(); //Once the for loop is done, add an empty line
	
  }//end main()

}//end class Pig 
