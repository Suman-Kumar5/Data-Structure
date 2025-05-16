package BST;

import java.util.ArrayList;

public class Marge2BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    public static void getInOrder(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        getInOrder(root.left,arr);
        arr.add(root.data);
        getInOrder(root.right,arr);
    }
    public static Node createBST(ArrayList<Integer> arr,int s,int e){
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr,s,mid-1);
        root.right=createBST(arr,mid+1,e);

        return root;
    }
    public static Node mergeBSTs(Node root1,Node root2){
        ArrayList<Integer> arr1=new ArrayList<>();
        getInOrder(root1,arr1);

        ArrayList<Integer> arr2=new ArrayList<>();
        getInOrder(root2,arr2);

        int i=0,j=0;
        ArrayList<Integer> finalArr=new ArrayList<>();
        while (i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                finalArr.add(arr1.get(i++));
            }
            else {
                finalArr.add(arr2.get(j++));
            }
        }
        while (i<arr1.size()){
            finalArr.add(arr1.get(i++));
        }
        while (j<arr2.size()){
            finalArr.add(arr2.get(j++));
        }
        return createBST(finalArr,0, finalArr.size()-1);
    }
    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void main(String[] args) {

        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);


        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);


        Node root=mergeBSTs(root1,root2);
        preOrder(root);
    }
}
