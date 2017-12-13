//WOOOOOOBin Peco
//APCS pd1
//HW51 select sort
//2017-12-11
//yeah

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
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
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static int indexOfMin(ArrayList<Comparable> data, int passCount) {	//helper methdo to get index of min value
	  
	  int index = passCount;	//index can never be less than the passCount
	  Comparable min = data.get(passCount);	//set the min value to the first value of the sub array

	  for (int i = passCount; i < data.size(); i++) {
			if (min.compareTo(data.get(i)) > 0) {		//loop thru array, updating min value and index
				min = data.get(i);
				index = i;
			}
	  }
	  
	  return index;	//return the minindex
  }

  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data ) 
  { 

	if (data.size() > 1) { //unless the data has a size of 2 or more, it doesn't need to be sorted
		int passes = 0;	//initial pass count is 0
		
		while (passes < data.size() - 1) {		//never need more than n-1 passes, where n is the size of the array

			int minIndex = indexOfMin(data, passes); //set minIndex to the index of the current subarray we're looking at

			Comparable temp = data.set(passes, data.get(minIndex));	//set temp value to hold the larger value when we swap
			data.set(minIndex, temp);	//set it so we preserve all the values

			passes ++;	//increment the passes
		}
	}
	
	
  }//end selectionSortV

  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> data ) 
  {
	 ArrayList<Comparable> meme = new ArrayList<Comparable>();
	 if ( data.size() != 0) {
		 for (int i = 0; i < data.size() - 1; i++) {
			 meme.set(i, data.get(i));
	 	}

		selectionSortV(meme);
	 	return meme;
	 }

	 return data;
  }//end selectionSort 


  public static void main( String [] args ) 
  {
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      selectionSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
/*
      ArrayList mark = new ArrayList<Integer>();
      mark.add(7);
      mark.add(1);
      mark.add(5);
      mark.add(12);
      mark.add(3);
      System.out.println( "ArrayList mark before sorting:\n" + mark );
      ArrayList markSorted = selectionSort( mark );
      System.out.println( "sorted version of ArrayList mark:\n" 
      + markSorted );
      System.out.println( "ArrayList mark after sorting:\n" + mark );
    
      ArrayList meme = populate( 10, 1, 1000 );
      System.out.println( "ArrayList meme before sorting:\n" + meme );
      ArrayList memeSorted = selectionSort( meme );
      System.out.println( "sorted version of ArrayList meme:\n" 
      + memeSorted );
      System.out.println( "ArrayList meme after sorting:\n" + meme );
      System.out.println( meme );
  */    
  }//end main

}//end class SelectionSort
