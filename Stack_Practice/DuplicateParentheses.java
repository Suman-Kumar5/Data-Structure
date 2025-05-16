package Stack_Practice;

import java.util.Stack;

public class DuplicateParentheses {
    public static boolean isDuplicateParentheses(String str){
        Stack<Character> s=new Stack<>();
        int n=str.length();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            int count=0;
            if(ch==')'){
                while (!s.isEmpty() && s.peek()=='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
                else{
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String  s="((a+b)+(b+c))";
        String st="((a+b))";
        System.out.println(isDuplicateParentheses(s));
        System.out.println(isDuplicateParentheses(st));
    }
}
