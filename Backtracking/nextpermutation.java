package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class nextpermutation {
    static  List<List<Integer>> ans=new ArrayList<>();
    public static void  permutation(List<Integer>  level,int idx){
        if(idx==level.size()){
            ans.add(level);
            return;
        }
        for(int i=idx;i<level.size();i++){
            swap(level,level.get(i),level.get(idx));
            permutation(level,idx+1);
            swap(level,level.get(i),level.get(idx));
        }
        return;
    }

    public static void swap(List<Integer>  level,int a,int b){
        int temp= level.get(a);
        level.set(a, level.get(b));
        level.set(b,temp);
    }
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        permutation(arr,0);
        System.out.println(ans);
    }
}
