package Stack;

import java.util.Stack;

public class reverseStringStack {
    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        int idx=0;
        while (idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder st=new StringBuilder("");
        while (!s.isEmpty()){
            st.append(s.pop());
        }
        return st.toString();
    }
    public static void main(String args[]){
        String str="abc";
        String sd=reverseString(str);
        System.out.println(sd);
    }
}
