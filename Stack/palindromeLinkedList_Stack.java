package Stack;

import java.util.Stack;

public class palindromeLinkedList_Stack {
    static  class Node{
        Node next;
        int data;
        public Node(int d){
            data=d;
            next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public  void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public boolean IsPalindrome(){
        Node fast=head;
        Node slow=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node prev=null;
        Node currNode=slow;
        while (currNode!=null){
            Node next=currNode.next;
            currNode.next=prev;

            prev=currNode;
            currNode=next;
        }
        Node left=head;
        Node right=prev;
        while (right!=null){
            if(left.data!= right.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }
    public boolean isPalindrome(){
        Node currNode=head;
        if(size==1 ||size==0){
            return true;
        }
        Stack<Integer> s=new Stack<>();
        while (currNode!=null){
            s.push(currNode.data);
            currNode=currNode.next;
        }
        while (head!=null){
            int i=s.pop();
            if(head.data!=i){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    public static void main(String[] args) {
        palindromeLinkedList_Stack s=new palindromeLinkedList_Stack();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(2);
        s.addFirst(2);
        s.addFirst(1);
        System.out.println(s.IsPalindrome());
    }
}
