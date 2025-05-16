public class prime {
    public static void main(String args[]){
        printPrime(3,20);
    }
    public static Boolean IsPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void printPrime(int s,int e){
        for(int i=s;i<=e;i++){
            if(IsPrime(i)){
                System.out.println(i);
            }
        }
    }
}
