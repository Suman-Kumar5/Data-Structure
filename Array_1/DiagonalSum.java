package Array_1;

public class DiagonalSum {
    public static void Diagonal_Sum(int arr[][]){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i][i];
            if(i!=n-i-1){
                sum+=arr[i][n-i-1];
            }
        }
        System.out.println("Sum is :"+sum);
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        Diagonal_Sum(arr);
    }
}
