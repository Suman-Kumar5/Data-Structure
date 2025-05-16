package Backtracking;

public class NQueens {
    public static boolean isSafe(char board[][],int row,int col){
        // top
       for(int i=row-1;i>=0;i--){
           if(board[i][col]=='Q'){
               return false;
           }
       }

        //Dia left Up
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // right up
        for(int i=row-1 ,j=col+1 ;i>=0 &&j< board.length ;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

//    public static void NQueen(char board[][],int row){
//        if(row==board.length){
//            count++;
//            printBoard(board);
//            return;
//        }
//        for(int j=0;j<board.length;j++){
//            if(isSafe(board,row,j)){
//                board[row][j]='Q';
//                NQueen(board,row+1);
//                board[row][j]='X';
//            }
//        }
//    }


    // for only one value or find value is existed or not
    public static boolean NQueen(char board[][],int row){
        if(row==board.length){
            count++;
            printBoard(board);
            return true;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                if(NQueen(board,row+1)){
                    return true;
                }
                board[row][j]='X';
            }
        }
        return false;
    }
    public static void printBoard(char[][] board){
        System.out.println("-----Chess Board-----");
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int count=0;
    public static void main(String[] args) {
        int n=4;
        char [][]board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        NQueen(board,0);
//        printBoard(board);
    }
}
//package Backtracking;
//
//public class NQueens {
//
//    // Check if it's safe to place a queen at board[row][col]
//    public static boolean isSafe(char board[][], int row, int col) {
//        // Check vertical column for any queen
//        for (int i = row - 1; i >= 0; i--) {
//            if (board[i][col] == 'Q') {
//                return false;
//            }
//        }
//
//        // Check left diagonal upwards
//        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//            if (board[i][j] == 'Q') {
//                return false;
//            }
//        }
//
//        // Check right diagonal upwards
//        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
//            if (board[i][j] == 'Q') {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // Solve the N-Queens problem
//    public static void NQueen(char board[][], int row) {
//        if (row == board.length) {
//            printBoard(board);
//            return;
//        }
//        for (int j = 0; j < board.length; j++) {
//            if (isSafe(board, row, j)) {
//                board[row][j] = 'Q';
//                NQueen(board, row + 1);
//                board[row][j] = 'X'; // backtrack
//            }
//        }
//    }
//
//    // Print the board
//    public static void printBoard(char[][] board) {
//        System.out.println("-----Chess Board-----");
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) { // changed from board.length to board[i].length
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    // Main method
//    public static void main(String[] args) {
//        int n = 4;
//        char[][] board = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = 'X';
//            }
//        }
//        NQueen(board, 0);
//    }
//}
