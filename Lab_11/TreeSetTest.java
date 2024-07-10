import java.util.*;

public class TreeSetTest {
    public static void main(String args[])
    {
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("BITS");
        ts.add("Pilani");
        ts.add("Hyderabad");
        ts.add("Campus");
        ts.add("Campus");
        ts.add("is cool!");
        Iterator<String> itr = ts.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("******");
        ts.remove("Campus");
        itr = ts.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
