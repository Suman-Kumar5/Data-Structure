package Array;

public class maxSubArraySumPrefix {
    public static void main(String args[]){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int arr[]={1,-2,6,-1,3};
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i]+arr[i-1];
        }
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                currSum= start==0 ?prefix[end]:prefix[end]-prefix[start-1];
                if(currSum>maxSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("Max Sum :"+ maxSum);
    }
}
