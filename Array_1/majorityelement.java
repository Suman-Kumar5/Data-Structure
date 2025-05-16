package Array_1;

public class majorityelement {
    public static int majorityElement1(int []arr){
        int n=arr.length;
        int majorityCount= arr.length/2;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>majorityCount){
                return arr[i] ;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []nums = {6,5,5};
        System.out.println(majorityElement1(nums));
    }
}
