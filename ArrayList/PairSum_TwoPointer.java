package ArrayList;

import java.util.ArrayList;

public class PairSum_TwoPointer {
    public static void pairSum(ArrayList<Integer> height,int target){
        int lp=0;
        int rp=height.size()-1;
        while (lp<rp){
            int currSum=height.get(lp)+height.get(rp);
            if(currSum==target){
                System.out.println(lp+","+rp);
                rp--;
                lp++;
            } else if (currSum>target) {
                rp--;
            }else {
                lp++;
            }
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        pairSum(list,7);
    }
}
