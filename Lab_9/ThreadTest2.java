import java.io.*;
import java.util.*;
public class ThreadTest2 implements Runnable {
	// method to start Thread
	public void run()
	{
		System.out.println(
			"Thread is Running Successfully");
	}
	public static void main(String[] args)
	{
		ThreadTest2 g1 = new ThreadTest2();
		// initializing Thread Object
		Thread t1 = new Thread(g1);
		t1.start();
	}
}

