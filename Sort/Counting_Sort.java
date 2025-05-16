package Sort;
public class Counting_Sort {
    public static void CountingSort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;// number ko index ka jisa lana h or usko from  0 to jitna v h
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String args[]){
        int number[]={5,4,1,3,2};
        CountingSort(number);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
