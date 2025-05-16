package Practice;

public class subArray {
    public static void sub_array(int arr[]){
        for(int i=0;i< arr.length;i++){
            int start=i;
            for(int j=i;j< arr.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[]={34,66,67,34,45,87,89};
        sub_array(arr);
    }
}
