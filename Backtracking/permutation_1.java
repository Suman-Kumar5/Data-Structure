package Backtracking;

public class permutation_1 {
    public static void findPermutation(String str,String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        int n=str.length();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            findPermutation(newStr,ans+ch);
        }
    }
    public static void main(String[] args) {
        String str="abc";
        findPermutation(str,"");
    }
}