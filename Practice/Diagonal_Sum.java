package Practice;

public class Diagonal_Sum {
    public static int sumOfDiagonals(int arr[][]){
        int sum=0;
        int n= arr.length;
        for(int i=0;i< arr.length;i++){
            sum+=arr[i][i];
            if(i!=(n-i-1)){
                sum+=arr[i][n-1-i];
            }
        }
        return sum;
    }
    public static void main(String args[]){
        int arr[][]={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        System.out.println(sumOfDiagonals(arr));
    }
}
