package Reccursion;

public class towerOfHanoi {
    public static void towerOfHanoi(int n,String src,String helper,String dest){
        if(n==1) {
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1,src,dest,helper);
        System.out.println("transfer disk "+n+" from "+src+" to "+helper);
        towerOfHanoi(n-1,helper,src,dest);
    }
    public static void main(String args[]){
        towerOfHanoi(3,"s","h","d");
    }
}
