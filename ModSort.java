import Sort.Insertion_Sort;
import Sort.Quick_Sort;

public class ModSort {
    public static void BubbleSort(int []arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    public static void mergeSort(int arr[],int s,int e){
        while (s>=e){
            return;
        }
        int mid=s+(e-s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }
    private static void merge(int arr[],int s,int mid,int e){
        int temp[]=new int[e-s+1];
        int i=s;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=e){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else {
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=e){
            temp[k++]=arr[j++];
        }
        for(int d=0,w=s;d<temp.length;d++,w++){
            arr[w]=temp[d];
        }
    }
    public static void selection(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int minValue=i;
            for(int j=i+1;j<n;j++){
                if(arr[minValue]>arr[j]){
                    minValue=j;
                }
            }
            int temp=arr[minValue];
            arr[minValue]=arr[i];
            arr[i]=temp;
        }
    }
    public static void InsertionSort(int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int prev=i-1;
            int curr=arr[i];
            while (prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    public static void QuickSort(int arr[],int s,int e){
        if(s>=e){
            return;
        }
        int pIdx=paration(arr,s,e);
        QuickSort(arr,s,pIdx-1);
        QuickSort(arr,pIdx+1,e);
    }
    private static int paration(int arr[],int s,int e){
        int pivot=arr[e];
        int i=s-1;
        for(int j=s;j<e;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[e]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static void main(String[] args) {
        int number[]={35,76,12,78,87,45,7,23};
//        BubbleSort(number);
//        mergeSort(number,0, number.length-1);
//        selection(number);
//        InsertionSort(number);
        QuickSort(number,0,number.length-1);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
