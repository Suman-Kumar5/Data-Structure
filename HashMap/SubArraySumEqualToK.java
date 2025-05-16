package HashMap;

import java.util.HashMap;

public class SubArraySumEqualToK {
    public static void main(String[] args) {
        int arr[]={10,2,-2,-20,10};
        int k=-10;
        int n=arr.length;

        HashMap<Integer,Integer> map=new HashMap<>();
        // sum,count
        int ans=0;
        int sum=0;
        map.put(0,1);

        for(int j=0;j<n;j++){
            sum+=arr[j];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        System.out.println(ans);
    }
}
