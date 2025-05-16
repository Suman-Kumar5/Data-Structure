package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class nonrepeatingfirstcharacter {
    public static void firstCharacter(String str){
        Queue<Character> q=new LinkedList<>();
        int freq[]=new int[26];
        int n=str.length();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while (!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
            }
            else {
                System.out.print(q.peek()+" ");
            }
        }

    }
    public static void main(String[] args) {
        String s="aabccxb";
        firstCharacter(s);
    }
}
