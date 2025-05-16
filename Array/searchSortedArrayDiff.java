package Array;

public class searchSortedArrayDiff {
    public static boolean stairCaseSearch(int arr[][],int key){
        int row= arr[arr.length-1].length-1;
        int col=0;
        while (row>=0 && col<= arr.length-1){
            if(arr[row][col]==key){
                System.out.println("("+row+","+col+")");
                return true;
            }
            else if(arr[row][col]>key){
                row--;
            }
            else{
                col++;
            }
        }
        System.out.println("("+row+","+col+")");
        return false;
    }
    public static void main(String args[]){
        int arr[][]={{1,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}};
        int key=30;
        System.out.println(stairCaseSearch(arr,key));
    }
}
