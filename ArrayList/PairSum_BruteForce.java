package ArrayList;

import java.util.ArrayList;

public class PairSum_BruteForce {
    public static void pairSum(ArrayList<Integer> height,int target){
        int n=height.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(height.get(i)+height.get(j)==target){
                    System.out.println(i+","+j);
                }
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
