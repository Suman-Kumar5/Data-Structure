package Backtracking;

import java.util.*;

public class subSet {
    // jb n chez hota h..uska 2^n subSet banta h
    public static void findSubSet(String str,int i,String ans){
        if(i==str.length()){
            if(ans.isEmpty()){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        // yes
        findSubSet(str,i+1,ans+str.charAt(i));
        // no
        findSubSet(str,i+1,ans);
    }

    public static List<List<Integer>> permutation(int nums[]){
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums);
        return result;
    }
    private static void backtrack(List<List<Integer>> result,ArrayList<Integer> tempList,int[]nums){
        if(tempList.size()== nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int number:nums){
            //
            if(tempList.contains(number)){
                continue;
            }

            // add a new element
            tempList.add(number);

            // Go back to try another element
            backtrack(result, tempList, nums);

            // remove the element
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
//        String str="abc";
//        findSubSet(str,0," ");
        int arr[]={1,2,3};
        List<List<Integer>> ans=permutation(arr);
        System.out.println(ans);
    }
}
