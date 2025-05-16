package Reccursion;

public class LastOccurance {
    public static int lastOcc(int arr[],int n,int key){
        if(n==-1){
            return -1;
        }
        if(arr[n]==key){
            return n;
        }
        return lastOcc(arr,n-1,key);
    }
    public static void main(String args[]){
        int arr[]={3,7,8,4,7,43,6};
        System.out.println(lastOcc(arr,arr.length-1,7));
    }
}
