public class KthSmallestNumber {
    public static int countSmaller(int [][]matrix , int val){
        int count = 0;

        for(int i = 0 ; i < matrix.length ; i++){
            // binary search here to count no of elements smaller than val
            int st = 0 ;
            int end = matrix[0].length-1;
            // int ans =0;
            while(st <= end){
                int mid = st + (end - st)/2;
                if(matrix[i][mid] <= val){
                    // ans = mid;
                    st = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            count += st;
        }
        return count;
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int st = matrix[0][0];
        int end = matrix[matrix.length-1][matrix[0].length-1];

        int ans = 0;

        while(st < end){
            int mid = st + (end - st)/2;
            int count = countSmaller(matrix,mid);

            if(count < k){
                st = mid+1;
            }
            else{
                end = mid;
            }
        }
        return st;
    }

    public static void main(String[] args) {
      int [][]  matrix = {{1,5,9},{10,11,13},{12,13,15}} ;
      int k = 8;
      System.out.println(kthSmallest(matrix,k));
    }
}
