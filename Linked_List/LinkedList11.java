package Linked_List;

public class LinkedList11 {
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

    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
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
        tail=newNode;
    }

    public void add(int idx,int data){
        if(head==null){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        Node currNode=head;
        int i=0;
        while (i<idx-1){
            currNode=currNode.next;
            i++;
        }
        size++;
        newNode.next=currNode.next;
        currNode.next=newNode;
    }

    public int removeFirst(){
        if(head==null){
            System.out.println("linked List  is null");
            return Integer.MIN_VALUE;
        }
        int delNode=head.data;
        head=head.next;
        size--;
        return delNode;
    }
    public int removeLast(){
        if(head==null){
            System.out.println("linked List  is null");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int delNode=head.data;
            head=tail=null;
            size=0;
            return delNode;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
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

    private int helper(Node head,int key){
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

    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prevNode=null;
        Node currNode=tail=head;
        Node next;
        while (currNode!=null){
            next=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=next;
        }
        head=prevNode;
    }

    public void deleteFromNthEnd(int n){
        int sz=0;
        Node temp=head;
        while (temp!=null){
            temp=temp.next;
            sz++;
        }
         if(n==sz){
             head=head.next; // delete First
             return;
         }
         int i=1;
         int iToFind=sz-n;
         Node prev=head;
         while (i<iToFind){
             prev=prev.next;
             i++;
         }
         prev.next=prev.next.next;
         return;
    }

    // slow fast Approach
    private Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null ){
            slow=slow.next; //+1
            fast=fast.next.next;//+2
        }
        return slow;//slow is my midNode
    }

    public boolean isPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        // step-1 findMid
        Node midNode=findMid(head);
        // step-2 reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        while (curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        // check left half and right half
        while (right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public static boolean isCycle(){ // agar slow or fast aaga jana ka baad milta h to cycle exist krta h
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
        // esma jb pata chal jaaga ke cycle h...tb slow ko head bataa matlab slow start ma chala jaaga
        // or phir tb tk slow or fast ko +1 krna jb tk ke dono same jagaa per naa mil jaa or jo jaga per milta h..
        // vahe jaga hota jaha sa cycle banta h
        Node slow=head;
        Node fast=head;
        boolean flag=false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
               flag=true;
               break;
            }
        }
        if(!flag){
            return;
        }
        Node prev = null;
        slow = head;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next=null;
    }

    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;// mid
    }
    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while (head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while (head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while (head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head==null ||head.next==null){
            return head;
        }
        Node mid= getMid(head);
        // left & right ms
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        // merge
        return merge(newLeft,newRight);
        //n=o(nLogn)
    }

    public void ZigZag(){
        // to find mid
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        // reverse
        Node currNode=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while (currNode!=null){
            next=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=next;
        }

        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        // alternate merge - zig zag merge
        while (left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            // update

            left=nextL;
            right=nextR;
        }
    }

    public void print(){
        if(head==null){
            System.out.println("linked List  is null");
        }
        Node currNode=head;
        while (currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }System.out.println("null");
    }


    public static void main(String args[]){
        LinkedList11 ll=new LinkedList11();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addLast(23);
        ll.addLast(26);
        ll.add(2,65);
//        ll.print();
        ll.mergeSort(ll.head);
//        ll.print();
//        ll.ZigZag();
        ll.print();
//        ll.removeLast();
//        System.out.println(size);
//        ll.print();
//        System.out.println(ll.linearSearch(23));
//        System.out.println(ll.recSearch(23));
//        ll.reverse();
//        ll.deleteFromNthEnd(2);
//        System.out.println(ll.isPalindrome());
//        ll.print();
//        head=new Node(1);
//        head.next=new Node(2);
//        head.next.next=new Node(23);
//        head.next.next.next=new Node(43);
//        head.next.next.next=head.next;
//        System.out.println(isCycle());
//        removeLoop();
//        System.out.println(isCycle());

    }

}
