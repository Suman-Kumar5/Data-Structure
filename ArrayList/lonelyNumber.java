package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class lonelyNumber {
    public static ArrayList<Integer>  lonelyNumber(ArrayList<Integer> list){
        Collections.sort(list);
        int n= list.size();
        ArrayList<Integer> l=new ArrayList<>();
        if(n==1){
            l.add(list.get(0));
        }
        for(int i=1;i<n-1;i++){
            if(list.get(i-1)+1< list.get(i) && list.get(i)< list.get(i+1)-1){
                l.add(list.get(i));
            }
        }
        if(n>1){
            if(list.get(0)+1<list.get(1)){
                l.add(list.get(0));
            }
            if(list.get(n-2)+1<list.get(n-1)){
                l.add(list.get(n-1));
            }
        }
        return l;
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        System.out.println(lonelyNumber(list));
    }
}
