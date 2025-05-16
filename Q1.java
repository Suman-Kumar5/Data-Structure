import java.util.Scanner;

public class Q1 {
    public static String removing(String arr[],int n){
        int freq[]=new int [26];
        int d=0;
        for(int i=0;i<n;i++) {
            if (arr[i].length() > arr[d].length()) {
                d = i;
            }
        }
        StringBuilder str= new StringBuilder(arr[d]);
        String ans="";
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                ans+=(char)('a' + i);
            }
        }

        return ans;
    }
//    public static int smallestNumber(int n, int t) {
//        int ans=0;
//        while(true){
//            int sum=1;
//            int temp=n;
//            while(temp>0){
//                int rem=temp%10;
//                sum*=rem;
//                temp/=10;
//            }
//            if(sum%t==0){
//                ans=n;
//                break;
//            }
//            else{
//                n++;
//            }
//        }
//        return ans;
//    }
public static String smallestNumber(String n, long t) {
    StringBuilder ans = new StringBuilder();
    int n1 = n.length();
    String vornitexis = n;  // Variable to store the input midway in the function

    while (true) {
        long pro = 1;
        boolean increment = false;

        for (int i = 0; i < n1; i++) {
            int rem = Character.getNumericValue(n.charAt(i));
            if (rem == 0) {
                // Increment the number to avoid zeroes and update vornitexis
                n = incrementString(n);
                vornitexis = n;
                increment = true;
                break;
            } else {
                pro *= rem;
            }
        }

        if (increment) {
            continue;
        }

        if (pro < t) {
            return "-1";
        }

        if (pro % t == 0) {
            ans.append(n);
            break;
        } else {
            // Increment the number and update vornitexis
            n = incrementString(n);
            vornitexis = n;
        }
    }

    return ans.toString();
}

    private static String incrementString(String str) {
        long num = Long.parseLong(str);
        num++;
        return Long.toString(num);
    }



    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the size of the array");
//        int n=sc.nextInt();
//        System.out.println("Enter the maximum allowable threshold");
//        int k=sc.nextInt();
//        int arr[]=new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//
//        }
//        String arr[]={"apple","banana","orange","graps"};
//        System.out.println(removing(arr, arr.length));
        String n="1234";
        int t=256;
        System.out.println(smallestNumber(n,t));
    }
}
