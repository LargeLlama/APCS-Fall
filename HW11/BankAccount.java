// Team: Supernova
// Roster: Aidan Griffin, Woosuk Lee, Sophia Xia
// APCS1 pd1
// HW10 -- Mo Money Mo Problems 
// 2017-10-03

public class BankAccount
{
    //instance variables
    private String name;
    private static String passwd;
    private int pin;
    private static int acctNum;
    private double balance;
 /* default constructor: initializes instance vars to default vals
       precondition:  none
       postcondition: instance vars have appropriate default vals
       ````````````````````````````````````````````````````*/
    public BankAccount() {
		name = "John Doe";
		passwd = "password";
		pin = 1234;
		acctNum = 123456789;
		balance = 0.0;
    }


    /* overloaded constructor: allows caller to specify account 
                               number and passwd. Assigns defaults
                               to other instance vars.
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( int newAcctNum, String newPass ) {
    	name = "John Doe";
		passwd = newPass;
		pin = 1234;
		acctNum = newAcctNum;
		balance = 0.0;
    }
    /* overloaded constructor: allows caller to specify instance vars
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( String newName, String newPass, 
			double newBal, int newAcctNum, int newPin ) {
		name = newName;
		passwd = newPass;
		pin = newPin;
		balance = newBal;
		acctNum = newAcctNum;
	}

    //mutators
    public String setName( String newName )
    {
	String oldName = name;
	name = newName;
	return oldName;
    }

    public String setPasswd( String newPasswd )
    {
	String oldPasswd = passwd;
	passwd = newPasswd;
	return oldPasswd;
    }

    public int setPin( int newPin )
    {
	int oldPin = pin;
	if((1000 <= newPin)&&(newPin <= 9998 )){
	    pin = newPin;
	}
	else{
	    pin = 9999;
	    System.out.println("Please enter a valid 4-digit PIN. Your PIN number cannot start with a 0.");
	}
	return oldPin;
    }

    public int setAcctNum( int newAcctNum )
    {
	int oldAcctNum = acctNum;
	if(( 100000000 <= newAcctNum) && (newAcctNum <= 999999998)){
	    acctNum = newAcctNum;
	}
	else {
	    acctNum = 999999999;
	    System.out.println("Please enter a valid 9-digit number. Your account number cannot start with a 0.");
	}
	return oldAcctNum;
    }

    public double setBalance( double newBalance )
    {
	double oldBalance = balance;
	balance = newBalance;
	return oldBalance;
    }

    public void deposit( double depositAmount ) {
	balance = balance + depositAmount;
    }

    public void withdraw( double withdrawAmount){
	if( withdrawAmount >= balance ){
	    System.out.println("Not enough balance. Please try again.");
	}
	else {
	    balance -= withdrawAmount;
	}
    }


    //overwritten toString()
    public String toString() {
	String retStr = "\nAccount info:\n=======================";
	retStr = retStr + "\nName: " + name;
	retStr = retStr + "\nPassword: " + passwd;
	retStr = retStr + "\nPIN: " + pin;
	retStr = retStr + "\nAccount Number: " + acctNum;
	retStr = retStr + "\nBalance: " + balance;
	retStr = retStr + "\n=======================";
	return retStr;
    }

 public static boolean authenticate ( int enteredacctNum, String enteredpasswd)
    {
	if ((enteredacctNum == acctNum)&&(enteredpasswd == passwd)){
	    return true;
	}
	else{
	    System.out.println("Your account number or password is incorrect. Please try again");
	    return false;
	}
    }
    //main method for testing
    public static void main( String[] args )
    {
		// INSERT YOUR METHOD CALLS FOR TESTING HERE
    }//end main()
}//end class BankAccount
