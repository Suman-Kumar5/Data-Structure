package Array;

public class transposeMatrix {
    public static void print(int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int[][] array = { {4,7,8},
                         {8,8,7} };
        print(array);
        System.out.println();
        int row=2;
        int col=3;
        int transpose[][]=new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                transpose[j][i]=array[i][j];
            }
        }
        print(transpose);
    }
}
