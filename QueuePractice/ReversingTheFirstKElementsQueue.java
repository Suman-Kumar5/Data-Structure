package QueuePractice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReversingTheFirstKElementsQueue {
    public static void printReverse(Deque<Integer> q,int k){
        Deque<Integer> temp=new LinkedList<>();
//        int n=q.size();
        for(int i=0;i<k;i++){
            temp.addFirst(q.removeFirst());
        }
        while (!temp.isEmpty()){
            q.addFirst(temp.removeLast());
        }
    }
    public static void main(String[] args) {
        Deque<Integer> q=new LinkedList<>();
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
        int k=5;
        printReverse(q,k);
        while (!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
