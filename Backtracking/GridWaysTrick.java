package Backtracking;

public class GridWaysTrick {
    private static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int ways(int n,int m){
        int w=(factorial(n-1+m-1))/((factorial(n-1)*(factorial(m-1))));
        return w;
    }
    public static void main(String[] args) {
        System.out.println(ways(3,3));
    }
}
