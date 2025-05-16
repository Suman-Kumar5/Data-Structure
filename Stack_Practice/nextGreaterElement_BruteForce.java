package Stack_Practice;

public class nextGreaterElement_BruteForce {
    public static int[] nextGreater(int arr[]){
        int n= arr.length;
        int target[]=new int[n];
        for(int i=0;i<n;i++){
            target[i]=-1;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    target[i]=arr[j];
                    break;
                }
            }
        }
        return target;
    }
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        arr=nextGreater(arr);
        for(int d:arr){
            System.out.print(d+" ");
        }
    }
}
