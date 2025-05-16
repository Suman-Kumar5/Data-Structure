package ArrayList;

import java.util.ArrayList;

public class twoDimArraylist {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> ml=new ArrayList<>();
        ArrayList<Integer>  l1=new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        ml.add(l1);
        ArrayList<Integer>  l2=new ArrayList<>();
        l2.add(6);
        l2.add(7);
        l2.add(8);
        l2.add(9);
        l2.add(10);
        ml.add(l2);
        ArrayList<Integer>  l3=new ArrayList<>();
        l3.add(11);
        l3.add(12);
        l3.add(13);
        l3.add(14);
        l3.add(15);
        ml.add(l3);
        System.out.println(ml);
        for(int i=0;i<ml.size();i++){
            ArrayList<Integer> curr=ml.get(i);
            for(int j=0;j< curr.size();j++){
                System.out.print(curr.get(j)+" ");
            }
            System.out.println();
        }
    }
}
