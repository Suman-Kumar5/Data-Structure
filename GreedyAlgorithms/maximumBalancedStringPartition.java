package GreedyAlgorithms;

public class maximumBalancedStringPartition {
    public static int partition(String str,int n){
        if(n==0){
            return 0;
        }
        int l=0;
        int r=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='L'){
                l++;
            }
            else if(str.charAt(i)=='R'){
                r++;
            }
            if(l==r){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str="LRRRRLLRLLRL";
        System.out.println(partition(str,str.length()));
    }
}
