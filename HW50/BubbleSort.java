//WOOOOOOOOOObin Peco
//APCS pd1
//HW50 bubble butt
//2017-12-08
//yeahh

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
	int currentElement = data.size() - 1;	//currentElement is last element of arraylist
	int neighboringElement = data.size() - 2;	//neighboringElement is element next to last
	int passCount = 0;	//0 passes done to begin with
	int maxPasses = currentElement;	//maxPasses is equal to size - 1, which also is value of currentElement

	Comparable temp = null;	//temp variable to store value before swap
	
	while (passCount < maxPasses) {

		if (data.get(currentElement).compareTo(data.get(neighboringElement)) < 0) {	//if the currentElement is less than its neighbor, we swap them
			temp = data.get(currentElement);			
			data.set(currentElement, data.get(neighboringElement));
			data.set(neighboringElement, temp);
		}

		if ( neighboringElement > 0) {		//if we are not at the first element
			currentElement -= 1;			//subtract each index counter by one
			neighboringElement -= 1;
		}else {	//otherwise, we have looped thru the entire array once
			passCount += 1;		//add one to count
			currentElement = data.size() - 1;	//set index counters to original value so we can loop thru again
			neighboringElement = data.size() - 2;
		}

	} 

  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
	  ArrayList<Comparable> data = new ArrayList<Comparable>();
	  data = input;

 	  int currentElement = data.size() - 1;	//currentElement is last element of arraylist
	  int neighboringElement = data.size() - 2;	//neighboringElement is element next to last
	  int passCount = 0;	//0 passes done to begin with
	  int maxPasses = currentElement;	//maxPasses is equal to size - 1, which also is value of currentElement

	  Comparable temp = null;	//temp variable to store value before swap
	
	  while (passCount < maxPasses) {

	  	if (data.get(currentElement).compareTo(data.get(neighboringElement)) < 0) {	//if the currentElement is less than its neighbor, we swap them
			temp = data.get(currentElement);			
			data.set(currentElement, data.get(neighboringElement));
			data.set(neighboringElement, temp);
		}

		if ( neighboringElement > 0) {		//if we are not at the first element
			currentElement -= 1;			//subtract each index counter by one
			neighboringElement -= 1;
		}else {	//otherwise, we have looped thru the entire array once
			passCount += 1;		//add one to count
			currentElement = data.size() - 1;	//set index counters to original value so we can loop thru again
			neighboringElement = data.size() - 2;
		}

	} 

	return data;
	  
  }


  public static void main( String [] args )
  {

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
	  //ArrayList VOID sort method
	  System.out.println("=====TESTING sortV======\n");
	
      System.out.println( "ArrayList glen before sorting:\n" + glen + "\n");
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen  + "\n");

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco + "\n");
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco + "\n");

	  //ArrayList return sort method
	  System.out.println("\n======TESTING sortReturn=====\n");
      ArrayList meme = new ArrayList<Integer>();
      meme.add(7);
      meme.add(1);
      meme.add(5);
      meme.add(12);
      meme.add(3);
      System.out.println( "ArrayList meme before sorting:\n" + meme + "\n");
      ArrayList memeSorted = bubbleSort( meme );
      System.out.println( "sorted version of ArrayList meme:\n" 
      + memeSorted );
      System.out.println( "ArrayList meme after sorting:\n" + meme + "\n");

      ArrayList bobo = populate( 10, 1, 1000 );
      System.out.println( "ArrayList bobo before sorting:\n" + bobo + "\n");
      ArrayList boboSorted = bubbleSort( bobo );
      System.out.println( "sorted version of ArrayList bobo:\n" 
      + boboSorted + "\n");
      System.out.println( "ArrayList bobo after sorting:\n" + bobo + "\n");
      System.out.println( bobo );

  }//end main

}//end class BubbleSort
