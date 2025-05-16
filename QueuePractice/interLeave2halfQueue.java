package QueuePractice;

import java.util.LinkedList;
import java.util.Queue;

public class interLeave2halfQueue {
    public static void printInterLeave2halfQueue(Queue<Integer> q){
        Queue<Integer> temp=new LinkedList<>();
        int size=q.size();
        for(int i=0;i<size/2;i++){
            temp.add(q.remove());
        }
        while (!temp.isEmpty()){
            q.add(temp.remove());
            q.add(q.remove());
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
