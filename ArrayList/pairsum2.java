package ArrayList;
import java.util.ArrayList;
public class pairsum2 {
    public static void pairSum(ArrayList<Integer> l,int target){
        int bp=-1;
        int n=l.size();
        for(int i=0;i<l.size();i++){
            if(l.get(i)>l.get(i+1)){
                bp=i;
                break;
            }
        }
//        System.out.println(bp);
        int lp=bp+1;
        int rp=bp;
        while (lp!=rp){
            if(l.get(lp)+l.get(rp)==target){
                System.out.println(lp+","+rp);
                lp=(lp+1)%n;
                rp=(n+rp-1)%n;
            }
            if(l.get(lp)+l.get(rp)<target){
                lp=(lp+1)%n;
            }
            else{
                rp=(n+rp-1)%n;
            }
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        pairSum(list,18);
    }
}
