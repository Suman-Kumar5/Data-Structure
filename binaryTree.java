import java.util.*;
import java.util.logging.Logger;

public class binaryTree {
    private static final Logger logger = Logger.getLogger(binarytree.class.getName());
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    static class binarytree {
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }

        public void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public void inOrder(Node root){
            if(root==null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        public void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        public void levelOrderTraversal(Node root){
            if (root==null){
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
                    else {
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

        public int height(Node root){
            if (root==null){
                return 0;
            }
            int lt=height(root.left);
            int rt=height(root.right);
            return Math.max(lt,rt)+1;
        }
        public int countNode(Node root){
            if(root==null){
                return 0;
            }
            int lt=countNode(root.left);
            int rt=countNode(root.right);
            return lt+rt+1;
        }
        public int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftSum=sumOfNodes(root.left);
            int rightSum=sumOfNodes(root.right);
            return leftSum+rightSum+root.data;
        }

        // the number of nodes in the longest path between 2 leaves
        public int DiameterOFTree1(Node root){// o(n^2)
            if(root==null){
                return 0;
            }
            int leftDiam=DiameterOFTree1(root.left);
            int rightDiam=DiameterOFTree1(root.right);
            int leftHeight=DiameterOFTree1(root.left);
            int rightHeight=DiameterOFTree1(root.right);
            int selfDiam=leftHeight+rightHeight+1;

            return Math.max(leftDiam,Math.max(rightDiam,selfDiam));
        }
        public int DiameterOFTree2(Node root){// o(n)
            if(root==null){
                return 0;
            }
            int leftDiam=DiameterOFTree1(root.left);
            int rightDiam=DiameterOFTree1(root.right);
            int selfDiam=leftDiam+rightDiam+1;
            return Math.max(leftDiam,Math.max(rightDiam,selfDiam));
        }
        private boolean isIdentical(Node node,Node subRoot){
            if(subRoot==null && node==null){
                return true;
            }
            if(node==null ||subRoot==null ||node.data!=subRoot.data){
                return false;
            }
            if(!isIdentical(node.left,subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right,subRoot.right)){
                return false;
            }
            return true;
        }
        public boolean isSubtree(Node root,Node subRoot){
            if(root==null){
                return false;
            }
            if(root.data==subRoot.data){
                if(isIdentical(root,subRoot)){
                    return true;
                }
            }
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }

         static class info{
            Node node;
            int hd;
             public info(Node node,int hd){
                 this.node=node;
                 this.hd=hd;
             }
         }

         public  void topView(Node root){
            Queue<info> q=new LinkedList<>();
             HashMap<Integer,Node> map=new HashMap<>();

             int min=0,max=0;
             q.add(new info(root,0));
             q.add(null);

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
                         map.put(curr.hd, curr.node);
                     }
                     if(curr.node.left !=null){
                         q.add(new info(curr.node.left, curr.hd-1));
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

         public void kthLevel_Iterative(Node root,int k){
            Queue<Node> q=new LinkedList<>();
            int c=1;
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Node curr=q.remove();
                if(curr==null){
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
                        System.out.print(curr.data+" ");
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            }
        }
        public void kthLevel_recursive(Node root,int level,int k){
            if(root==null){
                return;
            }
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }
            kthLevel_recursive(root.left,level+1,k);
            kthLevel_recursive(root.right,level+1,k);
        }

        private boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }
            boolean leftPath=getPath(root.left,n,path);
            boolean rightPath=getPath(root.right,n,path);

            if(leftPath|| rightPath){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }

        public Node lowestCommonAncestor_1(Node root,int n1,int n2){
            ArrayList<Node> path1=new ArrayList<>();
            ArrayList<Node> path2=new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i=0;
            for(;i<path1.size()&& i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }
            Node lca=path1.get(i-1);
            return lca;
        }
        public Node lowestCommonAncestor_2(Node root,int n1,int n2){
            if(root==null){
                logger.info("Returning null as root is null");
                return null;
            }
            logger.info("Current Node: " + root.data);

            if(root.data==n1 ||root.data==n2){
                logger.info("Returning root as it matches n1 or n2: " + root.data);
                return root;
            }
            Node leftLca=lowestCommonAncestor_2(root.left,n1,n2);
            Node rightLca=lowestCommonAncestor_2(root.right,n1,n2);

            if(leftLca==null){
                logger.info("Left LCA is null, returning right LCA: " + (rightLca != null ? rightLca.data : "null"));
                return rightLca;
            }
            if(rightLca==null){
                logger.info("Right LCA is null, returning left LCA: " + (leftLca != null ? leftLca.data : "null"));
                return leftLca;
            }
            logger.info("Both left and right LCA found, returning root: " + root.data);
            return root;
        }
//        public Node lowestCommonAncestor_2(Node root, int n1, int n2) {
//            if (root == null) {
//                logger.info("Returning null as root is null");
//                return null;
//            }
//
//            logger.info("Current Node: " + root.data);
//
//            if (root.data == n1 || root.data == n2) {
//                logger.info("Returning root as it matches n1 or n2: " + root.data);
//                return root;
//            }
//
//            Node leftLca = lowestCommonAncestor_2(root.left, n1, n2);
//            Node rightLca = lowestCommonAncestor_2(root.right, n1, n2);
//
//            if (leftLca == null) {
//                logger.info("Left LCA is null, returning right LCA: " + (rightLca != null ? rightLca.data : "null"));
//                return rightLca;
//            }
//
//            if (rightLca == null) {
//                logger.info("Right LCA is null, returning left LCA: " + (leftLca != null ? leftLca.data : "null"));
//                return leftLca;
//            }
//
//            logger.info("Both left and right LCA found, returning root: " + root.data);
//            return root;
//        }

        private int lcaDist(Node root,int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }

            int leftDist=lcaDist(root.left,n);
            int rightDist=lcaDist(root.right,n);

            if(leftDist==-1 && rightDist==-1){
                return -1;
            }
            else if(leftDist==-1){
                return rightDist+1;
            }
            else{
                return leftDist+1;
            }
        }
        public int minDist(Node root,int n1,int n2){
            Node lca=lowestCommonAncestor_2(root,n1,n2);
            int dist1=lcaDist(lca,n1);
            int dist2=lcaDist(lca,n2);
            return dist2+dist1;
        }

        public int KAncestor(Node root,int n,int k){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }

            int leftDist=KAncestor(root.left,n,k);
            int rightDist=KAncestor(root.right,n,k);

            if(leftDist==-1 && rightDist==-1){
                return -1;
            }
           int max=Math.max(leftDist,rightDist);
            if(max+1==k){
                System.out.println(root.data);
            }
            return max+1;
        }
        public int transformToSumTree(Node root){
            if(root==null){
                return 0;
            }
            int leftChild=transformToSumTree(root.left);
            int rightChild=transformToSumTree(root.right);

            int newLeft=root.left==null ?0:root.left.data;
            int newRight=root.right==null ? 0:root.right.data;

            int data=root.data;

            root.data= newLeft+ leftChild+ rightChild+ newRight;

            return data;
        }
        public int transformToSumTree1(Node root) {
            if (root == null) {
                return 0;
            }

            // Recursively transform left and right subtrees
            int leftSum = transformToSumTree1(root.left);
            int rightSum = transformToSumTree1(root.right);

            // Store the original value
            int originalData = root.data;

            // Update the node's data to the sum of its children's data
            root.data = leftSum + rightSum;

            // Return the sum of the subtree including the original data of this node
            return root.data + originalData;
        }

        public boolean isUniValued(Node root){
            if(root==null){
                return true;
            }
            if( root.left!=null &&root.data!=root.left.data ){
                return false;
            }
            if(root.right!=null && root.data!=root.right.data){
                return true;
            }
            return isUniValued(root.left) && isUniValued(root.right);
        }

        public Node mirror(Node root){
            if(root==null){
                return null;
            }
            Node leftSubtree=mirror(root.left);
            Node rightSubTree=mirror(root.right);

            root.left=rightSubTree;
            root.right=leftSubtree;

            return root;
        }

        public Node deleteLeafOfValueX(Node root,int x){
            if(root==null){
                return null;
            }
            root.left=deleteLeafOfValueX(root.left,x);
            root.right=deleteLeafOfValueX(root.right,x);

            if(root.data==x && root.left==null && root.right==null){
                return null;
            }

            return root;
        }

        public int maxSumPath(Node root){
            int ans=Integer.MIN_VALUE;
            ans=maxSumPathUtil(root,ans);
            return ans;
        }
        public int maxSumPathUtil(Node root,int ans){
            if(root==null){
                return 0;
            }
            int left=maxSumPathUtil(root.left,ans);
            int right=maxSumPathUtil(root.right,ans);

            int NodeMax=Math.max(Math.max(root.data,root.data+left+right),Math.max(root.data+left,root.data+right));
            ans=Math.max(ans,NodeMax);

            int singlePathSum=Math.max(root.data,Math.max(root.data+left,root.data+right));
            return singlePathSum;
        }
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binarytree tree=new binarytree();
        Node root=tree.buildTree(nodes);
//        System.out.println(root.data);
//        tree.preOrder(root);
        tree.levelOrderTraversal(root);
//        System.out.println("Height of Node:" +tree.height(root));
//        System.out.println("No of Node:"+tree.countNode(root));
//        System.out.println("Sum of Nodes:"+tree.sumOfNodes(root));
//        System.out.println("Diameter of Tree: "+tree.DiameterOFTree2(root));
//
//        Node subRoot=new Node(2);
//         subRoot.left=new Node(4);
//         subRoot.right=new Node(5);
//
//         System.out.println("Is subTree is the part of tree or Not :"+tree.isSubtree(root,subRoot));
//         System.out.print("Top view of the tree :");
//         tree.topView(root);
//         System.out.println();
//         tree.kthLevel_Iterative(root,2);
//         System.out.println();
//         tree.kthLevel_recursive(root,1,2);
//         System.out.println();
//         System.out.println("The lowest common ancestor of "+tree.lowestCommonAncestor_2(root,4,5).data);
//         System.out.println("Minimum distance b/w 2 node is: "+tree.minDist(root,4,6));
//         System.out.println("Kth ancestor  is :"+tree.KAncestor(root,4,1));
//         tree.transformToSumTree(root);
//         System.out.println();
//         tree.preOrder(root);
//         System.out.println();
//         System.out.println(tree.isUniValued(root));
//         root=tree.mirror(root);
//         tree.levelOrderTraversal(root);
        System.out.println(tree.maxSumPath(root));
    }
}
