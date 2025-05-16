package Practice;

public class searchInSortedMatrix {
    public static boolean search(int matrix[][],int key){
        int row=matrix.length-1;
        int col=0;
        while (row>=0&& col<matrix.length){
            if(matrix[row][col]==key){
                System.out.println("Found at :"+row+" and "+col);
                return true;
            }
            else if(key>matrix[row][col]){
                col++;
            }
            else {
                row--;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int arr[][]={{1,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}};
        int key=30;
        System.out.println(search(arr,key));
    }
}
