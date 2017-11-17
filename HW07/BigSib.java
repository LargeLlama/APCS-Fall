public class BigSib {
	
	private String helloMsg; 
	// Private because, as disscussed in class, no reason for it to be public, this is much safer

	public BigSib() {
		helloMsg = "Hello";   
	}
	public BigSib(String message) {
		helloMsg = message;
	}

	// We have two different constructors here, and the code is still valid. This is because when a new object of class BigSib is invoked (with the new command), it has
	// two different possibilities - it can not take a paramater, setting the helloMsg value to the default "Hello", or it can take a parameter, setting the value of 
	// helloMsg to that parameter.

	/*public void setHelloMsg(String msg) {
		helloMsg = msg;	
	}*/

	// Note how the above function is commented out but the code still runs, and has a unique helloMsg for each object. This is because of the constructor.

	public String greet(String name) {
		String retStr = helloMsg; 
		retStr += " " +  name;
		return retStr;
	}
	
	// Still need the greet function to actually return a value that takes a name - this does not need to be modified whatsoever.
}
