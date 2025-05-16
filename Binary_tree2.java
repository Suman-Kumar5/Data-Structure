import javax.swing.*;
import java.util.*;

public class Binary_tree2 {

    static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    // bulidTree
    static int idx=-1;
    public static Node buildTree(int arr[]){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node newNode=new Node(arr[idx]);
        newNode.left=buildTree(arr);
        newNode.right=buildTree(arr);

        return newNode;
    }
    //pre,post,In
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    // level order traversal

    public static void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }

    //height,count of the Node and sum of the node
    public static int heigth(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=heigth(root.left);
        int rightHeight=heigth(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }

    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int lc=countNode(root.left);
        int rc=countNode(root.right);
        return lc+rc+1;
    }
    public static int sumOfNode(Node root){
        if(root==null){
            return 0;
        }
        int ls=sumOfNode(root.right);
        int rs=sumOfNode(root.right);
        return ls+rs+1;
    }
    // Diameter of the tree-- samajna hai phala
    public static int DiameterOfTree(Node root){
        if(root==null){
            return 0;
        }
        int leftDia=DiameterOfTree(root.left);
        int rightDia=DiameterOfTree(root.right);

        int leftHeight=heigth(root.left);
        int rightHeight=heigth(root.right);
        int selfDia=leftHeight+rightHeight+1;

        return Math.max(selfDia,Math.max(rightDia,leftDia));
    }

    // isSubtree
    private static boolean isIdentical(Node root,Node subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null || root.data!= subRoot.data){
            return false;
        }
        if(!isIdentical(root.left,subRoot.left)){
            return false;
        }
        if(!isIdentical(root.right,subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) ||isSubtree(root.right,subRoot);
    }

    static class info{
        Node node;
        int hd;
        info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void topView(Node root){
        Queue<info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        q.add(new info(root,0));
        q.add(null);
        int min=0,max=0;

        while (!q.isEmpty()){
            info curr=q.poll();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null ){
                    q.add(new info(curr.node.left,curr.hd-1));
                    min=Math.min(min, curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new info(curr.node.right,curr.hd+1));
                    max=Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }

    public static void bottomView(Node root){
        Queue<info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        q.add(new info(root,0));
        q.add(null);
        int min=0,max=0;

        while (!q.isEmpty()){
            info curr=q.poll();

            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                map.put(curr.hd,curr.node);

                if(curr.node.left!=null){
                    q.add(new info(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new info(curr.node.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }

    public static void KthLevel_iterative(Node root,int k){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int c=1;

        while (!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                c++;
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(c==k){
                    System.out.print(currNode.data+" ");
                }
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void KthRecursive(Node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.println(root.data+" ");
        }
        KthRecursive(root.left,level+1,k);
        KthRecursive(root.right,level+1,k);
    }
    // LCA
    public static Node lowestCommonAncestor1(Node root,int n1,int n2){
        if(root==null){
            return null;
        }

        if(root.data==n1 ||root.data==n2){
            return root;
        }
        Node leftLca=lowestCommonAncestor1(root.left,n1,n2);
        Node rightLca=lowestCommonAncestor1(root.right,n1,n2);

        if(leftLca==null){
            return rightLca;
        }

        if(rightLca==null){
            return leftLca;
        }
        return root;
    }
    public static boolean getPath(Node root,ArrayList<Node> path ,int n){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        Boolean foundLeft=getPath(root.left,path,n);
        Boolean foundRight=getPath(root.right,path,n);

        if(foundLeft|| foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lowestCommonAncestor2(Node root,int n1,int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();

        getPath(root,path1,n1);
        getPath(root,path2,n2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }
    public static List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q=new LinkedList<>();

        q.add(root);
        q.add(null);
        List<Integer> level = new ArrayList<>();
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                ans.add(new ArrayList<>(level)); // Add a copy of the current level
                level.clear();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                level.add(currNode.data);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(6);
        Node root=buildTree(nodes);
//        levelOrderTraversal(root);
//        System.out.println(DiameterOfTree(root));
//        System.out.println(isSubtree(root,subRoot));
//        topView(root);
//        System.out.println();
//        bottomView(root);
//        System.out.println();
//        KthLevel_iterative(root,2);
//        System.out.println();
//        System.out.println(lowestCommonAncestor1(root,4,6).data);
//        System.out.println(lowestCommonAncestor2(root,4,6).data);
        List<List<Integer>> ans=levelOrder(root);
        System.out.println(ans);
    }
}
