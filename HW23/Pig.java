// Rubin Peci, Raymond Wu, Kathleen Wong              ( team name: Vroom Vroom Cucumber )
// Ubinray Ecipay, Aymondray Uway, Athleenkay Ongway  ( eamtay amenay: Oomvray Oomvray Ucumbercay )
// APCS1 pd1
// HW23 -- Etterbay Odingcay Oughthray Ollaborationcay ...Ippyay.
// 2017-10-24

// Better Coding Through Collaboration ...Yipp.


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
 *
 ***/

public class Pig
{
  private static final String VOWELS = "aeiou";
  
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
    return w.indexOf( letter) != -1;
  } // end hasA method


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
    return VOWELS.indexOf( letter) != -1;            // if letter in VOWELS
  } // end isAVowel method


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    int numVowels = 0;
    
    for ( int i = 0; i < w.length(); i++ )
    {
      String thisCharacter = w.substring(i, i+1);
      
      if ( isAVowel( thisCharacter) == true )       // if this character is a vowel
      {
        numVowels += 1;                             // then add 1 to counter
      }
    }
    
    return numVowels;                               // after iterating through chars of String
  } // end countvowels method                       // return number of vowels


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
    if ( countVowels( w) != 0 )                     // praise the modular design gods
    {                                               // if countVowels says no vowels in word
      return true;                                  // return true
    }
    else                                            // else ( num of vowels not = 0 )
    {
      return false;                                 // return false
    }
  } // end hasAVowel method


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    String listVowels = "";                         // String to be returned ("retStr")
    
    for ( int i = 0; i < w.length(); i++ )
    {
      String thisCharacter = w.substring( i, i+1);
      
      if ( isAVowel( thisCharacter) == true )       // if the current character is a vowel
      {
        listVowels += thisCharacter;                // append this char to return string
      }
    }
    
    return listVowels;                              // after iterating through chars of String
  } // end allVowels method                         // return list of all instances of vowels



  // HW23 begins here /////////////////////////////////////////////////////////////////////////
  
  
  // pre: w != null
  // post: firstVowel("") --> ""
  public static String firstVowel( String w)
  {
    for ( int i = 0; i < w.length(); i++ )
    {
      String thisCharacter = w.substring( i, i+1);
      
      if ( isAVowel(thisCharacter) )                // if current character is a vowel
      {
        return thisCharacter;                       // get out of for look and return this char
      }
    }
    
      return "";                                    // if no vowels found, return empty string
  } // end firstVowel method
  
  
  
  //pre: w != null and w.length() > 0
  //post: beginsWithVowel("apple")  --> true
  //      beginsWithVowel("strong") --> false
  public static boolean beginsWithVowel( String w)
  {
    String firstCharacter = w.substring( 0, 1);
    
    return isAVowel( firstCharacter);               // return boolean (if first character is a vowel)
  } // end beginsWithVowel method
  
  
  
  //pre: w.length() > 0
  //post: engToPig("apple")  --> "appleway"
  //      engToPig("strong") --> "ongstray"
  //      engToPig("java")   --> "avajay"
  public static String engToPig( String w)
  {
    String firstLetter = w.substring( 0, 1);
    int firstVowelIndex = w.indexOf( firstVowel(w) );
    
    if ( beginsWithVowel(w) )   // if original word begins with a vowel
    {
      return w.substring(firstVowelIndex) + w.substring(0, firstVowelIndex) + "way";
    }  //    all of String from first vowel (incl.) 
       //  + String from beginning to first vowel (excl.) 
       //  + "way"
    
    else                        // if original word begins with a consonant
    {
      return w.substring(firstVowelIndex) + w.substring(0, firstVowelIndex) + "ay"; 
    }  //    all of String from first vowel (incl.) 
       //  + String from beginning to first vowel (excl.) 
       //  + "ay"
  }


  public static void main( String[] args ) 
  {
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
    System.out.println( engToPig("yes")    );           // prints esyay
    System.out.println( engToPig("thicc")  );           // prints iccthay
        
  } //end main() method

} //end class Pig

