package Practice;

public class binaryStringProblem {
    public static void printBinString(int n,int lastPlace,String str){
        if(n==0){
            System.out.print(str+" ");
            return;
        }
        printBinString(n-1,0,str+"0");
        if(lastPlace==0){
            printBinString(n-1,1, str + "1");
        }
    }
    public static void main(String args[]){
        printBinString(4,0," ");
    }
}
