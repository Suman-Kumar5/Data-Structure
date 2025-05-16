package Stack;

public class Stack_LinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int d){
            data=d;
            next=null;
        }
    }
    static class Stack{
        static Node head;
        public  boolean isEmpty(){
            return head==null;
        }
        public  void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public  int pop(){
            if(isEmpty()){
                System.out.println("Stack under flow");
                return -1;
            }
            int val= head.data;;
            head=head.next;
            return val;
        }
        public  int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack_LinkedList.Stack s=new Stack_LinkedList.Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
