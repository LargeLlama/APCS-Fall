/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix( ) 
  {
	  matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a ) 
  {
	  matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size() 
  {
	  int size = 0;	//init size variable

	  for (int i = 0; i < matrix.length; i++) {	//loops thru each row
		  size += 1;
	  }

	  return size; 
  }


  //return the item at the specified row & column   
  private Object get( int r, int c ) 
  {
	  return matrix[r][c];
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty() 
  {
	  return this.size() == 0;	//if the size of this matrix is 0, then its empty, otherwise it is not
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal ) 
  {
	  Object temp = matrix[r][c];	//store temp value
	
	  matrix[r][c] = newVal;	//set the element to the new value

	  return temp;	//return old value
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() 
  {
	  String returnString = "";	//init returnString

	  for (int i = 0; i < matrix.length; i++) {
		  returnString += "| ";		//add a | at the beginning of each row

		  for (int n = 0; n < matrix[i].length; n++) {
			  returnString += matrix[i][n] + " ";	//add each element and a space
		  }
		
		  returnString += "|\n";		//add a | and a newline at the end of each row
	  }

	  return returnString;	//return the string
  }


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide ) 
  {
	  boolean equal = false;	//set initial boolean to false

	  if (rightSide instanceof Matrix) {
		  
		  Matrix meme = (Matrix) rightSide;

		  equal = this.size() == meme.size();	//if they are the same size, then go through looping, otherwise there is no point
		  
		  if (equal) {
			  for (int i = 0; i < matrix.length; i ++) {
				  for (int n = 0; n < matrix[i].length; n++) {
					  if (this.get(i,n) != meme.get(i,n))	//if, at any point, two elements aren't equal, just reutnr false
						  return false;
				  }
			  }
		  }
	  }

	  return equal;	//if we made it here, they either weren't the same size or they are equal, and equal represents
	  				//the correct value in either case
  }


  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
	  for (int i = 0; i < this.size(); i++) {	//loop thru each row
		  Object temp = matrix[i][c1 - 1];		//store temp
		  matrix[i][c1 - 1] = matrix[i][c2 -1];	//swap first value
		  matrix[i][c2 - 1] = temp;	//set other value to temp
	  }
  }


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) 
  {
	  Object[] temp = matrix[r2 - 1];	//row is just an array, so its a simple swap with no loop needed
	  matrix[r2 - 1] = matrix[r1 - 1];
	  matrix[r1 - 1] = temp;
  }

  //====HELPER FUNCTION TO POPULATE MATRIX WITH RANDOM INTS====
  public static void populate(Matrix meme) {
	  for (int i = 0; i < meme.size(); i ++) {
		  for (int n = 0; n < meme.size(); n++) {
			  meme.set(i,n, (int)(Math.random() * 10));
		  }
	  }
  }

  //main method for testing
  public static void main( String[] args ) 
  {

	Matrix meme = new Matrix();
	
	System.out.println("STATS FOR Matrix meme");
	System.out.println("size: " + meme.size());
	System.out.println(meme);

	Matrix test = new Matrix();
	System.out.println("Stats for Matrix test");
	System.out.println("size: " + test.size());
	System.out.println(test);

	System.out.println("TESTING EQUALS METHOD\nmeme =? test: " + meme.equals(test) + "\n");

	Matrix jack = new Matrix(3);
	populate(jack);
	System.out.println("Stats for Matrix jack");
	System.out.println("size: " + jack.size());
	System.out.println(jack);
	System.out.println("jack =? test: " + jack.equals(test));

	Matrix alex = new Matrix(3);
	populate(alex);
	System.out.println("\nStats for Matrix alex");
	System.out.println("size: " + alex.size());
	System.out.println(alex);
	System.out.println("alex =? jack: " + jack.equals(alex));
	
	System.out.println("\nTesting SWAP COLUMNS");
	System.out.println("Swapping column 1 with column 3 in jack");
	jack.swapColumns(1,3);
	System.out.println(jack);

	System.out.println("\nTesting SWAP ROWS");
	System.out.println("Swapping row 1 with row 2 in jack");
	jack.swapRows(1,2);
	System.out.println(jack);


  }

}//end class Matrix
