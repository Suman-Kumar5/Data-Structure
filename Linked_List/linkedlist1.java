package Linked_List;

public class linkedlist1 {
    static class Node{
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

    public void addFirst(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
        return;
    }
    public void addLast(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void add(int data,int idx){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        Node currNode=head;
        int i=0;
        while (i<idx-1){
            i++;
            currNode=currNode.next;
        }
        newNode.next=currNode.next;
        currNode.next=newNode;
    }

    public int removeFirst(){
        if(head==null){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        size--;
        int re=head.data;
        head=head.next;
        return re;
    }

    public int removeLast(){
        if(head==null){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }

        if(size==1){
            int delNode=head.data;
            head=tail=null;
            size=0;
            return delNode;
        }
        Node lastNode=head;
        for(int i=0;i<size-2;i++){
            lastNode=lastNode.next;
        }
        int re=lastNode.next.data;
        lastNode.next=null;
        size--;
        return re;
    }

    public void removeFromNthEnd(int n){
        // pecha nth index delete krta h
        Node temp=head;
        int size=0;
        while (temp!=null){
            temp=temp.next;
            size++;
        }
        if(n==size){
            head=head.next;
            return;
        }
        int i=1;
        Node prev=head;
        int toFind=size-n;
        while (i<toFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }

    public int linearSearch(int key){
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
    private int helper(int key,Node head){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(key,head.next);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(key,head);
    }

    public void reverse(){
        Node currNode=head;
        Node prevNode=head=tail;
        Node next;
        while (currNode!=null){
            next=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=next;
        }
        head=prevNode;
    }

    private Node getMid(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node currNode= getMid(head);
        Node  prev=null;
        while (currNode!=null){
            Node next=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=next;
        }

        Node left=head;
        Node right=prev;
        while (left!=right){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public boolean isCycle(){
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

    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean flag=false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                flag=true;
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
            fast=fast.next;
        }
        prev.next=null;
    }

    public Node oddEvenList() {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        Node odd=new Node(-1);
        Node even=new Node(-1);
        Node oddNode=odd;
        Node evenNode=even;
        Node currNode=head;
        while(currNode!=null){
            if(currNode.data %2 ==1){
                oddNode.next=new Node(currNode.data);
                oddNode=oddNode.next;
            }
            else{
                evenNode.next=new Node(currNode.data);
                evenNode=evenNode.next;
            }
            currNode=currNode.next;
        }
        oddNode.next=evenNode.next;
        return oddNode.next;
    }
    public Node removeElements(Node head, int val) {
        if(head==null){
            return null;
        }
        if(head.next==null && head.data==val){
            return null;
        }
        Node currNode=head;
        Node ans=new Node(-1);
        Node next1=ans;
        while(currNode !=null){
            if(currNode.data==val){
                currNode=currNode.next;
                continue;
            }
            next1.next=currNode;
            next1=next1.next;
            currNode=currNode.next;
        }
        return ans.next;
    }

    public void print(){
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        Node currNode=head;
        while (currNode!=null){
            System.out.print(currNode.data+"-->");
            currNode=currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        linkedlist1 l=new linkedlist1();
        l.addFirst(7);
        l.addFirst(1);
        l.addFirst(3);
        l.addFirst(2);
        l.print();
        l.oddEvenList();
        l.print();
        System.out.println(23/10);
    }
}
