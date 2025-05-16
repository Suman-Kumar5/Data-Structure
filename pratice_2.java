import java.util.*;

public class pratice_2 {
    public static int[] rearrangeArray(int[] num) {
        int n=num.length;
        int arr1[]=new int[n/2];
        int arr2[]=new int[n/2];
        int k=0;
        int j=0;
        for(int i=0;i<n;i++){
            if(num[i]>0){
                arr1[k++]=num[i];
            }
            else{
                arr2[j++]=num[i];
            }
        }
        int i=0;
        int t=0;
        int f=0;
        while(i<n && t<n/2 && f< n/2){
            num[i++]=arr1[t++];
            num[i++]=arr2[f++];
        }
        return num;
    }

    public static int[] resultsArray(int[] arr, int k) {
        int n=arr.length;
        int ans[]=new int[n-k+1];
        int l=0;
        for(int i=0;i<n-k+1;i++){
            int max=0;
            for(int j=i;j<i+k-1;j++){
                if(arr[j]<arr[j+1]){
                    max=Math.max(max,Math.max(arr[j],arr[j+1]));
                }
                else{
                    ans[l]=-1;
                    break;
                }
                ans[l]=max;
            }
            l++;
        }
        return ans;
    }
    public static void printUnique(int arr[]){
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]!=arr[i+1]) {
                ans.add(arr[i]);
            }
        }
        if(arr[n-1]!=arr[n-2]){
            ans.add(arr[n-1]);
        }
        for(int a:ans){
            System.out.print(a+" ");
        }
    }
    public static String reverseWords(String s) {
        s=s.trim();
        String str[]=s.split(" ");
        int n=str.length;
        String st="";
        for(int i=n-1;i>=1;i--){
            String a=str[i].trim();
            if(a!=""){
                st+=a+" ";
            }

        }
        st=st+str[0];
        return st;
    }
    public static List<Integer> findPeaks(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        if(n>=2){
            return ans;
        }
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                ans.add(i);
            }
        }
        return ans;
    }
    public static int HammingDistance(int a,int b){
        int n=a&b;
        int c=0;
        while(n>=0){
            int rem=n%2;
            if(rem==1){
                c++;
            }
            n=n/2;
        }
        return c;
    }
    public static int findPairs(int[] arr, int k) {
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> seenPairs = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            if (uniqueElements.contains(num - k) && !seenPairs.contains(num)) {
                count++;
                seenPairs.add(num);
            }
            if (uniqueElements.contains(num + k) && !seenPairs.contains(num + k)) {
                count++;
                seenPairs.add(num + k);
            }
            uniqueElements.add(num);
        }

        return count;
    }
    public static boolean binarySearch(int s,int e,int arr[],int target){
        while(e>=s){
            int mid=s+(e-s)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[mid]<target){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return false;
    }
    public static char findTheDifference(String s, String t) {
        int count[]=new int[26];
        for(char c:s.toCharArray()){
            ++count[c-'a'];
        }
        for(char c:t.toCharArray()){
            if(count[c-'a']==0){
                return c;
            }
            --count[c-'a'];
        }
        return 'a';
    }
    public static int[][] merge(int[][] intervals) {
        ArrayList<int []> ans=new ArrayList<>();
        int n=intervals.length;
        for(int i=1;i<n;i++){
            int []temp=new int[2];
            if(intervals[i-1][1]>=intervals[i][0]){
                temp[0]=intervals[i-1][0];
                temp[1]=intervals[i][1];
                i++;
            }
            else{
                temp[0]=intervals[i-1][0];
                temp[1]=intervals[i-1][1];
            }
            ans.add(temp);
        }
        int []temp=new int[2];
        if(intervals[n-2][1]>=intervals[n-1][0]){
            temp[0]=intervals[n-2][0];
            temp[1]=intervals[n-1][1];
        }
        else{
            temp[0]=intervals[n-1][0];
            temp[1]=intervals[n-1][1];
        }
        ans.add(temp);
        int [][] result=new int[ans.size()][2];
        result = ans.toArray(result);
        return result;
    }
    public static int largestRectangleArea(int[] height) {
        int n=height.length;
        // Calculate the left max boundary - Array
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }

        // Calculate the right max boundary - Array
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        int max=0;
        // loop
        for(int i=0;i<n;i++){
            int area = height[i] * (rightMax[i] - leftMax[i] + 1);
            //trapped Water=waterLevel - height of tower
            if(area>max){
                max=area;
            }
        }
        return max;
    }

    public static int singleNumber(int arr[]){
        int n=arr.length;
        if(n==1){
            return arr[0];
        }
        int data=0;
        for(int i=0;i<n;i++){
            data^=arr[i];
        }
        return data;
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                s.push(s.pop() + s.pop());
            } else if (str.equals("-")) {
                int second = s.pop();
                int first = s.pop();
                s.push(first - second);
            } else if (str.equals("/")) {
                int second = s.pop();
                int first = s.pop();
                s.push(first / second);
            } else if (str.equals("*")) {
                s.push(s.pop() * s.pop());
            } else {
                s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
    public static String simplifyPath(String path) {
        Stack<String> s=new Stack<>();
        path = path.replaceAll("/+", "/");
        String[] arr =path.split("/");
        int n=arr.length;
        for(int i=0;i<n;i++){
            String str=arr[i];
            if(str.equals(".") || str.isEmpty()){
                continue;
            }
            else if(str.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else{
                s.push(str);
            }
        }
        StringBuilder ans= new StringBuilder();
        while(!s.isEmpty()){
            ans.insert(0, "/" + s.pop());
        }
        return !ans.isEmpty() ? ans.toString() : "/";
    }

    public static List<String> summaryRanges(int[] arr) {
        List<String> ans = new ArrayList<>();
        int n = arr.length;
        String str = "";
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                if (arr[i] == arr[temp]) {
                    str = str + arr[temp];
                } else
                    str = str + arr[temp] + "->" + arr[i];
                ans.add(str);
                temp = i + 1;
            } else {
                str = str + arr[i];
                ans.add(str);
                temp = i + 1;
            }
            str = "";
        }
        return ans;
    }

    public static boolean containsNearbyDuplicate(int[] arr, int k) {
        int n=arr.length;
        int sz=n/k;
        int d=0;
        for(int j=0;j<=sz;j++){
            HashMap<Integer,Integer> map=new HashMap<>();
            int i=0;
            while(i<k && d<n){
                i++;
                if(map.containsKey(arr[d])){
                    return true;
                }
                else{
                    map.put(arr[d],1);
                }
                d++;
            }
        }
        return false;
    }
    public static int maxSubarraySumCircular(int[] arr) {
        int cs=0;
        int ms=arr[0];
        int n=arr.length;
        boolean flag=false;
        for(int i=0;i<n;i++){
            cs+=arr[i];
            ms=cs>ms?cs:ms;
            if(cs<0){
                cs=0;
            }
            if(i==n-1){
                if(flag){
                    break;
                }
                i=-1;
                flag=true;
            }
        }
        return ms;
    }

    public static  int minSubArrayLen(int target, int[] arr) {
        int n=arr.length;
        int start=0;
        int end=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        while(end<n){
            sum+=arr[end];
            while(sum>=target){
                if(end-start+1<min)min=end-start+1;
                sum-=arr[start++];
            }
            end++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    public static int lengthOfLongestSubstring(String s) {
        int arr[]=new int[26];
        int start=0;
        int end=0;
        int n=s.length();
        int max=1;
        while(end<n){
            char ch=s.charAt(end);
            arr[ch-'a']++;
            if(arr[ch-'a']>1){
                arr[ch-'a']--;
                start++;
            }
            max=end-start+1>max?end-start+1:max;
            end++;
        }
        return max;
    }

    public int max(int arr[],int k){
        int count=0;
        for(int a:arr){
            if(a>k)count++;
        }
        return count;
    }

    public static int nextBeautifulNumber(int n) {
        int ans=0;
        n++;
        while(true){
            int x=n;
            int arr[]=new int[10];
            while(x>0){
                arr[x%10]++;
                x/=10;
            }
            int c=1;
            for(int i=0;i<10;i++){
                if(arr[i]>0&&arr[i]!=i){
                    c=0;
                    break;
                }
            }
            if(c==1){
                ans=n;
                break;
            }
            else{
                n++;
            }
        }
        return ans;
    }

    public static boolean checkValidString(String str) {
        Stack<Character> s=new Stack<>();
        int star=0;
        int n=str.length();
        for(int i=0;i<n;i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                s.push(ch);
            } else if (ch == '*') {
                star++;
            } else if (ch == ')') {
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop();
                } else if (star > 0) {
                    star--;
                } else {
                    return false;
                }
            }
        }
        return star >= s.size();
    }
    public static boolean checkValidString1(String str) {
        Stack<Integer> stack = new Stack<>();
        int starCount = 0; // Count of asterisks
        int n = str.length();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(i); // Push the index of '(' onto the stack
            } else if (ch == '*') {
                starCount++; // Increment star count for '*'
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Match with the last '('
                }
                else if (starCount > 0) {
                    starCount--; // Use a '*' as a matching '('
                }
                else {
                    return false; // No matching '(' for this ')'
                }
            }
        }

        // After processing all characters, check if we can balance remaining '('
        return stack.size() <= starCount; // Remaining '(' can be matched with '*'
    }

    public static int rearrangeCharacters(String s, String target) {
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            freq1[s.charAt(i)-'a']++;
        }
        for(int i=0;i<target.length();i++){
            freq2[target.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq2[i]>0){
                int f1=freq1[i];
                int f2=freq2[i];
                ans=Math.min(ans,f1/f2);
            }
        }
        return ans;
    }

    public static String addSpaces(String s, int[] spaces) {
        int n=spaces.length;
        String res=s.substring(0,spaces[1]);
        for(int i=1;i<n-1;i++){
            String ans=s.substring(spaces[i],spaces[i+1]);
            res=res+" "+ans;
        }
        return res;
    }
    public static int removeDuplicates(int[] arr) {
        int k=0;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]!=arr[i+1]){
                arr[k++]=arr[i];
            }
        }
         arr[k++]=arr[k+1];
        return arr.length;
    }
    public static void moveZeroes(int[] arr) {
        int n=arr.length;
        HashSet<Integer> ha=new HashSet<>();
//        ha.remove()
        int k=0;
        int c=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[k++]=arr[i];
            }
            else{
                c++;
            }
        }
        while(c>0){
            arr[k++]=0;
            c--;
        }
    }
    public static int findMaxConsecutiveOnes(int[] arr) {
        int n=arr.length;
        int max=0;
        int count=1;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                count++;
            }
            else{
                max=count>max?count:max;
                count=1;
            }
        }
        max=count>max?count:max;
        return max;
    }

    public static int subarraySum(int[] arr, int k) {
        int n=arr.length;
        if(n==1&& arr[0]==k){
            return 1;
        }
        if(n == 1){
            return 0;
        }
        int start=0;
        int end=1;
        int sum=arr[0];
        int c=0;
        while(end<n){
            sum+=arr[end];
            if(sum==k){
                c++;
                start++;
            }
            if(sum>k){
                sum-=arr[start];
                start++;
            }
            end++;
        }
        return c;
    }

        public static void main(String[] args) {
//        int arr[]={9,12,7,11};
//        int k=8;
//        System.out.println(max(arr,k));
//        int arr[]={2,7,2,7,1};
//        System.out.println(singleNumber(arr));
//        int [] nums = {3,1,-2,-5,2,-4};
//        int arr[]=rearrangeArray(nums);
//        for(int a:arr){
//            System.out.print(a+" ");
//        }
//        int []  nums = {1};
//        int k = 1;
//        resultsArray(nums,k);
//        int arr[]={0,0,1,1,1,2,2,3,3,4};
//        printUnique(arr);
//        String s = "a good   example";
//        System.out.println(reverseWords(s));
//        int []mountain = {1,4,3,8,5};
//        findPeaks(mountain);
//       int [] nums = {1,2,3,4,5};
//       int k = 2;
//       System.out.println(findPairs(nums,k));
//        String s = "aa";
//        String t = "a";
//        findTheDifference(s,t);
//        int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
//        merge(intervals);
//        int []heights = {2,1,5,6,2,3};
//        System.out.println(largestRectangleArea(heights));
//        String []tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        evalRPN(tokens);
//        String str="/../";
//        System.out.println(simplifyPath(str));
//            int []nums = {0,2,3,4,6,8,9};
//            summaryRanges(nums);
//           int [] nums = {1,2,3,1};
//            int k = 3;
//            containsNearbyDuplicate(nums,k);
//            int []nums = {5,-3,5};
//            maxSubarraySumCircular(nums);
//            int  target =11;
//            int []nums = {1,2,3,4,5};
//            System.out.println(minSubArrayLen(target,nums));
//            String s = "pwwkew";
//            System.out.println(lengthOfLongestSubstring(s));
//            System.out.println(nextBeautifulNumber(1000));
//            System.out.println(checkValidString1("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
//            String s = "ilovecodingonleetcode";
//            String target = "code";
//            rearrangeCharacters(s,target);
//            String s = "LeetcodeHelpsMeLearn";
//            int []spaces = {8,13,15};
//            System.out.println(addSpaces(s,spaces));
//            int []nums = {1,1,2};
//            removeDuplicates(nums);
//            int []nums = {0,1,0,3,12};
//            moveZeroes(nums);
//            int [] num={1,1,0,1,1,1};
//            findMaxConsecutiveOnes(num);
            int []num={-1,-1,1};
            int k=0;
            subarraySum(num,k);
    }
}
