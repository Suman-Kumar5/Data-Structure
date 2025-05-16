package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class majorityElement {
    public static void main(String[] args) {
        int arr[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer>  map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
//        set.size();
        int  n=arr.length;
        Integer.MAX
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
//            OR
//            map.put(num, map.getOrDefault(num,0)+1);
        }
//        Set<Integer> keySet=map.keySet();
       for(Integer key:map.keySet()){
           if(map.get(key)>n/3){
               System.out.println(key);
           }
       }
    }
}
