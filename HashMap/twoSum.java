package HashMap;

import java.util.HashMap;

public class twoSum {
    public static int[] twoSums(int arr[],int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int diff=target-arr[i];

            if(map.containsKey(diff)){
                return new int[]{i,map.get(diff)};
            }
            map.put(arr[i],i);
        }
        return new int[]{0,0};
    }
    public static void main(String[] args) {
        int []arr = {2, 7, 11, 15};
        int target = 9;
        int ans[]=twoSums(arr,target);
        for(int a:ans){
            System.out.println(arr[a]);
        }
//        System.out.println(arr[ans[0]]+" "+arr[ans[1]]);
    }
}
