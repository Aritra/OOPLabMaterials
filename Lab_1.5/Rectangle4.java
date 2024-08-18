public class Rectangle4{
    private int length;
    private int breadth;
    public Rectangle4(int l, int breadth){
        if((l>0)&&(breadth>0)){
            length = l;
            this.breadth = breadth;
        }else{
            System.out.println("Zero or negative values not allowed");
            System.exit(0);
        }
    }
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

