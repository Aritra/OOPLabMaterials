class Producer extends Thread {
   Buffer buffer;
   public Producer(Buffer b) {
      buffer = b;
   }
   public void run(){
      int value = 0;
      while(true){
         buffer.push(value);
         System.out.println("Produced and pushed: "+value);
         value += 1; 
         try {
            sleep(300);
         }
         catch(InterruptedException e) {
            System.out.println("Interrupted");
         }   
      }
   }
}
