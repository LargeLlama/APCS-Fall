//WOOOOOOoobin Peco
//APCS pd 1
//HW49 - ascending 
//2017-12-7
//yeah

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
	  _data = new ArrayList<Comparable>();
	  //set _data to a instance of ArrayList of type Comparable
  }


  public String toString()
  {
	 return _data.toString();
	 //uses the toString() of ArrayList to print out contents
  }


  public Comparable remove( int index )
  {
	  return _data.remove(index);
	  //uses remove method of ArrayList, as removing anything will not matter if it's sorted as it will remain sorted
  }


  public int size()
  { 
     return _data.size(); 
	 //simply return the size of the ArrayList
  }

    
  public Comparable get( int index )
  { 
    return _data.get(index); //placeholder  
  }

//should add via binary search yurd

  public void addBin(Comparable newVal)
  { 
	
	if (size() == 0) {
		_data.add(newVal);
	}
	else {
	
		int _lo = 0;	//start at first index
		int _hi = size();	//make the highest the size
		int currentHalf = (int)(_hi / 2);	//half has to be an int value

		while (_hi > _lo) {	//as long as the _hi is larger than the _lo, it can be cut in half
			
			if (newVal.compareTo(_data.get(currentHalf)) < 0) {	//if the newVal is less than the currentHalf
				_hi = currentHalf;		//set _hi to current half
				currentHalf = (int)(_hi / 2);		//then cut half in half again

			} else if (newVal.compareTo(_data.get(currentHalf)) > 0) { //if newVal is higher than the currentHalf
				_lo = currentHalf + 1; //set _lo to half plus one
				currentHalf = (int) (_lo + ((_hi - _lo) / 2));	//sets the currentHalf to the value in between the _lo and the _hi
			}
			else {
				_data.add(currentHalf, newVal);	//this only happens if they are equal, so we can just slap it in that index
				return; 	//exit the loop
			}

		}
		//once hi is equal to _lo or less than _lo, it runs this code

		if (_hi == size())   //if its = to size, we can just add it,
			_data.add(newVal);
		else				//otherwise we just add it at the index _hi
			_data.add(_hi, newVal);

	}
  }


  public void add( Comparable newVal )
  { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }


  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();
    // testing linear search
    for( int i = 0; i < 15; i++ )
    	Franz.addBin( (int)( 50 * Math.random() ));
	System.out.println(Franz.size());


    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at index " + i + ": " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
  }//end main()

}//end class OrderedArrayList
