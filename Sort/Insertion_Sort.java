package Sort;

public class Insertion_Sort {
    public static void InsertionSort(int arr[]){
        int n= arr.length;
        for(int i=1;i<n;i++){
            int pre=i-1;
            int curr=arr[i];
            while(pre>=0 && arr[pre]>curr){
                arr[pre+1]=arr[pre];
                pre--;
            }
            arr[pre+1]=curr;
        }
    }
    public static void main(String args[]){
        int number[]={35,76,12,78,87,45,7,23};
        InsertionSort(number);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
