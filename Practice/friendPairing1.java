package Practice;

public class friendPairing1 {
    public static int noOfWays(int n){
        if(n==1||n==2){
            return n;
        }
        int single=noOfWays(n-1);
        int pair=noOfWays(n-2);
        return single+pair;
    }
    public static void main(String[] args) {
        System.out.println(4);
    }
}
