package Practice;

public class friendPairing {
    public static int friendPairingWays(int n){
        if(n==2||n==1){
            return n;
        }
        // single
        int nm1=friendPairingWays(n-1);
        //pair
        int nm2=friendPairingWays(n-2);
        int ways=(n-1)*nm2;
        return nm1+ways;
    }
    public static void main(String args[]){
        System.out.println(friendPairingWays(4));
    }
}
