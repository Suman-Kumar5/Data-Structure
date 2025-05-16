package Reccursion;

public class lengthOfString {
    public static int lengthString(String str){
        if(str.isEmpty()){
            return 0;
        }
        return lengthString(str.substring(1))+1;
    }
    public static void main(String args[]){
        System.out.println(lengthString("Suman"));
    }
}
