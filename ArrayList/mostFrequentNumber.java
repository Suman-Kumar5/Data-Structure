package ArrayList;

import java.util.*;
public class mostFrequentNumber {
    public static int frequency(ArrayList<Integer>nums,int key){
        int[]result=new int[1000];
        for(int i=0;i<nums.size()-1;i++){
            if(nums.get(i) ==key){
                result[nums.get(i+1)-1]++;
            }
        }
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<1000;i++){
            if(result[i] >max){
                max=result[i];ans=i+1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        int nums []= {1,100,200,1,100};
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);
        System.out.println(frequency(list,1));
    }
}
