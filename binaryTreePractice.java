import java.util.*;

public class binaryTreePractice {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public  Node buildTree(int Nodes[]){
            idx++;
            if(Nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(Nodes[idx]);
            newNode.left=buildTree(Nodes);
            newNode.right=buildTree(Nodes);
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
        public int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh,rh)+1;
        }
        public int countNode(Node root){
            if(root==null){
                return 0;
            }
            int lh=countNode(root.left);
            int rh=countNode(root.right);
            return lh+rh+1;
        }
        public int sumOfNode(Node root){
            if(root==null){
                return 0;
            }
            int lSum=sumOfNode(root.left);
            int rSum=sumOfNode(root.right);
            return lSum+rSum+root.data;
        }
        public int DiameterOfTheTree(Node root){
            if(root==null){
                return 0;
            }
            int leftDia=DiameterOfTheTree(root.left);
            int rightDia=DiameterOfTheTree(root.right);
            int leftHeight=DiameterOfTheTree(root.left);
            int rightHeight=DiameterOfTheTree(root.right);
            int self=leftHeight+rightHeight+1;
            return Math.max(leftDia,Math.max(self,rightDia));
        }
        public int DiameterOfTheTree1(Node root){
            if(root==null){
                return 0;
            }
            int leftDia=DiameterOfTheTree1(root.left);
            int rightDia=DiameterOfTheTree1(root.right);
            int self=leftDia+rightDia+1;

            return Math.max(self,Math.max(leftDia,rightDia));
        }
        private boolean isIdentical(Node root,Node subRoot){
            if (root==null && subRoot==null){
                return false;
            }
            if(root==null || subRoot==null || root.data!=subRoot.data){
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
        public boolean isSubTree(Node root,Node subRoot){
            if(root==null){
                return false;
            }
            if(root.data== subRoot.data){
                if(isIdentical(root,subRoot)){
                    return true;
                }
            }

            return isSubTree(root.left,subRoot.left)||isSubTree(root.right,subRoot.right);
        }
        static class info{
            Node node;
            int hd;
            public info(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }
        public void topView(Node root){
            Queue<info> q=new LinkedList<>();
            HashMap<Integer,Node> map=new HashMap<>();

            q.add(new info(root,0));
            q.add(null);
            int max=0,min=0;
            while (!q.isEmpty()){
                info currNode=q.remove();
                if(currNode==null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    if(!map.containsKey(currNode.hd)){
                        map.put(currNode.hd,currNode.node);
                    }
                    if(currNode.node.left!=null){
                        q.add(new info(currNode.node.left, currNode.hd-1));
                        min=Math.min(min, currNode.hd-1);
                    }
                    if(currNode.node.right!=null){
                        q.add(new info(currNode.node.right,currNode.hd+1));
                        max=Math.max(max, currNode.hd+1);
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
                        System.out.print(root.data+" ");
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
        public void kthLevel_recursive(Node root,int level,int k){
            if(root==null){
                return;
            }
            if(level==k){
                System.out.println(root.data+" ");
            }
            kthLevel_recursive(root.left,level+1,k);
            kthLevel_recursive(root.right,level+1,k);
        }

        private boolean getPath(Node root,int n,ArrayList<Node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }
            boolean foundLeft=getPath(root.left,n,path);
            boolean foundRight=getPath(root.right,n,path);

            if(foundLeft|| foundRight){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }
        public int lowestCommonAncestor_1(Node root, int n1, int n2){
            ArrayList<Node> path1=new ArrayList<>();
            ArrayList<Node> path2=new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i=0;
            for(;i<path1.size() && i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }
            Node lca=path1.get(i-1);
            return lca.data;
        }

        public Node lowestCommonAncestor_2(Node root, int n1, int n2){
            if(root==null){
                return null;
            }
            if(root.data==n1 || root.data==n2){
                return root;
            }
            Node leftLCa=lowestCommonAncestor_2(root.left,n1,n2);
            Node rightLca=lowestCommonAncestor_2(root.right,n1,n2);

            if(leftLCa==null){
                return rightLca;
            }
            if(rightLca==null){
                return leftLCa;
            }
            return root;
        }
        private int lcaDist(Node root,int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int leftSe=lcaDist(root.left,n);
            int rightSe=lcaDist(root.right,n);
            if(leftSe==-1 && rightSe==-1){
                return -1;
            }
            else if(leftSe==-1){
                return rightSe+1;
            }
            else{
                return leftSe+1;
            }
        }
        public int minDist(Node root,int n1,int n2){
            Node lca=lowestCommonAncestor_2(root,n1,n2);
            int leftDist=lcaDist(root,n1);
            int rightDist=lcaDist(root,n2);
            return leftDist+rightDist;
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

            int newLeft=root.left==null? 0:root.left.data;
            int newRight=root.right==null?0:root.right.data;
            int data=root.data;

            root.data= newLeft+ leftChild+ rightChild+ newRight;
            return data;
        }
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,7,-1,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        tree.preOrder(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println(tree.lowestCommonAncestor_1(root,4,5));
        System.out.println("Min distance: "+tree.minDist(root,4,6));
        tree.transformToSumTree(root);
//        tree.inOrder(root);
        System.out.println();
        tree.levelOrderTraversal(root);
    }
}
