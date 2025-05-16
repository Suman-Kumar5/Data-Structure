package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class Deque_DoubleEnded {
    public static void main(String[] args) {
        Deque<Integer> d=new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(4);
        d.addLast(3);
        System.out.println(d);
        d.removeLast();
        System.out.println("First element: "+d.getFirst());
        System.out.println("Last element: "+d.getLast());
    }
}
