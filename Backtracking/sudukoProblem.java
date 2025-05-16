package Backtracking;

public class sudukoProblem {
    public static boolean isSafe(int [][]sudoku,int row,int col,int digit){
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        for(int j=0;j<9;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        if(row==9){
            return true;
        }

        int nextRow=row,nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku,nextRow,nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    public static void printBoard(char[][] suduko){
        for(int i=0;i< 9;i++){
            for(int j=0;j<9;j++){
                System.out.print(suduko[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

    }
}
