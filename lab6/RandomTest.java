// Java program to demonstrate 
// method calls of Random class 
import java.util.Random; 

public class RandomTest 
{ 
	public static void main(String[] args) 
	{ 
		Random random = new Random(); 
		System.out.println(random.nextInt(10)); 
		System.out.println(random.nextBoolean()); 
		System.out.println(random.nextDouble()); 
		System.out.println(random.nextFloat()); 
		System.out.println(random.nextGaussian()); 
		byte[] bytes = new byte[10]; 
		random.nextBytes(bytes); 
		System.out.printf("["); 
		for(int i = 0; i< bytes.length; i++) 
		{ 
			System.out.printf("%d ", bytes[i]); 
		} 
		System.out.printf("]\n"); 
		
		System.out.println(random.nextLong()); 
	System.out.println(random.nextInt()); 
	
	long seed = 95; 
	random.setSeed(seed); 
	
} 
}	 

