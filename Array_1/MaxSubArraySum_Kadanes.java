package Array_1;

public class MaxSubArraySum_Kadanes {
    public static void main(String[] args) {
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        int n=arr.length;
        int cs=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            cs+=arr[i];
            if(cs<0){
                cs=0;
            }
            maxSum=Math.max(maxSum,cs);
        }
        System.out.println("Max Sum: "+maxSum);
    }
}
