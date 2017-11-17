/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

// Wubin Peci
// APCS1 pd1
// HW34 -- 2D arrays
// 2017-11-17

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
	  for (int i = 0; i < a.length; i++) { 			//iterate over each array

		  for (int n = 0; n < a[i].length; n++) {	//iterate over the contents pf each individual array
			  System.out.print(a[i][n] + " ");		//print out the number with a space in between each one
		  }

		  System.out.println();						//add a new line after each "row" (individual array) is looped through
	  }
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
	  for ( int[] array : a) {						//same concept but with a for each loop

		  for ( int i : array ) {
			  System.out.print(i + " ");
		  }

		  System.out.println();
	  }
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
	  int sum = 0;									//initiate variable to hold value of sum 

	  for (int i = 0; i < a.length; i++) {			//iterate over each array

		  for (int n = 0; n < a[i].length; n++) {	//iterate over the contents of each array
			  sum += a[i][n];						//add each value to the sum variable
		  }

	  }

	  return sum;									//return said sum variable
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
	  int sum = 0;							//initialize variable to hold/track sum so far
	
	  for (int i = 0; i < m.length; i++) { 	//loop through the arrays

		  sum += sumRow1(i, m);				//procure the sum of each row, and add it to the sum variable

	  }

	  return sum;							//return the sum
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow1( int r, int[][] a )
  {
	  int sum = 0;								//initialize variable to store sum of a row

	  for ( int i = 0; i < a[r].length; i++) {	//loop through the specific "row" (array) given

			sum += a[r][i];						//add each value to our sum variable

	  }

	  return sum;								//return the sum variable
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)	//same concept as above but with FOREACH loop
  {
	  int sum = 0;

	  for ( int i : m[r]) {

		  sum += i;

	  }

	  return sum;
  }



  public static void main( String [] args )
  {
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };

	  //TESTING PRINT1
 	  System.out.println("=====TESTING PRINT1=====");

	  System.out.println("\nm1:");
      print1(m1);

	  System.out.println("\nm2:");
      print1(m2);

	  System.out.println("\nm3:");
      print1(m3);

	  //TESTING PRINT2      
	  System.out.println("=====TESTING PRINT2=====");

	  System.out.println("\nm1:");
	  print2(m1);

      System.out.println("\nm2:");
	  print2(m2);
	  
	  System.out.println("\nm3:");
      print2(m3);

	  //TESTING SUM1
      System.out.println("==========testing sum1========\n");

      System.out.println("sum m1 : " + sum1(m1));			//return 0
      System.out.println("sum m2 : " + sum1(m2));			//return 27
      System.out.println("sum m3 : " + sum1(m3) + "\n");	//return 21

	  //TESTING SUM2
      System.out.println("========testing sum2==========\n");

      System.out.println("sum m1 : " + sum2(m1)); 			//return 0
      System.out.println("sum m2 : " + sum2(m2)); 			//return 27
      System.out.println("sum m3 : " + sum2(m3) + "\n");	//return 21


	  System.out.println("=========testing sumRow1========");

	  
	  System.out.println("\nsumRow1 m1 row 3 : " + sumRow1(3, m1)); 	//return 0

	  System.out.println("\nsumRow1 m2 row 0 : " + sumRow1(0, m2));	//return 12
	  System.out.println("sumRow1 m2 row 1 : " + sumRow1(1, m2));	//return 15

	  System.out.println("\nsumRow1 m3 row 0 : " + sumRow1(0, m3));	//return 2
	  System.out.println("sumRow1 m3 row 1 : " + sumRow1(1, m3));	//return 10
	  System.out.println("sumRow1 m3 row 2 : " + sumRow1(2, m3));	//return 9

	  //TESTING SUMROW2
	  System.out.println("\n=========testing sumRow2========");

	  
	  System.out.println("\nsumRow2 m1 row 3 : " + sumRow2(3, m1)); 	//return 0

	  System.out.println("\nsumRow2 m2 row 0 : " + sumRow2(0, m2));	//return 12
	  System.out.println("sumRow2 m2 row 1 : " + sumRow2(1, m2));	//return 15

	  System.out.println("\nsumRow2 m3 row 0 : " + sumRow2(0, m3));	//return 2
	  System.out.println("sumRow2 m3 row 1 : " + sumRow2(1, m3));	//return 10
	  System.out.println("sumRow2 m3 row 2 : " + sumRow2(2, m3));	//return 9

  }

}//end class TwoDimArray
