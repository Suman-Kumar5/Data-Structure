package Array;

public class SubArray {
    public static void main(String args[]){
        int ts=0;
        int arr[]={34,66,67,34,45,87,89};
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Kuch to hai "+ts);
    }
}
