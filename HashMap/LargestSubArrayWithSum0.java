package HashMap;

import java.util.HashMap;

public class LargestSubArrayWithSum0 {
    public static void main(String[] args) {
        int arr[]={15,-2,2,-8,1,7,10,23};
        int n= arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        //sum,idx

        int sum=0;
        int len=0;

        for(int j=0;j<n;j++){
            sum+=arr[j];
            if(map.containsKey(sum)){
                len=Math.max(len,j-map.get(sum));
            }
            else {
                map.put(sum,j);
            }
        }
        System.out.println("Longest Sub Array is :"+len);
    }
}
