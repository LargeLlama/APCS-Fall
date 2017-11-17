/***
  driver for class Coin
  ~~~ SUGGESTED WORKFLOW: ~~~
  1. Compile this file and run.
  2. Move the "TOP" line below the first statement. 
  (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
  3. Compile and run again. 
  4. Resolve errors 1 at a time until it works
  5. Repeat 2-4 until TOP meets BOTTOM
***/

public class Driver
{
  public static void main( String[] args )
  {

    //build Objects from blueprint specified by class Coin

    //test default constructor

    Coin mine = new Coin();

    //test 1st overloaded constructor
    Coin yours = new Coin( "quarter","yours" );

    //test 2nd overloaded constructor
    Coin wayne = new Coin( "dollar", "wayne", "heads" );

    //test toString() methods of each Coin
    System.out.println("mine: " + mine);
    System.out.println("yours: " + yours);
    System.out.println("wayne: " + wayne);

    //test flip() method
    System.out.println("\nAfter flipping...");
    yours.flip();
    wayne.flip();
    System.out.println("yours: " + yours);
    System.out.println("wayne: " + wayne);

    //test equals() method
    if ( yours.equals(wayne) ) 
	    System.out.println( "Matchee matchee!" );
    else
	    System.out.println( "No match. Firestarter you can not be." );

	matchCount(yours, wayne, 10);
	// Test matchCount method to see if we can loop flips until we get 10 of them
	
	headFlip(yours, wayne, 10);

	matchCountAndDivisibleBy(yours, wayne, 13000, 2001);
	// Same as above but we also have to have a match count that is divisble by our birthyear (2001, in my case)
	
	// Above methods are universal and can be used for any non-negative integer to see how many matches 
	// and to test divisibility as well :)
	
  }//end main()
	
  public static void headFlip(Coin coin1, Coin coin2, int reqHeads) {
		int totalHeads = 0;
		coin1.setHeadsCtr(0);
		coin2.setHeadsCtr(0);
		coin1.setFlipCtr(0);
		coin2.setFlipCtr(0);

		while(true) {
			if (totalHeads >= reqHeads) {
				System.out.println("=================We reached " + reqHeads + "!========================");
				System.out.println(coin1.getObjName() + " got " + coin1.getHeadsCtr() + " and " + coin2.getObjName() + " got " + coin2.getHeadsCtr());
				break;
			}
		
			coin1.flip();
			coin2.flip();
		
			if (coin2.getUpFace() == "heads") {
				totalHeads ++;
				System.out.println(coin1 + "\n" + coin2 + "\nwe got a heads!");
			}else if (coin1.getUpFace() == "heads") {
				totalHeads ++;
				System.out.println(coin1 + "\n" + coin2 + "\nwe got a heads!");
			}else if (coin1.getUpFace() == "heads" && coin2.getUpFace() == "heads") {
				totalHeads += 2;
				System.out.println(coin1 + "\n" + coin2 + "\nwe got a heads!");
			}else {
				System.out.println(coin1 + "\n" + coin2 + "\n No Heads!");
			}
		System.out.println("=========CURRENT HEADS COUNT============\n" + totalHeads);
	
		}
  }
	
  public static void matchCount(Coin coin1, Coin coin2, int reqMatches) {
	
	System.out.println("We need " + reqMatches + " matches!");
	
	coin1.setFlipCtr(0);
	coin2.setFlipCtr(0);
	// Necessary for when printing out the number of flips it took to reach the required matches

	int totalMatches = 0;

	while (true) {

		if (totalMatches >= reqMatches)	{ // I made it >= to make sure the loop would never go on forever if the code wasn't able to register that the matches were equal

			System.out.println("*********" + coin1.getObjName() + " and " + coin2.getObjName() + " reached " + reqMatches + " matches in " + coin2.getFlipCtr() + " flips!");
			break; //

		}
		
		System.out.println("===========Current Matches Count============\n" + totalMatches + "\nFlip count: " + coin2.getFlipCtr());
		System.out.println("*Flipping!*'");
		
		coin2.flip();
		coin1.flip();
	
		if (coin1.equals(coin2)) {
			
			totalMatches ++;
			System.out.println("Issa match!\n" + coin1.getObjName() + ": " + coin1.getUpFace() + "\n" + coin2.getObjName() +  ": " + coin2.getUpFace());

		}else {
				
			System.out.println("NO MATCH\n" + coin1.getObjName() + ": " + coin1.getUpFace() + "\n" + coin2.getObjName() + ": " + coin2.getUpFace());
	
		}	
     }
  }
	// At first, I wrote out the code in the main method, and once I confirmed it worked, I made it into a method and generalized it
	// I was having isseus with printing out the name of the object, because "coin1" and "coin2" isn't very specific
	// So I decided to have that be a part of the constructor so I could call upon the name in my methods so I could be consistent
	// I took this extra step b/c I always found it good habit to be able to generalize
	// Any algorithm/logical loop that I write for specific cases so I could easily test it
	// By simply changing paramteres versus having to change all the variables

  public static void matchCountAndDivisibleBy(Coin coin1, Coin coin2, int reqMatches, int divisbleBy)  {

		System.out.println("We need " + reqMatches + " and the # of matches have to divisible by " + divisbleBy);
		int totalMatches = 0;

		coin2.setFlipCtr(0);
		
		while (true) {
			if (totalMatches >= reqMatches && totalMatches % divisbleBy == 0)	{
				// Here the >= is necessary otherwise it will go on together because if it is ==, then it can't be greater than but there clearly will be cases
				// When the number of matches exceeds the required in order to meet the divisbility requirement

				System.out.println("*********" + coin1.getObjName() + " and " + coin2.getObjName() + " reached " + reqMatches + " matches and had a match number divisible by " + divisbleBy);
				System.out.println("It took " + coin2.getFlipCtr() + " flips!");
				
				break; // the "break" keyword exits out of the loop and ensures that this doesn't go on forever 

			}

			System.out.println("===========Current Matches Count============\n" + totalMatches + "\nFlip count: " + coin2.getFlipCtr());
			System.out.println("*Flipping!*");
			// Some summary info

			coin2.flip();
			coin1.flip();
			// Actually flipping the coins
			
			if (coin1.equals(coin2)) {
			
				totalMatches ++; // add one to the totalMatches variabe
				
				System.out.println("Issa Match!\n" + coin1.getObjName() + ": " + coin1.getUpFace() + "\n" + coin2.getObjName() + ": " + coin2.getUpFace());

			}else {
			
				System.out.println("NO MATCH\n" + coin1.getObjName() + ": " + coin1.getUpFace() + "\n" + coin2.getObjName() + ": " + coin2.getUpFace());

			}	
		}	

	}
  	
	// I do the same thing here, except I add another parameter for "divisibleBy"
	// Once again, it is just good habit for me to be able to generalize
	// Logical algorithms, and it didn't take much longer
	// I simply copy and pasted what I had
	// and had to do some find & replacing - worth the effort put in

}//end class
