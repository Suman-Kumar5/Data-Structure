package Linked_List;

public class LinkedList2 {
    static class Node{
        Node next;
        int data;
        public Node (int d){
            data=d;
            next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data){
        size++;
        Node newNode =new Node(data);
        if(head ==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public static void addLast(int data){
        size++;
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public static void add(int data,int idx){
        size++;
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        Node currNode=head;
        int i=0;
        while (i<idx-1){
            currNode=currNode.next;
            i++;
        }
        newNode.next=currNode.next;
        currNode.next=newNode;
    }

    public static int removeFirst(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int da= head.data;
            head=tail=null;
            return da;
        }
        int val=head.data;
        head=head.next;
        return val;
    }

    public static int removeLast(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int da= head.data;
            head=tail=null;
            return da;
        }
        Node currNode=head;
        int i=0;
        while (i<size-2){
            currNode=currNode.next;
            i++;
        }
        int val=currNode.next.data;
        currNode.next=null;
        tail=currNode;
        size--;
        return val;
    }

    public static int linearSearch(int key){
        Node currNode=head;
        int i=0;
        while (currNode!=null){
            if(currNode.data==key){
                return i;
            }
            i++;
            currNode=currNode.next;
        }
        return -1;
    }

    public static int recSearch(int key){
        return helper(head,key);
    }
    public static int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public static void reverse(){
        Node next;
        Node prev=null;
        Node currNode=tail=head;
        while (currNode!=null){
            next=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=next;
        }
        head=prev;
    }
    public static void deleteFromNthEnd(int n){
        Node temp=head;
        int sz=0;
        while (temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next; // delete first
            return;
        }
        int i=1;
        Node prev=head;
        int idxToFind=sz-n;
        while (i<idxToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }

    private static Node getMid(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean palindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node midNode=getMid(head);

        Node currNode=midNode;
        Node prevNode=null;
        while (currNode!=null){
            Node next=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=next;
        }
        Node right=prevNode;
        Node left=head;
        while (right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeLoop(){
        Node slow=head;
        Node fast=head;
        boolean flag=false;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                flag=true;
                break;
            }
        }
        if(!flag){
            return;
        }
        Node prev=null;
        slow=head;
        while (slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        return;
    }
    public static Node mergeSort(Node head){
        if(head==null && head.next==null){
            return head;
        }
        Node midNode=getMid(head);

        Node rightHead=midNode.next;
        midNode.next=null;

        Node leftNode=mergeSort(head);
        Node rightNode=mergeSort(rightHead);

        return merge(leftNode,rightNode);
    }
    public static Node merge(Node leftNode,Node rightNode){
        Node mergeNode=new Node(-1);
        Node temp=mergeNode;
        while (leftNode!=null && rightNode!=null){
            if(rightNode.data>=leftNode.data){
                temp.next=leftNode;
                temp=temp.next;
                leftNode=leftNode.next;
            }
            else{
                temp.next=rightNode;
                temp=temp.next;
                rightNode=rightNode.next;
            }
        }
        while (leftNode!=null){
            temp.next=leftNode;
            temp=temp.next;
            leftNode=leftNode.next;
        }
        while (rightNode!=null){
            temp.next=rightNode;
            temp=temp.next;
            rightNode=rightNode.next;
        }
        return mergeNode.next;
    }

    public static void print(){
        Node currNode =head;
        while (currNode!=null){
            System.out.print(currNode.data+"-->");
            currNode=currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(3);
        addFirst(4);
        addFirst(5);
        print();
        mergeSort(head);
    }
}
