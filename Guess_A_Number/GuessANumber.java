//
//
//
//

import cs1.Keyboard;

public class GuessANumber {

	private int _guesses;
	private int _upperBound;
	private int _lowerBound;
	private int _answer;

	public GuessANumber() {
		_guesses = 0;
		_upperBound = 100;
		_lowerBound = 1;
		_answer = (int)(Math.random() * 99) + 1;
	}

	public int evaluateGuess(int guess) {
		return guess - _answer;
	}

	public void takeGuess() {

	}  

}
