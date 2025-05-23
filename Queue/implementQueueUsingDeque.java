package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class implementQueueUsingDeque {
    static class Queue{
        Deque<Integer> q=new LinkedList<>();
        public boolean isEmpty(){
            return q.isEmpty();
        }
        public void add(int data){
            q.addLast(data);
        }
        public int remove(){
            return q.removeFirst();
        }
        public int peek(){
            return q.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
