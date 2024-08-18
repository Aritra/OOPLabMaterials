public class Rectangle3{
    private int length;
    private int breadth;
    public int getBreadth() {
        return this.breadth; //'this' is optional
    }
    public void setBreadth(int breadth) {
        if(breadth>0)
            this.breadth = breadth;
        else{
            System.out.println("Negative breadth makes no sense!");
            System.exit(0);
        }
    }
    int getLength(){
        return length;
    }
    void setLength(int l){
        if(l>0)
            length = l;
        else{
            System.out.println("Negative length makes no sense!");
            System.exit(0);
        }
    }
}
