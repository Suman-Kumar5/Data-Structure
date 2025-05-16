package Sort;

public class Quick_Sort {
    public static void quickSort(int arr[],int s,int e){
        if(s>=e){
            return;
        }
        int pivot=partition(arr,s,e);
        quickSort(arr,s,pivot-1);
        quickSort(arr,pivot+1,e);
    }

    public static int partition(int arr[],int s,int e){
        int pivot=arr[e];
        int i=s-1;
        for(int j=s;j<e;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[e]=arr[i];
        arr[i]=temp;
        return i;
    }

    public static void main(String args[]){
        int number[]={345,76,12,78,87,45,7,23};
        quickSort(number,0,number.length-1);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
