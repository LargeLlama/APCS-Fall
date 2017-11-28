//Wubin Peci
//APCS pd 1
//HW41 - array of steel (ha i get it cuz man of steel is a reference to superman, and this is a class called superarray haha)
//2017-11-27
//yeah

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
	_data = new int[10];   //new array of 10 elements
	_size = 10;		// sets the size to 10
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
	String retString  = "[";	//inits the retStr and makes it have the opening bracket of an array

	for (int n : _data) {
		retString += n + ", ";	//puts each element with a comma in between
	}

	retString = retString.substring(0, retString.length() - 2); //cuts the last 2 elements because they are just extra commas
	retString += "]";	//adds the closing brace

	return retString;	//returns the return string
  }


  //double capacity of SuperArray
  private void expand()
  {
	int[] newArray = new int[_data.length * 2];	//makes a new array whose length is twice the size of the original

	for (int i = 0; i < _data.length; i++) {	//copies each element over
		newArray[i] = _data[i];
	}
	
	_data = newArray;	//sets data equal to the new array
	_size = _size * 2;	//sets the size equal to 2x its old value
	
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
	return _data[index];	//self-explanatory
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
	int oldVal = _data[index];	//saves the old value in a variable
	
	_data[index] = newVal;		//replaces the old value in the arrya with the new one

	return oldVal;    	//returns the oldValue character
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

	  System.out.println("\nTesting get method");
	  
	  for (int i = 0; i < curtis._size; i++) {
		  System.out.print(curtis.get(i) + " ");
	  }
	  System.out.println();



  }//end main()


}//end class
