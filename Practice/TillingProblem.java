package Practice;

public class TillingProblem {
    public static int numberOfWays(int n){
        if(n==1||n==0){
            return 1;
        }
        int w1=numberOfWays(n-1);
        int w2=numberOfWays(n-2);
        return w1+w2;
    }
    public static void main(String[] args) {
        System.out.println(numberOfWays(4));
    }
}
