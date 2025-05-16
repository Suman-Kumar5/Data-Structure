package Stack_Practice;

import java.util.Stack;

public class reversestringstack {
    public static void reverse(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        String newStr="";
        while (!s.isEmpty()){
            newStr+=s.pop();
        }
        System.out.println(newStr);
    }
    public static void main(String[] args) {
        String str="suman";
        reverse(str);
    }
}
