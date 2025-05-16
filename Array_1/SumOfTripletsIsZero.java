package Array_1;

public class SumOfTripletsIsZero {
    public static void findAllTriplets(int nums[]){
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=j;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        System.out.print("("+nums[i]+","+nums[j]+","+nums[k]+")");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int nums []={-1, 0,  1, 2, -1, -4};
        findAllTriplets(nums);
    }
}
