package String;

public class Sum_of_Beauty_of_All_Substrings {
    public static int beautySum(String s) {
        int freq[]=new int[26];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int n=s.length();
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<25;i++){
            int data=freq[i];
            if(data>max){
                max=data;
            }
            if( data!=0 && data<min){
                min=data;
            }
        }
        return max-min;
    }
    public static void main(String args[]){
        String s = "aabcb";
        System.out.println(beautySum(s));
    }
}
