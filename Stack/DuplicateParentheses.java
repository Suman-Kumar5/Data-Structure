package Stack;

import java.util.Stack;

public class DuplicateParentheses {
    public static boolean isDuplicateParentheses(String st){
        Stack<Character> s=new Stack<>();
        int n=st.length();
        for(int i=0;i<n;i++){
            char ch=st.charAt(i);
            // closing
            if(ch==')'){
                int count=0;
                while (s.isEmpty() && s.peek()!=')'){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else {
                    s.pop();
                }
            }
            else {
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
