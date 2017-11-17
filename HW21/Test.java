public class Test {
	public static void main(String[] args) {
		int result; 
		for (String s: args){
			result = Integer.parseInt(s);
			System.out.println(++result);
		}
		
	}
}
