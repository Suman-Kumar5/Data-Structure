package Reccursion;

public class FindNumberString {
    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void printDigit(int number){
        if(number==0){
            return;
        }
        int lastNumber=number%10;
        printDigit(number/10);
        System.out.print(digits[lastNumber]+" ");
    }

    public static void main(String args[]){
        printDigit(1230);
    }
}
