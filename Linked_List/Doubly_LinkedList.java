package Linked_List;

public class Doubly_LinkedList {
    class Node{
        Node next;
        Node prev;
        int data;
        public Node(int d){
            next=prev=null;
            data=d;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        head.prev=newNode;
        tail=newNode;
    }

    public int removeFirst(){
        size--;
        if(head==null){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        return val;
    }

    public int removeLast(){
        if(head==null){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        tail.prev=tail.prev.next;
        return 1;
    }

    public void reverse(){
        Node next;
        Node currNode=head;
        Node prev=null;
        while (currNode!=null){
            next=currNode.next;
            currNode.next=prev;
            currNode.prev=next;
            prev=currNode;
            currNode=next;
        }
        head=prev;
    }

    public void print(){
        if(head==null){
            System.out.println("Linked List is empty");
            return;
        }
        Node currNode=head;
        System.out.print("null<-->");
        while (currNode!=null){
            System.out.print(currNode.data+"<-->");
            currNode=currNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Doubly_LinkedList d=new Doubly_LinkedList();
        d.addFirst(1);
        d.addFirst(16);
        d.addFirst(5);
        d.addLast(6);
        d.print();
        d.removeFirst();
        d.reverse();
        d.print();
    }
}
