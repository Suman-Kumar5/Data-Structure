package Array;

public class SearchInSortedAndRotated {
    public static int search(int arr[],int s,int e,int target){
        if(s>e){
            return -1;
        }
        int mid=s+(e-s)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[s]<=arr[mid]){
            if(arr[s]<=target && target<=arr[mid]){
                return search(arr,s,mid-1,target);
            }
            else{
                return search(arr,mid+1,e,target);
            }
        }
        else{
            if(arr[mid]<=target && target<=arr[e]){
                return search(arr,mid+1,e,target);
            }
            else{
                return search(arr,s,mid-1,target);
            }
        }

    }
    public static void main(String args[]){
        int arr[]={4,6,7,8,0,1,2,3};
        int target=0;
        int ind=search(arr,0,arr.length-1,target);
        System.out.println(ind);
    }
}
