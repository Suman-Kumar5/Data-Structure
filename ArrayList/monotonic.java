package ArrayList;

import java.util.ArrayList;

public class monotonic {
    public static boolean isMonotonic(ArrayList<Integer> l){
        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>l.get(i+1)){
                 inc=false;
            }
            if(l.get(i)<l.get(i+1)){
                dec=false;
            }

        }
        return inc||dec;
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(2);
        list.add(1);
        System.out.println(isMonotonic(list));
    }
}
