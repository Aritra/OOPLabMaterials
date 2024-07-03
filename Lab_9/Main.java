class Main{
   public static void main(String[] args) {
      Buffer buffer = new Buffer(2);
      Producer prod = new Producer(buffer);
      Consumer cons = new Consumer(buffer);
      prod.start();
      cons.start();
   }
}
