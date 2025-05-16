package Sort;

public class decSort {
    public static void bubbleSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    public static void countingSort(int arr[]){
        int n= arr.length;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            largest=Math.max(largest,arr[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=count.length-1;i>=0;i--){
            while (count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }

    public static void SelectionSort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int maxValue=i;
            for(int  j=i+1;j<n;j++){
                if(arr[maxValue]<arr[j]){
                    maxValue=j;
                }
            }
            int temp=arr[maxValue];
            arr[maxValue]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String args[]){
        int number[]={3,6,2,1,8,7,4,5,3,1};
//        bubbleSort(number);
//        countingSort(number);
        SelectionSort(number);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
