// Java Program to implement
//
import java.util.*;

// Driver Class
class TokenizerDemo {
	// main function
	public static void main(String[] args)
	{
		// Creating a StringTokenizer
		StringTokenizer str = new StringTokenizer(
			"ज्ञानम परमं बलम");

		StringTokenizer temp = new StringTokenizer("");

		// countTokens Method
		int count = str.countTokens();
		System.out.println(count);
	
		// hasMoreTokens Methods
		System.out.println("ज्ञानम परमं बलम "+str.hasMoreTokens());
		System.out.println("(Empty String) : "+temp.hasMoreTokens());
	
		// nextElement() Method
		System.out.println("\nTraversing the String:");
	
		while(str.hasMoreTokens()){
			System.out.println(str.nextElement());
		}
		
	}
}

