package Stack;

public class nextGreaterElementBruteForce {
    public static int[] nextGreater(int arr[]){
        int n=arr.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            result[i]=-1;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    result[i]=arr[j];
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
         arr=nextGreater(arr);
        for(int d:arr){
            System.out.print(d+" ");
        }
    }
}
