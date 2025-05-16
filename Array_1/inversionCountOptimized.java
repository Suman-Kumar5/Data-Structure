package Array_1;

public class inversionCountOptimized {
    private static int merge(int arr[],int s,int mid,int e){
        int temp[]=new int[e-s+1];
        int inversion=0;
        int i=s;
        int j=mid;
        int k=0;
        while (i<mid && j<=e){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else {
                temp[k++]=arr[j++];
                inversion+= (mid-i);
            }
        }
        while (i<mid){
            temp[k++]=arr[i++];
        }
        while (j<=e){
            temp[k++]=arr[j++];
        }

        for(i=s,k=0;i<=e;i++,k++){
            arr[i] =temp[k];
        }

        return inversion;
    }
    public static int mergeSort(int arr[],int s,int e){
        int inversion=0;
        if(s<e){
            int mid=s+(e-s)/2;
            inversion=mergeSort(arr,s,mid);
            inversion+=mergeSort(arr,mid+1,e);
            inversion+=merge(arr,s,mid,e);
        }
        return inversion;
    }
    public static int countInversion(int arr[]){
        int n=arr.length-1;
        return mergeSort(arr,0,n);
    }
    public static void main(String args[]){
        int arr[]={2, 4, 1, 3, 5};
        System.out.println(countInversion(arr));
    }
}
