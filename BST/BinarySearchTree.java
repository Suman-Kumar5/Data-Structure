package BST;
import java.util.ArrayList;
public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(root.data>data){
            root.left=insert(root.left,data);
        }
        else{
            root.right=insert(root.right,data);
        }
        return root;
    }
    public static void inOrder(Node root){// ya Sorted order ma result dataa h
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root,int key){// o(h) height of the tree
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(key<root.data){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right,val);
        }
        else if(root.data>val){
            root.left=delete(root.left,val);
        }
        else{
            // case-1 left Node
            if(root.left==null && root.right==null){
                return null;
            }
            // one child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            // case-3 two child
            Node is=findInOrderSuccessor(root.right);
            root.data=is.data;
            root.right=delete(root.right, is.data);
        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }
        else if(root.data>k1){
            printInRange(root.left,k1,k2);
        }
        else{
            printInRange(root.right,k1,k2);
        }
    }

    private static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST1(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<= min.data){
            return false;
        }
        if(max!=null && root.data>= max.data){
            return false;
        }
        return isValidBST1(root.left,min,root) && isValidBST1(root.right,root,max);
    }

    public static Node isMirror(Node root){
        if(root==null){
            return null;
        }
        Node leftChild=isMirror(root.left);
        Node rightChild=isMirror(root.right);
        root.left=rightChild;
        root.right=leftChild;
        return root;
    }

    public static Node sortedArrayToBalancedBST(int []arr,int s,int e){
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        Node root=new Node(arr[mid]);
        root.left=sortedArrayToBalancedBST(arr,s,mid-1);
        root.right=sortedArrayToBalancedBST(arr,mid+1,e);

        return root;
    }


    private static void getInorder(Node root,ArrayList<Integer> inorder){// o(n)
        if(root==null){
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data );
        getInorder(root.right,inorder);
    }
    private static Node createBSt(ArrayList<Integer> inOder,int s,int e){//o(n)
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        Node root=new Node(inOder.get(mid));
        root.left=createBSt(inOder,s,mid-1);
        root.right=createBSt(inOder,mid+1,e);
        return root;
    }
    public static Node bstToBalancedBST(Node root){
        ArrayList<Integer> inOrder=new ArrayList<>();// o(n)
        getInorder(root,inOrder);
        root=createBSt(inOrder,0,inOrder.size()-1);//o(n)
        return root;
    }// total o(n)

    public static void main(String[] args) {
        int values[]={8,5,3,1,4,6,10,11,14};
        int value[]={1,2,3,4,5,6,7};
        Node root=null;
        for(int i=0;i<value.length;i++){
            root=insert(root,value[i]);
        }
        inOrder(root);
        System.out.println();
        System.out.println(search(root,3));
//        root=delete(root,5);
//        inOrder(root);
        printInRange(root,5,12);
        System.out.println();
        System.out.println("Number of path :");
        printRoot2Leaf(root,new ArrayList<>());
        System.out.println("Is valid BST: "+isValidBST1(root,null,null));
        isMirror(root);

    }
}
