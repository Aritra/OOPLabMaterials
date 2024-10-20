class Buffer {
   int buffer[];
   int top = 0, size = 0, numElements = 0;

   public Buffer(int s) {
      buffer = new int[s];
      size = s;
   }

   public synchronized void push(int element) {
      if (numElements == size) {
         try {
            System.out.println("$$$$$$   stack full wait in push");
            wait();
         } catch (InterruptedException e) {
            System.out.println("Interrupted");
         }
      }
      buffer[top] = element;
      top++;
      numElements++;
      // System.out.println("Notify in insert");
      notify();
   }

   public synchronized int pop() {
      if (numElements == 0) {
         try {
            System.out.println("******   stack empty wait in pop");
            wait();
         } catch (InterruptedException e) {
            System.out.println("Interrupted");
         }
      }
      top--;
      int value = buffer[top];
      numElements--;
      // System.out.println("Notify in delete");
      notify();
      return value;
   }
}
