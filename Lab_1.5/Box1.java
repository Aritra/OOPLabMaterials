public class Box1 extends Rectangle5{
    private int height;
    public Box1(int l, int breadth, int height) {
        super(l, breadth);
        if(height>0)
            this.height = height;
        else{
            System.out.println("Negative height error!");
            System.exit(0);
        }
    } 
    public int calVolume(){
        return this.height*super.calArea();
    }   
}
