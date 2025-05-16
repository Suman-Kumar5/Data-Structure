public class DecimalToBinary {
    public static void main(String args[]){
        int n=7;
        int bin=0;
        int pow=0;
        while (n>0){
            int rem=n%2;
            bin=bin+(int)(rem*Math.pow(10,pow));
            pow++;
            n/=2;
        }
        System.out.println(bin);
    }
}
