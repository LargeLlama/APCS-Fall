//WOOOOOOOobin Peco and Jasonian Kim - Team Pow Pow Celery
//APCS pd.1
//HW53
//2017-12-13

import java.util.ArrayList;

public class SortTester {

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


	public static void main(String[] args) {
		ArrayList meme = new ArrayList<Integer>();
		meme = populate(10, 1, 50);
		System.out.println("ArrayList meme: \n" + meme); 

		//Testing bubbleSort
		MySorts.bubbleSort(meme);
		System.out.println("\nSorted ArrayList meme: \n" + meme);
		//best case - items all in correct position (ascending order)

		//i.e - [0,8,11,20,31,71] requires no swaps, simply goes thru ArrayList ONCE
		ArrayList ahh = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) //adds ints 0-9 in order
			ahh.add(i);

		System.out.println("ArrayList ahh: \n" + ahh);
		MySorts.bubbleSort(ahh);
		System.out.println("BubbleSorted ArrayList ahh: \n" + ahh); //should not change it, as no swaps were needed

		//worst case - items in descending order 

	}	
}
