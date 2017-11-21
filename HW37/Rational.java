//Wubin Peci
//APCS Pd. 1
//HW37 - ok we're not rational enough we gotta crank it up to 11
//2017-11-20

public class Rational {

	private int numerator;
	private int denominator;

	public Rational() {
		numerator = 0;		//no parameters makes a default value of 0/1
		denominator = 1;
	}

	public Rational(int num, int denom) {

		if (denom == 0) {				//if the denominator is zero, it is not a real number
			
			numerator = 0;				//sets it to the default value of 0/1
			denominator = 1;
		
			System.out.println("Invalid denominator inputted! Set default value to 0/1"); //prints error message indicating what has happened
		} else {
			numerator = num;		//otherwise, sets them to the values given
			denominator = denom;		
		}

	}

	public String toString() {

		String num = "" + numerator;		//makes the numerator a string
		String denom = "" + denominator;	//makes the denominator a string

		return num + "/" + denom;			//puts a slash between the two to signify that they are a fraction

	}

	public double floatValue() {
		return (double)numerator/denominator;
	}

	public void multiply(Rational rationalNum) {

		this.numerator = this.numerator * rationalNum.numerator;		//takes the numerator of this rational number and sets it = to the product
		this.denominator = this.denominator * rationalNum.denominator;	//takes the denominator of this rational number and sets it = to the product

	}

	public void divide(Rational rationalNum) {
		
		if ( rationalNum.denominator != 0) {

			this.numerator = this.numerator * rationalNum.denominator;
			this.denominator = this.denominator * rationalNum.numerator;

		} else {

			System.out.println("Divide by zero error. Computation not carried out");

		}
		
	}
//==========Added 11/20=================
	

	public static int gcd ( int a, int b){ // Does a recursive algorithm of GCD

        if (a % b == 0) 
			return b;
        
		return gcd( b, a % b);

	}
	//Takes 1 Rational object (just like multiply) and adds it to the current rational number object
	//Need not reduce
	public void add ( Rational rational ) {

		if (this.denominator == rational.denominator) {

			this.numerator = this.numerator + rational.numerator;	//if they have the same denominator, then just subract the numerators

		} else {

			int oldDenom = this.denominator;	//store the value of this.denominator in a variable, as this.denominator will be modified

			this.numerator = rational.denominator * this.numerator;	//multiply the numerator by the denominator of the parameter
			this.denominator = rational.denominator * this.denominator;	//multiply the denominator by the denominator of the parameter
	
			int newNumer = rational.numerator * oldDenom;	//multiply the parameter's numerator by the original denominator
			//this whole proccess above is to make them have the same denominator, so I can just subtract the numerator in the next step
			
			this.numerator = newNumer + this.numerator;		
		}
		 		
	}

	//Takes 1 Rational object and subtracts it from the current rational number object
	//Need not reduce
	public void subtract( Rational rational ) {

		if (this.denominator == rational.denominator) {

			this.numerator = this.numerator - rational.numerator;

		} else {

			int oldDenom = this.denominator;

			this.numerator = rational.denominator * this.numerator;
			this.denominator = rational.denominator * this.denominator;
	
			int newNumer = rational.numerator * oldDenom;

			this.numerator = this.numerator - newNumer;
		}
	}
	//uses exact same logic as the add() method, but subtracts the newNumer from this.numerator instead of adding :)

	public void reduce() {

		int factor = gcd(numerator, denominator);	//the factor to divide by is the gcd of the numerator and the denominator

		numerator = numerator / factor;
		denominator = denominator / factor;

	}

	public int compareTo ( Rational rational ) {

		this.subtract(rational);	//subtract the two rational numbers
		
		//checks if the testNum variable is negative or not, and returns the appropriate int
		if (this.numerator == 0) { 		//if it is = 0, then the numbers must be the same

			this.add(rational);			//adds the parameter so the value of the ration doesn't change
			return 0;

		} else if (this.numerator > 0) { //if it is greater than zero, then the parameter must be less than the original
		
			 this.add(rational);			//adds the parameter so the value of the ration doesn't change
			 return 1;

		} else {		//the final case, the paramter is greater than the original
			 
			 this.add(rational);			//adds the parameter so the value of the ration doesn't change
			 return -1;

		}

	}

	public static void main(String[] args) {	//need main method to test functions!

	//Making sure default and overloaded constructor work
	
	Rational defaultNum = new Rational();				//calls default constructor
	System.out.println("defaultNum: " + defaultNum);	//should print out 0/1

	Rational divideByZero = new Rational(9, 0);				//calls overloaded constructor, but denominator is zero
	System.out.println("divideByZero: " + divideByZero);	//should print out 0/1
	
	//Testing first value of 2/3	
	
	Rational r = new Rational(2,3); //Stores rational number 2/3
	System.out.println("r: " + r);
	System.out.println("floating point approx.: " + r.floatValue());

	//Testing second value of 1/2
	
	Rational s = new Rational(1,2); //Stores rational number 1/2
	System.out.println("s: " + s);
	System.out.println("floating point approx. : " + s.floatValue());
	
	//Testing multiply function
	
	System.out.println("now performing r * s, only r should be modified");

	r.multiply(s); 									//Multiplies r by s 
	System.out.println("r: " + r + "\ns: " + s);	//r should be 2/6, s remains 1/2

	System.out.println("now performing r / s, only r should be modified");

	r.divide(s);									//Divides r by s
	System.out.println("r: " + r + "\ns: " + s);	//r should be 4/6, s remains 1/2

	r.reduce();
	System.out.println("reducing r\n" + r);

	Rational t = new Rational(1,3);
	s.add(t);
	System.out.println("s + 1/3 = " + s);

	Rational n = new Rational(1,5);
	s.subtract(n);
	System.out.println("s - 1/5 = " + s);


	System.out.println("\n===========KEY===========\n1 - greater than\n0 - equal to\n-1 - less than\n");
	System.out.println("s = " + s + "\n");

	Rational x = new Rational(19,30);
	System.out.println("is s = 19 / 30?\n" + s.compareTo(x) + "\n");

	x = new Rational(18,30);
	System.out.println("is s > 18 / 30?\n" + s.compareTo(x) + "\n");

	x = new Rational(20,30);
	System.out.println("is s > 20/30?\n" + s.compareTo(x) + "\n");

	}
}
