//WOOOOOOOobin Peco, Jasonian Kim - Team Pow Pow Celery
//APCS pd.1
//HW53 -- Solid Comparative Anaylsis
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

	//bubbleSort
	/*
	  best case - items all in correct position (ascending order).
	  i.e - [0,1,2,3,4,5,6,7,8,9] requires no swaps, simply goes thru ArrayList.
	  Never activates the body of the if statement.
	*/
	ArrayList bestCaseBub = new ArrayList<Integer>();
	for (int i = 0; i < 10; i++) //adds ints 0-9 in order
	    bestCaseBub.add(i);
	System.out.println("ArrayList bestCaseBub: \n" + bestCaseBub);
	MySorts.bubbleSort(bestCaseBub);
	System.out.println("BubbleSorted ArrayList bestCaseBub: \n" + bestCaseBub); //should not change it, as no swaps were needed
	
	/*
	  worst case - items in descending order.
	  i.e - [9,8,7,6,5,4,3,2,1,0] requires the maximum number of swaps. 
	  In every pass, the element being moved to the correct position is as far away as possible to the right of the sorted region.
	*/
	ArrayList worstCaseBub = new ArrayList<Integer>();
	for (int i = 9; i >= 0; i--) //adds ints 9-0 in order
	    worstCaseBub.add(i);
	System.out.println("ArrayList worstCaseBub: \n" + worstCaseBub);
	MySorts.bubbleSort(worstCaseBub);
	System.out.println("BubbleSorted ArrayList worstCaseBub: \n" + worstCaseBub);

	System.out.println("==============================");
	
	//selectionSort
	/*
	  best case/worst case - There is no best case, worst case situation here. 
	  No matter how the ArrayList is sorted, There will always be x-1 passes and x-1 swaps for size x.
	  This is because a pass is defined by a selection and a swap. 
	  The selection must involve every Comparable after the sorted region.
	  One swap is always made in a pass.
	*/
	ArrayList bestCaseSel = new ArrayList<Integer>();
	for (int i = 0; i < 10; i++) //adds ints 0-9 in order
	    bestCaseSel.add(i);
	System.out.println("ArrayList bestCaseSel: \n" + bestCaseSel);
	MySorts.selectionSort(bestCaseSel);
	System.out.println("SelectionSorted ArrayList bestCaseSel: \n" + bestCaseSel);
	
	ArrayList worstCaseSel = new ArrayList<Integer>();
	for (int i = 9; i >= 0; i--) //adds ints 9-0 in order
	    worstCaseSel.add(i);
	System.out.println("ArrayList worstCaseSel: \n" + worstCaseSel);
	MySorts.selectionSort(worstCaseSel);
	System.out.println("SelectionSorted ArrayList worstCaseSel: \n" + worstCaseSel);
	/*
	  Despite what the variable names may imply, neither is better or worse in terms of the number of steps that will be performed.
	  However, in the swap, it may be "better" for an element to swap with themselves. 
	*/

	System.out.println("==============================");
	
	//insertionSort
	/* 
	   best case - when the comparables are all in the correct position (ascending order).
	   in this case, no swaps will ever need to be made. 
	   no insertions or shifts at all.
	   Just goes through the ArrayList.
	*/
	ArrayList bestCaseIns = new ArrayList<Integer>();
	for (int i = 0; i < 10; i++) //adds ints 0-9 in order
	    bestCaseIns.add(i);
	System.out.println("ArrayList bestCaseIns: \n" + bestCaseIns);
	MySorts.insertionSort(bestCaseIns);
	System.out.println("InsertionSorted ArrayList bestCaseIns: \n" + bestCaseIns);

	/*
	  worst case - when the comparables are in descending order.
	  in a case like this, the element at the very end of the ArrayList will always have to be inserted to the very front of the ArrayList.
	  Everything gets shifted one position to the right.
	  Every pass after the first will have x-1 swaps given size x.
	*/
	ArrayList worstCaseIns = new ArrayList<Integer>();
	for (int i = 9; i >= 0; i--) //adds ints 9-0 in order
	    worstCaseIns.add(i);
	System.out.println("ArrayList worstCaseIns: \n" + worstCaseIns);
	MySorts.insertionSort(worstCaseIns);
	System.out.println("InsertionSorted ArrayList worstCaseIns: \n" + worstCaseIns);
    }	
}
