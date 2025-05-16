package Stack_Practice;

import java.util.Stack;

public class valid_parentheses {
    public static boolean  validOrNot(String str){
        Stack<Character> s=new Stack<>();
        int n=str.length();
        for (int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='['||ch=='{'){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                else{
                    if((ch==')' && s.peek()=='(')|| (ch==']' && s.peek()=='[')||(s.peek()=='{' && ch=='}') ){
                        s.pop();
                    }
                }
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="([])()";
        System.out.println(validOrNot(s));
    }
}
