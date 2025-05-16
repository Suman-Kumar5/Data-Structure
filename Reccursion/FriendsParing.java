package Reccursion;

public class FriendsParing {
    public static int FriendsParingWays(int n){
        if(n==1||n==2){
            return n;
        }

        // single
        int fnm1=FriendsParingWays(n-1);
        // pair
        int fnm2=FriendsParingWays(n-2);
        int paringWays=(n-1)*fnm2;
        return paringWays+fnm1;
    }
    public static void main(String args[]){
        System.out.println(FriendsParingWays(5));
    }
}
