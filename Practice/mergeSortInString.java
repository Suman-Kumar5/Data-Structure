package Practice;

public class mergeSortInString {

    public static void mergeSort(String arr[],int s,int e){
        if(s>=e){
            return ;
        }
        int mid=s+(e-s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }

    private static void merge(String arr[],int s,int mid,int e){
        String temp[]=new String[e-s+1];
        int i=s;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=e){
            if(isSmaller(arr[i],arr[j])){
                temp[k++]=arr[i++];
            }
            else{
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
    static boolean isSmaller(String str,String str1){
        if(str.compareTo(str1)<0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
       String []arr = { "sun", "earth", "mars", "mercury"};
        for(String k:arr){
            System.out.print(k+" ");
        }
        System.out.println();
       mergeSort(arr,0, arr.length-1);
       for(String k:arr){
           System.out.print(k+" ");
       }
    }
}
