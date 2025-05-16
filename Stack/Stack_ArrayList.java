package Stack;

import java.util.ArrayList;
public class Stack_ArrayList {
    static class Stack1{
        ArrayList<Integer> a=new ArrayList<>();
        public  boolean isEmpty(){
            return a.size()==0;
        }
        public  void push(int data){
            a.add(data);
        }
        public  int pop(){
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            int val=a.get(a.size()-1);
            a.remove(a.size()-1);
            return val;
        }
        public  int peek(){
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return a.get(a.size()-1);
        }
    }
    public static void main(String args[]){
//        Stack1.push(1);
//        Stack1.push(2);
//        Stack1.push(3);
//        Stack1.push(56);
        Stack1 s=new Stack1();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.peek()); // Output: 30
        System.out.println(s.pop());  // Output: 30
        System.out.println(s.pop());  // Output: 20
        System.out.println(s.isEmpty()); // Output: false
        System.out.println(s.pop());  // Output: 10
        System.out.println(s.isEmpty()); // Output: true
    }
}