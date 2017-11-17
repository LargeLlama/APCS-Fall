// Rubin Peci, Raymond Wu, Kathleen Wong (team name: Vroom Vroom Cucumber) 
// Ubinray Ecipay, Aymondray Uway, Athleenkay Ongway (teamtay amenay: Oomvray Oomvray Ucumbercay)
// APCS1 pd1
// HW24 -- Imetay Otay Ineshay
// 2017-10-27

// Time To Shine


/***
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
 *
 *
 * TO-DO LIST:
 *  (1) engToPig method for whole sentences
 *       - basically engToPig function done to all words in a sentence
 *       - spaces delimit words
 *          - words would be separated and put into a list/array
 *          - Java equivalent of String.split() in Python?
 *          - iterate through every word, place punctuation at end of converted word if necesary
 *  Expansions:
 *  1)toCaps sets the first letter to a Capital and the rest lower case if String w has a capital
 *  2)hasPunctuation returns any punctuation in String w
 *  3)fixPunctuation 
 *    a) if punctuation is a hyphen, treats each part as a seperate word
 *    b) for any other punctuation, adds it to the end of the word
 *
 ***/


import java.util.Scanner;

public class Pig
{
  private static final String VOWELS = "aeiou";
  private static final String PUNCTUATION = "`~!@#$%^&*()_+{}|:\"<>?-=[];\\./,";
      // DOUBLE QUOTE and SINGLE QUOTE have ESCAPE SEQUENCES

    
  // Q: How does this initialization make your life easier?
  
  /*
     A: Vowels are referenced so often that 
          it is easier to initialize the string of vowels outside of any method 
          so that 
            its scope is the whole class
          and therefore
            it can be used in all methods inside this class.
  */


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
    
 public static boolean hasA( String w, String letter ) 
  {
   w = w.toLowerCase();     
   letter = letter.toLowerCase(); //toLowercase() is used so it isn't case sensitive when checking for equality

   return w.indexOf(letter) != -1; 
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
   letter = letter.toLowerCase(); //same logic here, except our vowels are all lowercase so we don't need to change that (plus it's a final variable so we couldn't

   return VOWELS.indexOf(letter) != -1; 
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    int count = 0;        //initialize and set value of counter variable
    
    for (int i = 0; i < w.length(); i++) {  //loop thru string
  
      if (isAVowel(w.substring(i,i+1))) //if the letter we come across is a vowel, we add one to count
      count++;

    }

    return count;         //return value of count

  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")      he st ill didn -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
      return countVowels(w) >= 1;   //as long as it has at least 1 vowel, it has a vowel (makes use of previously written function)
  }



  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    String retStr = "";               //Initialize and set return string
    
    for (int i = 0; i < w.length(); i++) {      //loop through the string
      
      String currentLetter = w.substring(i,i+1);  //set the current letter to whatever index i represents
      
      if (isAVowel(currentLetter))          //if it is a vowel, we add it to the return string
        retStr += currentLetter;
    }
    
