package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class interLeave2HalfQueue {
    public static void printInterLeave2halfQueue(Queue<Integer> q1){
        Queue<Integer> firstHalf=new LinkedList<>();
        int size=q1.size();
        for(int i=0;i<size/2;i++){
            firstHalf.add(q1.remove());
        }
        while (!firstHalf.isEmpty()){
           q1.add(firstHalf.remove());
            q1.add(q1.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        printInterLeave2halfQueue(q);
        while (!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
