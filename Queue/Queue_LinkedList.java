package Queue;

public class Queue_LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    static class Queue{
        static Node head;
        static Node tail;
        static int size;

        public boolean isEmpty(){
            return  head==null && tail==null;
        }
        public void add(int data){
             Node newNode=new Node(data);
             if(isEmpty()){
                 head=tail=newNode;
                 return;
             }
             tail.next=newNode;
             tail=newNode;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front=head.data;
            if(head==tail){
                head=tail=null;
                return front;
            }
            else {
                head = head.next;
            }
            return front;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }

    }
}
