/*
class PrintTest{
	//synchronized Code
	public void printThread(int n)
	{
        synchronized(this){
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread " + n + " is working...");
            }
            System.out.println("--------------------------");
        }
	}
}

class Thread1 extends Thread {
	PrintTest test;
	Thread1(PrintTest p) { test = p; }
	public void run()
	{
		test.printThread(1);
	}
}

class Thread2 extends Thread {
	PrintTest test;
	Thread2(PrintTest p) { test = p; }
	public void run() { test.printThread(2); }
}

public class SynchroTest {

	public static void main(String[] args)
	{
		PrintTest p = new PrintTest();
		Thread1 t1 = new Thread1(p);
		Thread2 t2 = new Thread2(p);
		t1.start();
		t2.start();
	}
}
    */

