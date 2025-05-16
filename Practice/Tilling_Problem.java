package Practice;

public class Tilling_Problem {
    public static int tilling(int n){
        if(n==0||n==1){
            return 1;
        }
        // jab vertical tile lagaaga tb
        int nm1=tilling(n-1);
        // jab horizontal tile lagaaga tb
        int nm2=tilling(n-2);
        return nm1+nm2;
    }
    public static void main(String args[]){
        System.out.println(tilling(4));
    }
}
