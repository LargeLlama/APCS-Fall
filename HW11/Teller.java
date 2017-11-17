// Honk Honk Radish - Selina Z., Rubin P., Taaseen A.
// APCS PD.1
// HW11 - Breaking the Bank (testing the bank?)
// 2017-10-04
public class Teller {
	
	public static void main(String[] args) {
		BankAccount test = new BankAccount();
    	System.out.println(test);
   
    	test.setName("Lil Pump");
    	System.out.println("\nChanging Name! \n" + test);
   
    	test.setPasswd("password");
    	System.out.println("\nChanging Password! \n" + test);

    	test.setPin(9913);
    	System.out.println("\nChanging PIN! \n" + test);

    	test.setAcctNum(901381763);
    	System.out.println("\nChanging Account Number! \n" + test);

    	test.setBalance(300.00);
    	System.out.println("\nSetting the balance! \n" + test); 

    	test.deposit(-10.0);
    	test.deposit(10.0);
    	System.out.println("\nDepositing $10 \n" + test);

    	test.withdraw(1000);
    	test.withdraw(100);
    	System.out.println("\nWithdrawing $100 \n" + test);
		
      	//The above code is just what our group used before to test our methods - now we will test the constructors we have written

		test = new BankAccount();
		// remake the object using the default constructor

		System.out.println("\nTesting default constructor\n" + test);
		// Should yield the same result as it did in the previous test cases

		BankAccount test1 = new BankAccount(183173109,"safepassword");
		System.out.println("\nTesting overloaded constructor \n"+ test1);
		System.out.println("\nTesting if test1 == test \n" + test1.equals(test));
 		//Above code tests the overloaded constructor for the BankAccount class, and it also tests if it is equal to the other object we made previously	

		BankAccount test2 = new BankAccount("Lil Uzi Vert", "saferpassword", 100.00, 123123123, 9087);
		System.out.println("\nTesting overloaded constructor \n" + test2);
		System.out.println("\nTesting if test2 == test \n" + test2.equals(test));
		System.out.println("\nTesting if test2 == test1 \n" + test2.equals(test1));
		//Above tests another overloaded constructor that sets ALL the initialized variables - and here we compare to the test and test1 object we previously made
	}
}