    return retStr;                  //return the value of our return string
  }
  
  
  // HW23 begins here /////////////////////////////////////////////////////////////////////////
  
  
  // pre: w != null
  // post: firstVowel("") --> ""
  public static String firstVowel( String w) {
    for (int i = 0; i < w.length(); i++)
    {
      String thisCharacter = w.substring(i, i+1);
      
      if (isAVowel(thisCharacter))                // if current character is a vowel
      {
        return thisCharacter;                       // get out of for look and return this char
      }
    }
    
      return "";                                    // if no vowels found, return empty string
  } // end firstVowel method
   
  
  
  //pre: w != null and w.length() > 0
  //post: beginsWithVowel("apple")  --> true
  //      beginsWithVowel("strong") --> false
  public static boolean beginsWithVowel( String w) {
    String firstCharacter = w.substring( 0, 1);
    
    return isAVowel(firstCharacter);               // return boolean (if first character is a vowel)
  } // end beginsWithVowel method
  
  
  // HW24 begins here /////////////////////////////////////////////////////////////////////////
  
  
  public static String toCaps(String w){
    int capCounter = 0;
    for (int i = 0; i < w.length(); i++) {
  
       String thisCharacter = w.substring(i, i + 1);
       
       if (thisCharacter != thisCharacter.toLowerCase())
       {
         capCounter += 1;  
       }
    } // end for loop

    //if there is only one capital,(first letter was originally capital) make the first letter of return string capital
    if (capCounter == 1)
    {
      return (w.substring(0,1)).toUpperCase()+w.substring(1).toLowerCase();
    }
 
    //if all leters were caps, return all caps
    else if (capCounter > 1)
    {
      return w.toUpperCase();
    }
  
    else
    {
      return w;
    }

  } // end toCaps method
  
  
  
  public static String hasPunctuation(String w) 
  {
    for ( int i = 0; i < w.length(); i++) 
    {
      String thisCharacter = w.substring(i, i+1);
      
      // if this character is found in PUNCTUATION string (is punctuation)
      if ( PUNCTUATION.indexOf(thisCharacter) != -1)
      {
        return thisCharacter;
        // return this character
      }
      
    } // end for loop
    
    return "";
    // only reaches here if no punctuation found
    // return empty strings
    
  } // end hasPunctuation method
  
  
  
  public static String fixPunctuation(String w) {

    int indexFirstVowel = w.indexOf(firstVowel(w));

    String punctuation = hasPunctuation(w);
    int indexOfPunctuation = w.indexOf(punctuation);
  
    // if this character is punctuation
    if (!punctuation.equals(""))
    {
      if (punctuation.equals("-"))
      {
        return engToPig(w.substring(0,indexOfPunctuation)) + "-" + engToPig(w.substring(indexOfPunctuation + 1));
        // takes care of each word separated by hyphens
      }
      else if (punctuation.equals("\"")) 
	  {
		  int index = w.indexOf(punctuation);
	
		  if (index == 0 && w.indexOf(punctuation, index + 1) == -1) 

			  return punctuation + engToPig(w.substring(1));

		  else if (index == 0 && w.indexOf(punctuation, index + 1) != -1) 

			  return engToPig(w.substring(1, w.length())) + punctuation;

	  }
	  else if (punctuation.equals("(")) 
	  {
		  int index = w.indexOf(punctuation);
		  if (index == 0 && w.indexOf(")") == -1)
			  
			  return punctuation + engToPig(w.substring(1));

		  else if (index == 0 && w.indexOf(")") != -1)
			  
			  return punctuation + engToPig(w.substring(1)) + ")";
	  }
	  else 
	  {
        return w.substring(0,indexOfPunctuation) + w.substring(indexOfPunctuation + 1) + punctuation;
      }

      
    } //end enclosing IF
    
    return w;
  } // end fixPunctuation method
  
  
  
  //pre: w.length() > 0
  //post: engToPig("apple")  --> "appleway"
  //      engToPig("strong") --> "ongstray"
  //      engToPig("java")   --> "avajay"
  //       ... and more (see main method tests)
  public static String engToPig( String w) {
    String firstLetter = w.substring(0, 1);
    int firstVowelIndex = w.indexOf(firstVowel(w));
    
    // if original word begins is hyphenated
    if (hasPunctuation(w).equals("-")) 
    {
      return fixPunctuation(w);
    }
    
    //if original word begins with a vowel and has an apostrophe 
    else if (beginsWithVowel(w) && hasPunctuation(w).equals("'"))
    {
      return (w + "way");
    } 
    
    //if it doesn't begin with a vowel and has an apostrophe
    else if (!beginsWithVowel(w) && hasPunctuation(w).equals("'")) 
    {
      return toCaps(w.substring(firstVowelIndex) + w.substring(0, firstVowelIndex) + "ay");
    }
    
    //if it begins with a vowel and has no punctuation
    else if (beginsWithVowel(w) && hasPunctuation(w).equals(""))
    {
      w = toCaps(w + "way");
      return fixPunctuation(w);
    } 
    
    //if it begins with a vowel and it has some punctuation that isn't a hyphen or apostrophe
    else if (beginsWithVowel(w) && !hasPunctuation(w).equals("")) 
    {
      w = toCaps(w + "way");
      return fixPunctuation(w);
    } 
    
    //begins with "y"
    else if ( firstLetter.equals("y") ) {
      
      w = toCaps("y" + w.substring(firstVowelIndex) + w.substring(0, firstVowelIndex) + "ay");
      return fixPunctuation(w); 

    }
	else if (hasPunctuation(w).equals("\"") && w.indexOf("\"") == w.length() - 1) {

		return engToPig(w.substring(0,w.length() - 1)) + hasPunctuation(w);

	}
	
	else if (hasPunctuation(w).equals("\"") && w.indexOf("\"", w.indexOf("\"") + 1) == -1){

		w = hasPunctuation(w) + toCaps(w.substring(1));
		return fixPunctuation(w); 
	}
	else if (hasPunctuation(w).equals("\"") && w.indexOf("\"", w.indexOf("\"")) != -1)
	{
		return hasPunctuation(w) + engToPig(w.substring(1,w.length() - 1)) + hasPunctuation(w);
	}
// if original word begins with a consonant
    else 
    {
      
      w=(w.substring(firstVowelIndex) + w.substring(0, firstVowelIndex) + "ay"); 
	  return toCaps(fixPunctuation(w));
    }
  
  } // end engToPig method


  public static void main( String[] args ) 
  {
    /*    archive of hw22, hw23
    
    System.out.println( "================== hasA tests ==================");
    System.out.println( hasA("cat","a") );              // prints true
    System.out.println( hasA("cat","p") );              // prints false
    
    System.out.println( "================ isAVowel tests ================");
    System.out.println( isAVowel("a") );                // prints true
    System.out.println( isAVowel("e") );                // prints true
    System.out.println( isAVowel("y") );                // prints false
    
    System.out.println( "=============== countVowels tests ==============");
    System.out.println( countVowels("meatball") );      // prints 3
    System.out.println( countVowels("nothing")  );      // prints 2
    System.out.println( countVowels("queueing") );      // prints 5
    
    System.out.println( "================ hasAVowel tests ===============");
    System.out.println( hasAVowel("meatball") );        // prints true
    System.out.println( hasAVowel("xyz")      );        // prints false
    System.out.println( hasAVowel("cat")      );        // prints true
    
    System.out.println( "================ allVowels tests ===============");
    System.out.println( allVowels("meatball") );        // prints eaa
    System.out.println( allVowels("xyz")      );        // prints (null string)
    System.out.println( allVowels("cat")      );        // prints a
    
    // HW23 begins here ////////////////////////////////////////////////////
    System.out.println( "\n\n////////////////////// HW23 begins here ////////////////////// \n");
    
    System.out.println( "================ firstVowel tests ==============");
    System.out.println( firstVowel("")         );       // prints e
    System.out.println( firstVowel("zzz")      );       // prints (null string)
    System.out.println( firstVowel("meatball") );       // prints a
    
    System.out.println( "============= beginsWithVowel tests ============");
    System.out.println( beginsWithVowel("apple")  );    // prints true
    System.out.println( beginsWithVowel("strong") );    // prints false 
    System.out.println( beginsWithVowel("yes")    );    // prints false
    
    System.out.println( "================ engToPig tests ================");
    System.out.println( engToPig("apple")  );           // prints appleway
    System.out.println( engToPig("strong") );           // prints ongstray
    System.out.println( engToPig("java") );             // prints avajay
    System.out.println( engToPig("always") );           // prints alwaysway
    System.out.println( engToPig("yes")    );           // prints esyay
    System.out.println( engToPig("thicc")  );           // prints iccthay
    System.out.println( engToPig("yay")  );             // prints yayyay
    
        // end hw22, hw23 archive
    
    // HW24 begins here ////////////////////////////////////////////////////
    System.out.println( "\n\n////////////////////// HW24 begins here ////////////////////// \n");
    
    System.out.println( "======== capitalization tests ========");
    System.out.println( engToPig("eureka"));            // prints eurekaway
    System.out.println( engToPig("Eureka"));            // prints Eurekaway
    System.out.println( engToPig("gnarly"));            // prints arlygnay
    System.out.println( engToPig("Gnarly"));            // prints Arlygnay
    
    System.out.println( "====== caps + punctuation tests ======");
    System.out.println( engToPig("gnarly."));           // prints arlygnay.
    System.out.println( engToPig("gnarly,"));           // prints arlygnay,
    System.out.println( engToPig("Gnarly."));           // prints Arlygnay.
    System.out.println( engToPig("ice-cream"));         // prints iceyay-eamcray
    System.out.println( engToPig("Ice-cream"));         // prints Iceyay-eamcray
    System.out.println( engToPig("Don't!"));            // prints On'tday!
    System.out.println( engToPig("mother-in-law"));     // prints othermay-inway-awlay
    System.out.println( engToPig("OH!"));               // prints OHWAY!
    */
    
    Scanner sc = new Scanner( System.in);
      
    while ( sc.hasNext() )
      {
        System.out.println( engToPig(sc.next() ) );
      }
      
  } //end main() method

} //end class Pig
