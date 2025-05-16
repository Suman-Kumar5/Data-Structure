package Array_1;

public class maxSubArraySum_BruteForce {
    public static void main(String[] args) {
        int arr[]={34,66,-67,34,45,87,-89};
        int n=arr.length;
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<n;i++){
            int start=i;
            for(int j=0;j<n;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    currSum+=arr[k];
                }
                System.out.println("Current Sum: "+currSum);
                maxSum=Math.max(currSum,maxSum);
            }
        }
        System.out.println("MaxSum: "+maxSum);
    }
}
