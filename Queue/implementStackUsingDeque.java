package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class implementStackUsingDeque {
    static class Stack{
        Deque<Integer>  d=new LinkedList<>();
        public boolean isEmpty(){
            return d.isEmpty();
        }
        public void add(int data){
            d.addLast(data);
        }
        public int pop(){
            return d.removeLast();
        }
        public int peek(){
            return d.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s=new Stack();
        s.add(1);
        s.add(2);
        s.add(3);
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
