class PrintTest{
	synchronized public static void printThread(int n)
	{
		for (int i = 1; i <= 10; i++) {
			System.out.println("Thread " + n+ " is working...");
		}
		System.out.println("--------------------------");
	}
}

class Thread1 extends Thread {
	public void run()
	{
		PrintTest.printThread(1);
	}
}

class Thread2 extends Thread {
	public void run()
	{
		PrintTest.printThread(2);
	}
}

public class SynchroTest2 {
	public static void main(String[] args)
	{
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();

		t1.start();
		t2.start();
	}
}

