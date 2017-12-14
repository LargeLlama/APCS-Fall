//WOOOOObin Peco, Jasonian Kim - Team Pow Pow Celery 
//APCS pd.1
//HW54 -- One File to Bring Them All...
//2017-12-13

import java.util.ArrayList;

public class MySorts {

    public static void bubbleSort( ArrayList<Comparable> data )
    {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
	        if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );	
	    }
	}
    }//end bubbleSort

    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,
	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;
	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	}
    }//end selectionSort

    public static void insertionSort( ArrayList<Comparable> data )
    {
	int passes = 0;	//int to keep track of passes
	while (passes <= data.size() - 1) { //as long as passes are less
	    for (int i = passes; i > 0; i--) { //start backwards, starting from the last item of the sorted partition		
		if (data.get(i).compareTo(data.get(i-1)) < 0) {	//compare the newly added item to the item before it		  	
		    Comparable temp = data.get(i-1); //swap if it is less
		    data.set(i-1, data.get(i));
		    data.set(i, temp);
		    //gdata); 
		    //uncomment above line to see the individual swapping
		}
	    }
	    //g"state of data at pass number " + passes + ": " + data); 
	    //uncomment above line to see how the state of data changes each pass
	    passes ++;	//increment passes, as we have looped thru the sorted partition and now want to increase its size by one
	}
    }//end insertionSort
}

	


