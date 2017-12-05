//WOOOOOOOooobin Peco
//APCS pd. 1
//hw46 - memes
//2017-12-4
//yeah

import java.util.ArrayList;

public class ALTester {
	
	public static void main(String[] args) {
	
		ArrayList<Comparable> meme = new ArrayList<Comparable>(); //init empty ArrayList called meme

		System.out.println(meme);
		
		for (int i = 0; i < 23; i ++ ) //add 0 into the ArrayList 23 times
			meme.add(0);				

		System.out.println(meme);

		for (int i = 0; i < meme.size(); i++) {
			meme.set(i, (int)(Math.random() * 5) + 1);
		}

		System.out.println(meme);

		//According to this, the list is not sorted when u print it - as I filled it with random ints from 1-5 and there was no order

		//Testing other methods of ArrayList!
		
		//testing get method, printing each element with its index
		for (int i = 0; i < meme.size(); i++) 
			System.out.println(i + ": " + meme.get(i));

		//testing remove

		meme.remove(9);
		System.out.println(meme);
		
		meme.add(9, 1500);
		System.out.println(meme);

	}		

}
