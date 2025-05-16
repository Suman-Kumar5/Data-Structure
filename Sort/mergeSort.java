package Sort;

public class mergeSort {
    public static void mergeSort(int arr[],int s,int e){
        while (e<=s){
            return;
        }
        int mid=s+(e-s)/2;
        mergeSort(arr,s,mid);//left part
        mergeSort(arr,mid+1,e);// right part
        merge(arr,s,mid,e);
    }
    public static void merge(int arr[],int s,int mid,int e){
        int temp[]=new int[e-s+1];
        int i=s;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=e){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;k++;
            }
            else {
                temp[k]=arr[j];
                j++;k++;
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
        mergeSort(number,0,number.length-1);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
