package ArrayList;

import java.util.ArrayList;

public class ContainMostWater_BruteForce {
    public static int storeWater(ArrayList<Integer> height){
        int maxWater=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j< height.size();j++){
                int hei=Math.min(height.get(i), height.get(j));
                int wid=j-i;
                int currWater=hei*wid;
                maxWater=Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(8);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(storeWater(list));
    }
}
