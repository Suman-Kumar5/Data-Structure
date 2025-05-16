package Reccursion;

public class tilingProblem {
    public static int NoOfWays(int n){
        if(n==0||n==1){
            return 1;
        }
        int fnm1=NoOfWays(n-1);
        int fnm2=NoOfWays(n-2);
        return fnm1+fnm2;
    }
    public static void main(String args[]){

    }
}
