import java.io.*;
import java.util.*;

public class ThreadTest1 extends Thread {
	// initiated run method for Thread
	public void run()
	{
		System.out.println("Thread Started Running...");
	}
	public static void main(String[] args)
	{
		ThreadTest1 t1 = new ThreadTest1();

		// Invoking Thread using start() method
		t1.start();
	}
}

