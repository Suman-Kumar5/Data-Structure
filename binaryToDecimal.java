public class binaryToDecimal {
    public static void main(String args[]){
        int b=100;
        double dec=0;
        double po=0;
        while (b>0){
            int rem=b%10;
            dec+=(rem*Math.pow(2,po));
            po++;
            b=b/10;
        }
        System.out.println(dec);
    }
}
