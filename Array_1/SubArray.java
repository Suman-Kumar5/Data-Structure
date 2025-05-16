package Array_1;

public class SubArray {
    public static void main(String[] args) {
        int arr[]={34,66,67,34,45,87,89};
        int n=arr.length;
        for (int i=0;i<n;i++){
            int start=i;
            for(int j=0;j<n;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }

        }
    }
}
