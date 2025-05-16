package Array;

import java.util.*;
import java.util.Collections;

public class Lonely_Number {
    public static ArrayList<Integer> lonelyNumber(int []nums){
        Arrays.sort(nums);
        int n= nums.length;
        ArrayList<Integer> l=new ArrayList<>();
        if(n==1){
            l.add(nums[0]);
        }
        for(int i=1;i<n-1;i++){
           if(nums[i-1]+1<nums[i] && nums[i]<nums[i+1]-1){
               l.add(nums[i]);
           }
        }
        if(n>1){
            if(nums[0]+1<nums[1]){
                l.add(nums[0]);
            }
            if(nums[n-2]+1<nums[n-1]){
                l.add(nums[n-1]);
            }
        }
        return l;
    }
    public static void main(String args[]){
//        ArrayList<Integer> list=new ArrayList<>();
        int nums[]={10,6,5,8};
        System.out.println(lonelyNumber(nums));
    }
}
