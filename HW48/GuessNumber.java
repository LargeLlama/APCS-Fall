//WOOOOOOOObin Peco
//APCS pd1
//HW48 - number thing haha
//2017-12-06
//yeah

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

//possible additions(?)
//make them guess it in a certain number of tries
//make the upper bound and lower bound different

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
		_guessCtr = 1;
		_hi = b;
		_lo = a;
		_target = (int)(Math.random() * (_hi - 1)) + _lo;
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  exist
      post: continue existing
      ==================================================*/
    public void playRec() 
    {
		System.out.print("Guess a number from like " + _lo + "-" + _hi + ": "); //always going to be from _lo to _hi

		int input = Keyboard.readInt();	//take user input

			
		if (input == _target) {	//base case, stop if they guess right

			System.out.println("\nYou are a LEGEND. I don't know how you did it, but you managed to guess my number!");	//inform them of their feat
			
			if (_guessCtr > 1)	//print out the gramatically correct number of tries
				System.out.println("It only took " + _guessCtr + " tries!");	
			else
				System.out.println("It only took " + _guessCtr + " try!");	

		}else if (input > _target) {	//if the input is too high

			_guessCtr += 1;	//add one to the guess ctr
			System.out.println("Take it easy, thats too high! Try again partner\n");	//let em what they did

			//this prevents them from entering soemthing higher than 100 and confusing themselves
			if (input > 100)
				_hi = 100;
			else
				_hi = input;
			
			playRec();

		}else {

			_guessCtr += 1;		//add one to the counter for guesses
			System.out.println("A bit too small for my liking, your guess was too low! Try again bucko\n"); //inform them of their mistake

			//make sure input isn't too low 
			//also, readInt() auto returns the lowest int value if u insert something incorrect, so this prevents that 
			//from getting in the way as well
			if (input < 1) 
				_lo = 1;
			else
				_lo = input;

			playRec();	//call playRec() again with the updated _lo and _hi values

		} 

    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
		System.out.print("Guess a number from like " + _lo + "-" + _hi + ": "); //always going to be from _lo to _hi

		int input = Keyboard.readInt();
		
		while (input != _target) {	//as long as what they put in isn't the right answer, it will keep looping

			_guessCtr += 1;	//add one to the guessCtr each iteration
			
			if (input > _target) {

				System.out.println("Take it easy, thats too high! Try again partner\n");

				if (input > 100)
					_hi = 100;
				else
					_hi = input;

			} else {

						
				System.out.println("A bit too small for my liking, your guess was too low! Try again bucko\n");

				if (input < 1) 
					_lo = 1;
				else
					_lo = input;

			}
	
			System.out.print("Guess a number from like " + _lo + "-" + _hi + ": ");

			input = Keyboard.readInt();

		}
		//above is copy-paste from recursive method, as it works here just in the while loop

		System.out.println("\nYou are a LEGEND. I don't know how you did it, but you managed to guess my number!");	//inform them of their feat
			
		if (_guessCtr > 1)	//print out the gramatically correct number of tries
			System.out.println("It only took " + _guessCtr + " tries!");	
		else
			System.out.println("It only took " + _guessCtr + " try!");	

    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
		//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();

    }//end main

}//end class
