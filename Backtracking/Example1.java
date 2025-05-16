package Backtracking;

public class Example1 {
    public static void changeArr(int arr[],int i,int value){
        if(i==arr.length){
            printArr(arr);
            return;
        }
        arr[i]=i;
        changeArr(arr,i+1,value);
        arr[i]=arr[i]-2;
    }
    public static void printArr(int arr[]){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]=new int[5];
        changeArr(arr,0,2);
        printArr(arr);
    }
}
