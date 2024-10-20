import java.util.*;
public class ArrayDequeTest {
    public static void main(String[] args)
    {
        ArrayDeque<Integer> de_que= new ArrayDeque<Integer>(10);
        de_que.add(10);
        de_que.add(20);
        de_que.add(30);
        de_que.add(40);
        de_que.add(50);
        System.out.println(de_que);

        de_que.clear();
        de_que.addFirst(564);
        de_que.addFirst(291);
        de_que.addLast(24);
        de_que.addLast(14);

        System.out.println(de_que);
    }
}

