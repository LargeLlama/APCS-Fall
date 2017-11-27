/*class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
	_data = new int[10];   
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
	String retString  = "[";

	for (int n : _data) {
		retString += n + ", ";
	}

	retString = retString.substring(0, retString.length() - 2);
	retString += "]";

	return retString;
  }


  //double capacity of SuperArray
  private void expand()
  {
	int[] newArray = new int[_data.length * 2];

	for (int i = 0; i < _data.length; i++) {
		newArray[i] = _data[i];
	}
	
	_data = newArray;
	
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
	return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
	int oldVal = _data[index];

	_data[index] = newVal;

	return oldVal;    
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "\nPrinting empty SuperArray curtis..." );
      System.out.println( curtis );
  
      for( int i = 0; i < curtis._data.length; i++ ) {
	      curtis.set( i, i * 2 );
      }

      System.out.println("\nPrinting populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
    	 curtis.expand();
     	 System.out.println("\nPrinting expanded SuperArray curtis...");
      	 System.out.println(curtis);
      }

  }//end main()


}//end class
