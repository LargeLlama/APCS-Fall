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

  public void add(Comparable newVal)
  { 
		
  }



  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();
    // testing linear search
    for( int i = 0; i < 15; i++ )
	  Franz.add( (int)( 50 * Math.random() ));



    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
	Franz.remove(1);
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at index " + i + ": " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
  }//end main()

}//end class OrderedArrayList
