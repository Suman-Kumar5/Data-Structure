package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> Sum3(int nums[]){
        ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList<Integer> s=new ArrayList<>();
                        s.add(nums[i]);
                        s.add(nums[j]);
                        s.add(nums[k]);
                        Collections.sort(s);
                        temp.add(s);
                    }
                }
            }
        }
        temp = new ArrayList<ArrayList<Integer>> (new LinkedHashSet<ArrayList<Integer>>(temp));
        return temp;
    }
    public static void main(String[] args) {
      int  nums[] = {-1, 0,  1, 2, -1, -4};
      ArrayList<ArrayList<Integer>> d=Sum3(nums);
      System.out.println(d);
    }
}
