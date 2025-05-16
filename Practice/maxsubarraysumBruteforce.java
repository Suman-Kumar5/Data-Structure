package Practice;

public class maxsubarraysumBruteforce {
    public static int maxSubArraySum(int arr[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j< arr.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    currSum+=arr[k];
                }
                System.out.println("Current max:"+currSum);
                if(currSum>maxSum){
                    maxSum=currSum;
                }
            }
        }
        return maxSum;
    }
    public static void main(String args[]){
        int arr[]={34,66,-67,34,45,87,-89};
        System.out.println("Max sum is "+ maxSubArraySum(arr));
    }
}
