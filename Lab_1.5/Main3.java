public class Main3 {
    void calArea(int l, int b){
        System.out.println("The area of the rectangle is: "
        +(l*b));
    }
    int calArea2(Rectangle1 r){
        return (r.length*r.breadth);
    }
    public static void main(String[] args) {
        Rectangle1 r1= new Rectangle1();
        Main3 m = new Main3();
        r1.length = 5;
        r1.breadth = 10;
        m.calArea(r1.length, r1.breadth);
        System.out.println("The area is: "+m.calArea2(r1));
    }
}
