public class Loopier {

	public static void populateArray(int[] a) {
	
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 50);
		}
	}

	public static String printArray(int[] a) {
		String retStr = "[";

		for (int i = 0; i < a.length; i++) {
			if (i > 0) 
				retStr += ", " + a[i];
			else
				retStr += a[i];
		}
		return retStr + "]";
	}


	public static int linSearch( int[] a, int target) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target)
				return i;
		}

		return -1;
	}

	public static int[] removeFirst(int[] a) {
		int[] memes = new int[a.length - 1];

		for (int i = 1; i < a.length; i++) {
			memes[i-1] = a[i];
		}
		return memes;
	}
	//does not work if the number is not in the array! not sure how to get it to return -1 when i keep adding one
	public static int linSearchR(int[] a, int target) {
		
		if (a.length == 0) {

			return -1;

		} else if (a[0] == target) {

			return 0;

		} else {

			int[] memes = removeFirst(a);
			return linSearchR(memes, target) + 1;
		}
	
	}

	public static int freq(int[] a, int target) {
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			
			if (a[i] == target) 
				count ++;

		}
		
		return count;
	}

	public static int freqRec(int[] a, int target) {
		if (a.length == 0) {
			return 0;
		}
		else if (a[0] != target) {
			int[] memes = removeFirst(a);
			return freqRec(memes, target);
		}
		else {
			int[] memes = removeFirst(a);
			return 1 + freqRec(memes, target);
		}
	}



	public static void main(String[] args) {
		int[] memes = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("TESTING linSearch()");	
		System.out.println("memes: " + printArray(memes));
		//Iterative tests
		System.out.println("=====ITERATIVE=====");
		System.out.println("Location of 11 in memes: " + linSearch(memes, 11)); //return -1
		System.out.println("Location of 7 in memes: " + linSearch(memes, 7)); //return 6
		System.out.println("Location of 1 in memes: " + linSearch(memes, 1)); //return 0
		System.out.println("Location of 10 in memes: " + linSearch(memes, 10)); //return 9
		
		//Recursive tests
		System.out.println("=====RECURSIVE=====");
		System.out.println("Location of 11 in memes: " + linSearchR(memes, 11)); //return -1
		System.out.println("Location of 7 in memes: " + linSearchR(memes, 7)); //return 6
		System.out.println("Location of 1 in memes: " + linSearchR(memes, 1)); //return 0
		System.out.println("Location of 10 in memes: " + linSearchR(memes, 10)); //return 9

		//TEsting freq and freqRec
		int[] test = {1,1,1,1,3,4,5,5};
		System.out.println("TESTING freq()");
		System.out.println("test: " + printArray(test));
		//Iterative tests
		System.out.println("=====ITERATIVE=====");
		System.out.println("Freq of 1 in test: " + freq(test, 1)); //return 4
		System.out.println("Freq of 5 in test: " + freq(test, 5)); //return 2
		System.out.println("Freq of 10 in test: " + freq(test, 10)); //return 0
		System.out.println("Freq of 3 in test: " + freq(test, 3)); //return 1
		//Recursive tests
		System.out.println("=====RECURSIVE=====");
		System.out.println("Freq of 1 in test: " + freqRec(test, 1)); //return 4
		System.out.println("Freq of 5 in test: " + freqRec(test, 5)); //return 2
		System.out.println("Freq of 10 in test: " + freqRec(test, 10)); //return 0
		System.out.println("Freq of 3 in test: " + freqRec(test, 3)); //return 1
	}



}
