// Rubin Peci
// APCS Pd.1
// HW15 Wayne's World
// 2017-10-11

import java.util.Random;

public class Coin {
	private double value;
	// Worth of coin

	private String upFace;
	// Heads or Tails showing up currently

	private String name;
	// "penny","nickel", etc.

	private int flipCtr;
	// # of times coin has been flipped

	private int headsCtr;
	// # of times landed heads

	private int tailsCtr;
	// # of times landed tails

	private double bias;
	// likelihood of landing heads-up everytime (1.0) or tails-up everytime (0.0)
	// Basically a percentage
	private String objName;  // the name of the coin object - used in some methods in Driver.java
	
	public Coin() {
		setUpFace("heads");
		setFlipCtr(0);
		setHeadsCtr(0);
		setTailsCtr(0);
		setBias(.5);
	}
	// Set counter values to zero, bias to .5, and the upFace to heads
	// the name is not specified so it will return "null" when printing
	
	public Coin(String name) {
		this();
		// Use of this() removes need to copy and paste everything from the constructor above it - save space and time
		setName(name);
	}
	
	public Coin(String name, String objName) {
		this(name);
		setObjName(objName);
	}

	public Coin(String name, String objName, String face) {
		this(name, objName);
		// Same concept with the other use of this() - except this one takes advantage of the 1st overloaded constructor
		setUpFace(face);
	}

	public String flip() {
		Random rand = new Random();
		double choice = rand.nextDouble();
		// implementation of the random class - it automatically picks a number between 0.0 and 1.0
		// Which is exactly what we want our range to be

		if (choice <= bias) {
			// the higher that bias is, the more likely heads will be picked, and this reflects that - at .5 there is no bias
			setUpFace("heads");
			setHeadsCtr(headsCtr + 1);

		}else {
			// otherwise, it it greater than our "bias" and overcame the odds and is now tails
			setUpFace("tails");
			setTailsCtr(tailsCtr + 1);
		}
	
		setFlipCtr(flipCtr + 1);
		// outcome never matters, as long as the flip is completed it is set

		return upFace;	
		// return the new value of upFace
	}


	// Value Getters I forgot the name for these methods hehe xd
	
	public double getValue() {
		return value;
	}

	public String getUpFace() {
		return upFace;
	}

	public String getName() {
		return name;
	}
	
	public int getFlipCtr() {
		return flipCtr;
	}

	public int getHeadsCtr() {
		return headsCtr;
	}

	public int getTailsCtr() {
		return tailsCtr;
	}
	
	public double getBias() {
		return bias;
	}

	public String getObjName() {
		return objName;
	}
	// Mutators - used instead of directly changing the variables in the constructors - names are self explanatory
	

	public void setUpFace(String status) {
		upFace = status;
	}	

	public void setName(String coinName) {
		name = coinName;
	}

	public void setFlipCtr(int count) {
		flipCtr = count;
	}

	public void setHeadsCtr(int count) {
		headsCtr = count;
	}

	public void setTailsCtr(int count) {
		tailsCtr = count;
	}

	public void setBias(double percent) {
		if (percent >= 0.0 || percent <= 1.0) {
			bias = percent;
		// need to make sure that the number given is valid

		} else {
			bias = .5;
			System.out.println("Invalid input, set bias to default value of .5!");
		// otherwise it just sets the bias to .5, which means there is no favoring one side
		}
	}

	public void setValue() {
		if (name == "penny") {
			value = .01;
		}else if (name == "nickel") {
			value = .05;
		}else if (name == "dime") {
			value = .10;
		}else if (name == "quarter") {
			value = .25;
		}else if (name == "half-dollar") {
			value = .50;
		}else if (name == "dollar") {
			value = 1.0;
		}
		// self explanatory - set the value based on the name it is - listed all the coins i know of
	}

	public void setObjName(String name) {
		objName = name;
	}

	//OVERWRITTEN METHODS

	public String toString() {
		String returnStatement = name + " -- " + upFace;

		return returnStatement;
	}
	// toString() must print out the name and the face of the coin - this reflects that
	// set it equal to a variable so i can easily modify it in the future if more information is needed to be added

	public boolean equals(Coin coin) {
		return coin.upFace == this.upFace;
	}
	// Had to do a bit of testing. I previously set the paramters to take in an object
	// but that returned an error when I tried to call upon the upFace variable in that parameter
}
