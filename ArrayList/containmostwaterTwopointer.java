package ArrayList;

import java.util.ArrayList;

public class containmostwaterTwopointer {
    public static int storeWater(ArrayList<Integer> height){
        int lp=0;
        int rp=height.size()-1;
        int maxWater=0;
        while (lp<rp){
            int hei=Math.min(height.get(lp),height.get(rp));
            int wid=rp-lp;
            int currWater=hei*wid;
            maxWater=Math.max(maxWater,currWater);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }
            else{
                rp--;
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
//        System.out.println(list.size());
    }
}
