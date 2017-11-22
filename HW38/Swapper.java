//Wubin Peci
//APCS pd 1
//HW 38 ahhhhhhhh
//2017-11-21

//This lovely program will generate a 2-D array, which it will then print, and then afterwards allow the user to swap locations of different objects in the array
//It starts by asking the user to indicate the length and height of the array (rows and columns)
//next, it populates the array with random 3-length strings made up of letters of the alphabet, and then printing out the array
//then, it asks the user to indicate the locations of the values they want to switch
//finally, it performs the swap with the values given and prints out the newly modified array

import cs1.Keyboard;

public class Swapper {
	
	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; //constant for making random strings

	public void printArray(String[][] array) { 		//simple print array method - uses FOREACH to print each element with a space between
		
		System.out.println();		

		for (String[] a : array) {

			for (String s : a) {
				System.out.print(s + "\t");
			}
	
			System.out.println();		//inserts a new line between rows
		}

		System.out.println();
	}

	public void populateArray(String[][] array) {

		for (int i = 0; i < array.length; i++) {

			for (int n = 0; n < array[i].length; n++) {
				
				int random = (int)(Math.random() * 25) + 1; //picks random int from 1 - 26
				String randomString = ALPHABET.substring(random - 1, random);
				
				random = (int)(Math.random() * 25) + 1;
				randomString += ALPHABET.substring(random - 1, random);

				random = (int)(Math.random() * 25) + 1;
				randomString += ALPHABET.substring(random - 1, random); //keeps selecting a letter from the alphabet

				array[i][n] = randomString;		//set the current element of the array to that random string
			}
		}
	}

	public void swap(int[] positions, String[][] array) {

		int rows = array.length;	//rows = length of array of arrays
		int columns = array[0].length;	//columns = length of arrays inside the array

		String firstSwap = array[positions[0]][positions[1]];	//the array made in the main method 
																//stores the rows and columns
																//in this respective order, so we use that here
		String secondSwap = array[positions[2]][positions[3]];

		String[][] newArray = new String[rows][columns]; 		//init new empty array

		for (int i = 0; i < array.length; i++) {

			for (int n = 0; n < array[i].length; n++) {			//loop thru, checking if the positions match and if so
																//switching them
				if (i == positions[0] && n == positions[1] ) {
					newArray[i][n] = "*" + secondSwap + "*";		//asterisks allow to user to see which values have been changed

				} else if (i == positions[2] && n == positions[3]) {
					newArray[i][n] = "*" + firstSwap + "*";

				} else {
					newArray[i][n] = array[i][n];
				}
			}
		}

		printArray(newArray);	//printing the array at the end

	}

	public static void main(String[] args) {
		
		Swapper swap = new Swapper();
		Keyboard keyboard = new Keyboard();
		//make new instances of the classes necessary
		
		System.out.println("Let's make a 2-D array!");
		
		System.out.print("Rows: ");
		int rows = keyboard.readInt();
		//user inputs # of rows
		System.out.print("Columns: ");
		int columns = keyboard.readInt();
		//user inputs # of columns
		
		String[][] stringArray = new String[rows][columns];
		swap.populateArray(stringArray);
		//initialize new array with the rows and columns given, and then populate it with random strings

		swap.printArray(stringArray);

		System.out.println("Indicate the positions you would like swapped (note: this is using a ZERO based index!)");
		int[] test = new int[4]; 
		//prepare the array to store the positions

		System.out.print("Row: "); 
		test[0] = keyboard.readInt();
		//the row of the first string stored as the first element

		System.out.print("\nColumn: ");
		test[1] = keyboard.readInt();
		//the column of the first string stored as the second element

		System.out.print("\nRow: ");
		test[2] = keyboard.readInt();
		//the row of the second string stored as the third element

		System.out.print("\nColumn: ");
		test[3] = keyboard.readInt();
		//the column of the second string stored as the third element

		swap.swap(test, stringArray);
		//swap the values accordingly

	}



}
