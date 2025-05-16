package BitManipulation;

public class OddOrEven {
    //  number ka right last digit agar 0 hota h. To number even hota h
    public static void evenOdd(int n){
        int bitMass=1;
        if((n & bitMass)==0){
            // yaha per integer 1 ka sath AND lgaa h kuke 1 ko bit ma 001 lekhta h to kese v number ka sath agar
            // AND lgata h to phir last digit check krta h.. agar vo 0 hota hai to even hai nito odd hai

            System.out.println("Even Number");
        }
        else{
            System.out.println("Odd Number");
        }
    }
    public static void main(String args[]){
        int n=65;
        evenOdd(n);
    }
}
