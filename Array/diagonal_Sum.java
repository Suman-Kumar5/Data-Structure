package Array;

public class diagonal_Sum {
    public static int DiagonalSum(int matrix[][]) {
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - i - 1) {// beach wla element phir sa add na ho jaa
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(DiagonalSum(arr));
    }
}
