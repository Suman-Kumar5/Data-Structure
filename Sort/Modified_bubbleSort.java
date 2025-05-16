package Sort;

public class Modified_bubbleSort {
    public static void modifiedBubbleSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean swapped=false;
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    public static void main(String args[]){
        int number[]={345,76,12,78,87,45,7,23};
        modifiedBubbleSort(number);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
