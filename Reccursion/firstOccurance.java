package Reccursion;

public class firstOccurance {
    public static int firstOcc(int arr[],int i,int n,int key){
        if(i==n-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOcc(arr,i+1,n,key);
    }
    public static void main(String args[]){
        int arr[]={3,7,8,4,7,43,6};
        System.out.println(firstOcc(arr,0,arr.length-1,7));
    }
}
