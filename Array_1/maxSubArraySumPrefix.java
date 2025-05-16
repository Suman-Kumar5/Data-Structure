package Array_1;

public class maxSubArraySumPrefix {
    public static void main(String[] args) {
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int arr[]={1,-2,6,-1,3};
        int n= arr.length;
        int prefix[]=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i]+arr[i-1];
        }
        for(int i=0;i<n;i++){
            int start=i;
            for(int j=i;j<n;j++){
                int end=j;
                currSum=start==0?prefix[end]:prefix[end]-prefix[start-1];
                System.out.println("Current Sum "+currSum);
                maxSum=Math.max(currSum,maxSum);
            }
        }
        System.out.println("Max Sum: "+maxSum);
    }
}
