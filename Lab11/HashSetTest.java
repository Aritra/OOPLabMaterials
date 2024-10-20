import java.util.*;

public class HashSetTest {
    public static void main(String args[])
    {
        HashSet<String> hs = new HashSet<String>();
        hs.add("BITS");
        hs.add("Pilani");
        hs.add("Hyderabad");
        hs.add("Campus");
        hs.add("Campus");
        hs.add("is cool!");
        Iterator<String> itr = hs.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("******");
        hs.remove("Campus");
        itr = hs.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

