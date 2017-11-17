//Rubin Peci
//APCS pd1
//HW07 - On the Origins of Big Sib 
//2017-09-26

public class Greet {
	public static void main(String args[]) {
		String greeting;

		BigSib richard = new BigSib("Word Up");
		BigSib grizzy  = new BigSib("Hey ya");
		BigSib dotCom = new BigSib("Sup");
		BigSib tracy = new BigSib("Salutations");
		// Above code creates FOUR different objects of the same class
		// There are two constructors in BigSib - one takes a parameter of a string and one doesn't, and we are making use of the one that does so it initializes
		// the variable, helloMsg

		greeting = richard.greet("freshman");
		System.out.println(greeting);

		greeting = grizzy.greet("Kong Fooey");
		System.out.println(greeting);
	
		greeting = tracy.greet("Dr. Spaceman");
		System.out.println(greeting);

		greeting = dotCom.greet("mom");
		System.out.println(greeting);
		// Above code works without the use of the bigSib.setHelloMsg because of the constructors, as mentioned above		
		
	}
}


