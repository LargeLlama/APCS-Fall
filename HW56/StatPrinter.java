//WOOOOOOOOOOOOObin Peco
//APCS pd1
//HW56 ahhhhhhhhhhhhhhhhhhhhhhh 
//2017-12-18
//yuh

/*====================================================================
  An AP-style question, for practice:
  Write the StatPrinter class below. The StatPrinter Object receives an
  ArrayList of nonnegative integers, then builds a frequency ArrayList in which
  the index values are the data and the entry at the index is the frequency.
  For example, if the received data is    2,3,2,5,1,3    then the frequency 
  list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
  2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
  the maximum value of the data.

  A capability of the class is to calculate local modes from the frequency 
  list. A local mode is a value that is greater than the value at index-1 
  and greater than the value at index+1. A local mode is never at the end
  points of the list. For example, if the frequency list is [1,2,1,4,2,3,5] 
  then the local modes are 2 and 4.

  This class is also capable of printing a histogram of the frequencies, using
  '*'s to indicate a frequency amount. To print a histogram, the user specifies
  the longest sequence of '*'s used and then all other values are printed in 
  proportion to this value. For example, if longest bar is 10 and the frequency
  list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

  0 : **
  1 : ****
  2 : **
  3 : ********
  4 : ****
  5 : ******
  6 : **********

  For each method, state run time efficiency using Big O notation.

  Tips for Awesome:
  * Keys to Success are so named for a reason.
  * Look over all fxns, think a bit, decide which to tackle first.
  ( Simplest?  Prerequisites? . . . )
  * Develop 1 fxn at a time, test it, then move to next.
  * For coding today, what extra code do you need to get past compiler?
  ====================================================================*/

import java.util.ArrayList;


public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]

	//***********HELPER FUNCTION*************************
	//i wrote this to simply get the freq of any value in an ArrayList to simplify my constructor
	
	public int getFreq(int value, ArrayList <Integer> data) {
		int count = 0; //count starts at 0

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).compareTo(value) == 0) {	//if the value given is = to the value at the index
				count += 1;	//add one to count
			}
		}
		
		return count;	//return count
	}

    public StatPrinter( ArrayList <Integer> data ) 
    {
		_frequency = new ArrayList<Integer>();	//initialize _frequency
	
		for (int i = 0; i <= max(data); i++) {	//add zeroes as placeholders, making sure its the length of the max value in data
			_frequency.add(i,0);
		}

		for (int i = 0; i < _frequency.size(); i++) {	//use the getFreq method to populate the _frequency arraylist
			_frequency.set(i, getFreq(i, data));
		}

    }
	//runs in O(n^2) b/c of the nested for loop, as it loops twice per index of _frequency


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data ) 
    { 
		int max = data.get(0);	//set the max to the first value of data

		for (int i = 0; i < data.size(); i++) {	//loop thru array, updating value of max
			if (data.get(i).compareTo(max) > 0)
				max = data.get(i);
		}
		
		return max;		//return max
    }
	//runs in O(n) time because it loops thru each element of the array once
	

    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i ) 
    { 
		return i > 0 && i < _frequency.size() - 1 &&
			   _frequency.get( i - 1 ) < _frequency.get( i ) &&
	   		   _frequency.get( i + 1 ) < _frequency.get( i );	//copied and pasted reqs from the method desc

    }


    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    public ArrayList<Integer> getLocalModes() 
    {
		ArrayList localModes = new ArrayList<Integer>();	//init new arraylist

		for (int i = 0; i < _frequency.size(); i++) {	//loop thru and check if it is a localMode
			if (isLocalMode(_frequency.get(i))) {
				_frequency.add(i);				//if so, add it to the array
			}
		}

		return localModes;
    }
	//O(n)


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar ) 
    {
		double ratio = longestBar/ max(_frequency);	//ratio is a double of the longestBar over the max
		String histogram = "";	//init empty string to be printed

		for (int i = 0; i < _frequency.size(); i++) {
			histogram += i + ": ";	//add the number and the colon and space for each index

			for (int n = 0; n < _frequency.get(i)*ratio; n++) {	//add the asterisks according to the ratio
				histogram += "*";
			}

			histogram += "\n";	//add a new line after each loop
		}

		System.out.println(histogram);	//print final histogram
	
    }
	//O(n^2) b/c it loops thru once for the entire array, and another time for each element * the ratio
 
}//end class StatPrinter
