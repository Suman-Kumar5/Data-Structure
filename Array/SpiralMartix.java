package Array;

public class SpiralMartix {

    public static void printSpiral(int arr[][]){
        int startRow=0;
        int startColumn=0;
        int endRow=arr.length-1;
        int endColumn=arr[0].length-1;

        while (startRow <=endRow && startColumn<=endColumn){
            //top
            for(int j=startColumn;j<=endColumn;j++){
                System.out.print(arr[startRow][j]+" ");
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(arr[i][endColumn]+" ");
            }
            //bottom
            for(int j=endColumn-1;j>=startColumn;j--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(arr[endRow][j]+" ");
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startColumn==endColumn){
                    break;
                }
                System.out.print(arr[i][startColumn]+" ");
            }
            startColumn++;
            startRow++;
            endRow--;
            endColumn--;
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[][]={{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};

        printSpiral(arr);
    }
}
