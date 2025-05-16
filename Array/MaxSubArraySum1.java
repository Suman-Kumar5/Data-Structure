package Array;

public class MaxSubArraySum1 {
    public static void main(String args[]){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int arr[]={34,66,-67,34,45,87,-89};
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    currSum+=arr[k];
                }
                System.out.println("Current Sum "+currSum);
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("Max Sum :"+maxSum);
    }
}
