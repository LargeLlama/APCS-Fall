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
	
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";

	public void printArray(String[][] array) { 		//simple print array method - uses FOREACH to print each element with a space between

		int rows = 0;				//numbers the rows
		System.out.println();		

		for (int i = 0; i < array[0].length; i++) {
			System.out.print("\t" + ANSI_GREEN + i + ANSI_RESET);
		}
		System.out.println();

		for (String[] a : array) {
			System.out.print(ANSI_GREEN + rows + ANSI_RESET);
			rows ++;
			for (String s : a) {
				System.out.print("\t" + s);
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

	public String[][] swap(int[] positions, String[][] array) {

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
					newArray[i][n] = ANSI_RED + secondSwap + ANSI_RESET;		//red text allow to user to see which values have been changed

				} else if (i == positions[2] && n == positions[3]) {
					newArray[i][n] = ANSI_RED + firstSwap + ANSI_RESET;

				} else {
					newArray[i][n] = array[i][n];
				}
			}
		}

		printArray(newArray);	//printing the array at the end
		return newArray;
	}

	public int[] position(String[][] array) {

		System.out.println("Indicate the positions you would like swapped (note: this is using a ZERO based index!)");
		int[] test = new int[4]; 
		//prepare the array to store the positions

		System.out.print("Row: "); 
		test[0] = Keyboard.readInt();
		//the row of the first string stored as the first element
		while (test[0] > (array.length) || test[0] < 0) {

			System.out.println("Number out of range, try again!");
			test[0] = Keyboard.readInt();

		}

		System.out.print("\nColumn: ");
		test[1] = Keyboard.readInt();
		//the column of the first string stored as the second element
		while (test[1] > (array[0].length) || test[1] < 0) {

			System.out.println("Number out of range, try again!");
			test[1] = Keyboard.readInt();

		}

		System.out.print("\nRow: ");
		test[2] = Keyboard.readInt();
		//the row of the second string stored as the third element
		while (test[2] > (array.length) || test[2] < 0) {

			System.out.println("Number out of range, try again!");
			test[2] = Keyboard.readInt();

		}

		System.out.print("\nColumn: ");
		test[3] = Keyboard.readInt();
		//the column of the second string stored as the third element
		while (test[3] > (array[0].length) || test[3] < 0) {

			System.out.println("Number out of range, try again!");
			test[3] = Keyboard.readInt();

		}


		return test;


	}

	public static void main(String[] args) {
	
		Swapper swapper = new Swapper();
		//make new instances of the classes necessary
		
		System.out.println("Let's make a 2-D array!");
	
		System.out.print("Rows: ");
		int rows = Keyboard.readInt();
		//user inputs # of rows
		System.out.print("Columns: ");
		int columns = Keyboard.readInt();
		//user inputs # of columns
		
		String[][] stringArray = new String[rows][columns];
		swapper.populateArray(stringArray);
		//initialize new array with the rows and columns given, and then populate it with random strings
		//
		while (true) {

			swapper.printArray(stringArray);
			
			int[] positions = swapper.position(stringArray);

			stringArray = swapper.swap(positions, stringArray);
			//swap the values accordingly
			
			System.out.println("What else would you like to do?");
			System.out.println("1: Swap the same array");
			System.out.println("2: Generate a new array");
			System.out.println("3: Exit");

			int choice = Keyboard.readInt();
			while (choice < 0 || choice > 3) {
				System.out.println("Invalid input! Try again!");
				choice = Keyboard.readInt();
			}

			if (choice == 1) {
				System.out.println("Here we go again!");
			} else if (choice == 2) {
				main(args);
			} else if (choice == 3) {
				break;
			}
		}
		
		System.out.println("Have a good day!");

	}



}
