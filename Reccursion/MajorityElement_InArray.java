package Reccursion;

public class MajorityElement_InArray {
    public static int majorityElement(int nums[]){
        int majorityCount= nums.length/2;
        int n= nums.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++) {
                if(nums[j] ==nums[i]) {
                    count+=1;
                }
            }
            if(count>majorityCount) {
                return nums[i];
            }
        }
        return-1;
    }
    public static void main(String[] args) {
        int []nums = {6,5,5};
        System.out.println(majorityElement(nums));
    }
}
