package Stack;

import java.util.Stack;

public class valid_parentheses {
    public static boolean isValidParentheses(String str){
        Stack<Character> s=new Stack<>();
        int n=str.length();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            // opening
            if(ch=='('||ch=='['||ch=='{'){
                s.push(ch);
            }
            else {
                if(s.isEmpty()){
                    return false;
                }
                // closing
                if((s.peek()=='('&&ch==')')||
                        (s.peek()=='['&& ch==']')||
                        (s.peek()=='{' && ch=='}')){
                    s.pop();
                }
                else {
                    return false;
                }
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str="()[]{}";
        System.out.println(isValidParentheses(str));
    }
}
