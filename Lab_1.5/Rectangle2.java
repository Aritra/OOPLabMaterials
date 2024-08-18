public class Rectangle2{
    private int length;
    private int breadth;
    public int getBreadth() {
        return this.breadth; //'this' is optional
    }
    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
    int getLength(){
        return length;
    }
    void setLength(int l){
        length = l;
    }
}