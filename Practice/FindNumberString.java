package Practice;

public class FindNumberString {
    static String digit[]={"zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static void printDigit(int n){
        if(n==0){
            return;
        }
        int lastDigit=n%10;
        printDigit(n/10);
        System.out.print(digit[lastDigit]+" ");
    }
    public static int lengthOfString(String s,int n){
        if(n==0){
            return 0;
        }
        return lengthOfString(s,n-1)+1;
    }
    public static void main(String[] args) {
        printDigit(1230);
        String s="Suman";
        System.out.println();
        System.out.println(lengthOfString(s,s.length()));
    }
}
