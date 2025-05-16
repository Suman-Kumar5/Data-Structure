package Practice;

public class Sort {
    public static void BubbleSort(int arr[]){
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j ] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int arr[]){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            int minPos=i;
            for(int j=i+1;j<n;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }
    public static void insertionSort(int arr[]){
        int n= arr.length;
        for(int i=1;i<n;i++){
            int curr=arr[i];
            int prev=i-1;
            //finding out the correct position
            while (prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1]=curr;
        }
    }
    public static void countingSort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i< count.length;i++){
            while (count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }

    public static void mergeSort(int arr[],int s,int e){
        if(s>=e){
            return;
        }
        int mid=s+(e-s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }
    public static void merge(int arr[],int s,int mid,int e){
        // left(0,3)=4 right(4,6)=3 -> 0+6+1=7
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
    public static void main(String args[]){
        int number[]={345,76,12,78,87,45,7,23};
        int n=number.length-1;
//        BubbleSort(number);
//        selectionSort(number);
//        insertionSort(number);
//        countingSort(number);
        mergeSort(number,0,n);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
