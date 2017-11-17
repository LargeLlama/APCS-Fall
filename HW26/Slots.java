/************************************** class Slots
 * simulates a slot machine in your very own terminal
 * Rubin Peci
 * APCS-1 pd01
 * HW26 -- Shmoney dance
 * ************FREE BOBBY****************
 * 2017-11-03
 *****************************************************/

public class Slots
{

  private static final String[] FRUITS = {
    "lime", "lime", "lime", 
    "lemon", "lemon", "lemon", 
    "cherry", "cherry", "cherry", 
    "orange", "orange", "orange", 
    "grapefruit", "grapefruit", "grapefruit", 
    "tangerine", "tangerine", "tangerine", 
    "ugli", "ugli", "ugli",
    "peach", "peach", "peach"
  };
  
  private String[] _fruits; //to be init'd by each instance


  /*=====================================
    Slots() -- default constructor
    pre:  constant array FRUITS exists, has been initialized
    post: mutable array _fruits contains same elements as FRUITS
    =====================================*/
  public Slots()
  {
    //allocate memory for _fruits based on size of FRUITS:
    /* YOUR IMPLEMENTATION HERE */
    //copy elements of FRUITS into _fruits:

	_fruits = new String[FRUITS.length];		//make it have the same length as FRUITS
	
	for (int i = 0; i < FRUITS.length; i++) {	//loop through it to make each element identical, without having the occupy the same space in memory
		_fruits[i] = FRUITS[i];
	}

  }


  /*=====================================
    String toString() -- overrides inherited toString()
    pre:  
    post: returns String of elements in slots 0 thru 2, separated by tabs
    =====================================*/
  public String toString()
  {
	String retStr = "";					 //set up our empty retStr variab;e

	for (int i = 0; i < 3; i++) {		 //does this 3 times
		if (i == 0) 					 //if its the first time running through, it doesn't add a tab
			retStr +=  _fruits[i];
		else
			retStr += "\t" + _fruits[i]; //otherwise we add the tab before the element
	}	

	return retStr;						//return the retStr

  }


  /*=====================================
    void swap(int,int) -- array swap util fxn
    pre:  _fruits array exists
    post: elements at indices i, j are swapped
    =====================================*/
  private void swap( int i, int j )
  {

	String element0 = _fruits[i];		//Have variables hold the value of each string at the specified index
	String element1 = _fruits[j];

	_fruits[i] = element1;				//swap them
	_fruits[j] = element0;

  }



  /*=====================================
    void spinOnce() -- simulate a pull of the slot machine lever
    pre:  _fruits array exists
    post: randomized order of elements in _fruits array
    =====================================*/
  public void spinOnce()
  {
	swap(0, (int)Math.ceil(Math.random() * FRUITS.length - 1));		//run the swap function on the first 3 slots with 3 random slots in the array
	swap(1, (int)Math.ceil(Math.random() * FRUITS.length - 1));		//type casting is necessary here to prevent a loss of precision
	swap(2, (int)Math.ceil(Math.random() * FRUITS.length - 1));		//end result is a random number in between 0 and the length of the array FRUITS


  }


  /*=====================================
    boolean jackpot() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    false otherwise
    =====================================*/
  public boolean jackpot()
  {
    return _fruits[0].equals(_fruits[1]) && _fruits[0].equals(_fruits[2]);	//returns if the first 3 elements are the same or not
  }


  /*=====================================
    boolean miniWin() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    or if first 3 slots mutually distinct, 
    false otherwise
    =====================================*/
  public boolean miniWin()
  {
    boolean distinct = !_fruits[0].equals(_fruits[1]) && !_fruits[0].equals(_fruits[2]);	//boolean stores whether each value is distinct
	boolean combo = _fruits[0].equals(_fruits[1]) && _fruits[0].equals(_fruits[2]); 		//boolean stores whether each value is the same
	
	return distinct || combo;	//returns true when at least one of these is true
  }


  //main() method for testing
  public static void main( String[] args )
  {
    //usage: move bar below down 1 line at a time to test functionality...
      Slots machine01 = new Slots();
      Slots machine02 = new Slots();
 
      //test to verify slot machines function indepently
      System.out.println();
      System.out.println( "Machine01 initial state:\t" + machine01 );
      System.out.println( "Machine02 initial state:\t" + machine02 );
	

      System.out.println( "\nSpinning machine01...\n" );

      machine01.spinOnce();

      System.out.println();
      System.out.println( "Machine01 state:\t" + machine01 );
      System.out.println( "Machine02 state:\t" + machine02 );
      System.out.println();

	
      //test gamble-until-you-win mechanism

      System.out.println( "Preparing to spin until a mini win! . . ." );
      System.out.println( "------------------------------------" );

      //if you haven't won, spin again until you win!
      while( machine01.miniWin() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
      }

      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "WIN\n" );



      System.out.println( "Preparing to spin until...jackpot! . . ." );
      System.out.println( "------------------------------------" );

      //if you haven't won, spin again until you win!
      while( machine01.jackpot() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
      }

      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "JACKPOT!\n" );
  }//end main

}//end class Slots
