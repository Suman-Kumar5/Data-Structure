import java.util.*;
import java.util.PriorityQueue;

public class pratice_1 {
    public int[] searchRange(int[] nums, int target) {
        int p[] = {-1, -1};
        int i = 0;
        int j = nums.length - 1;
        int left = firocce(nums, target, j, true);
        int right = firocce(nums, target, j, false);
        p[0] = left;
        p[1] = right;
        return p;
    }

    public static int firocce(int arr[], int key, int n, boolean isSearchLeft) {
        int s = 0, e = n - 1;
        int ans = -1;
        int idx = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (key == arr[mid]) {
                idx = mid;
                if (isSearchLeft) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (key > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return idx;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int arr[] = new int[n1];
        int k = 0;
        for (int i = 0; i < n1; i++) {
            arr[k] = -1;
            for (int j = i; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    if (nums1[i] < nums2[j]) {
                        arr[k++] = nums2[j];
                        break;
                    }
                }
            }
            k++;
        }
        return arr;
    }

    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int i = 0, j = 0;
        for (int k = 0; k < n; k++) {
            if (nums[i] > nums[k]) {
                i = k;
            }
            if (nums[j] < nums[k]) {
                j = k;
            }
        }
        return Math.min(Math.min(Math.max(i + 1, j + 1), Math.max(n - i, n - j)), Math.min(i + 1 + n - j, j + 1 + n - i));

    }

    public static int[] findMissingAndRepeatedValues(int[][] arr) {
        int ans[] = new int[2];
        int repeat = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                pq.add(arr[i][j]);
            }
        }
        while (!pq.isEmpty()) {
            int a = pq.remove();
            int b = pq.remove();
            if (a == b) {
                ans[0] = a;
            }
            if ((b - a) != 1) {
                ans[1] = b - 1;
            }
        }
        return ans;
    }

    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int sufix[] = new int[n];
        sufix[0] = 1;
        int prefix[] = new int[n];
        prefix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }
        for (int i = n - 2; i > -1; i--) {
            sufix[i] = sufix[i + 1] * arr[i + 1];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = sufix[i] * prefix[i];
        }
        return arr;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int ans[] = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (nums2[j] >= nums1[i]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }
        while (i < n1) {
            ans[k++] = nums1[i++];
        }
        while (j < n2) {
            ans[k++] = nums2[j++];
        }
        double median = 0;
        if (n % 2 == 0) {
            median = (double) (ans[n / 2] + ans[(n / 2) - 1]) / 2;
        } else {
            median = ans[n / 2];
        }
        return median;
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> occurrences = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == x) {
                occurrences.add(i);
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            if (queries[i] <= occurrences.size()) {
                result[i] = occurrences.get(queries[i] - 1);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    public static int printEvenOrOdd(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] % 2 == 0 && arr[i + 1] % 2 != 0) {
                return -1;
            }
        }
        return arr[0] % 2;
    }

    public static void reverseFromK(int nums1[], int num2[], int k) {
        int n = nums1.length;
        int j = 0;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        while (j < k) {
            arr1[j] = nums1[j];
            arr2[j] = num2[j];
            j++;
        }
        n--;
        while (n >= k) {
            arr1[j] = nums1[n];
            arr2[j] = num2[n];
            j++;
            n--;
        }
        for (int a : arr1) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int b : arr2) {
            System.out.print(b + " ");
        }
    }

    // public static void reverseFromK(int nums1[],int num2[],int k){
//
// }
    public static int matrixSum(int[][] nums) {
        int sum = 0;
        int n = nums[0].length;
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < nums[i].length; j++) {
                pq.add(nums[j][i]);
            }
            sum += pq.remove();
        }
        return sum;
    }

    public static int getLucky(String s, int k) {
        int currentNumber = 0;
        for (char ch : s.toCharArray()) {
            int position = ch - 'a' + 1;
            while (position > 0) {
                currentNumber += position % 10;
                position /= 10;
            }
        }

        // Apply digit sum transformations k-1 times
        for (int i = 1; i < k; ++i) {
            int digitSum = 0;
            while (currentNumber > 0) {
                digitSum += currentNumber % 10;
                currentNumber /= 10;
            }
            currentNumber = digitSum;
        }

        return currentNumber;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int arr[] = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (++arr[i - 1] > 1)
                list.add(i);
        }
        return list;
    }

    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        int count = 2;
        for (int i = 5; i < n; i = i + 2) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int n1 = (int) Math.sqrt(n);
        for (int i = 5; i <= n1; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static int maximumCount(int[] nums) {
        int e = nums.length;
        int s = 0;
        int z = 0;
        for (int i = 0; i < e; i++) {
            if (nums[i] == 0) {
                z++;
                continue;
            }
            if (nums[i] > 0) {
                s++;
            }
        }
        int n = e - s - z;
        return Math.max(n, s);
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k)
                k++;
        }
        return k;
    }

    public static int jump(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            c++;
            if (arr[i] >= n - 1) {
                break;
            }
        }
        return c;
    }

    public static int countGoodSubstrings(String s) {
        int n = s.length();
        int c = 0;
        for (int i = 0; i <= n - 3; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < i + 3; j++) {
                set.add(s.charAt(j));
            }
            if (set.size() == 3) {
                c++;
            }
        }
        return c;
    }

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        temp.removeFirst();
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                temp.add(max);
            }
        }
        int n1 = temp.size();
        for (int i = n1 - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
        return ans;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (end >= start) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int freq[] = new int[26];
        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 != n2) {
            return false;
        }
        for (int i = 0; i < n1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            freq[ch2 - 'a']++;
            freq[ch1 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int sumSubarrayMins(int[] arr) {
        int minSum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currentMin = arr[i];
            for (int j = i; j < n; j++) {
                currentMin = Math.min(currentMin, arr[j]);
                minSum += currentMin;
            }
        }
        return minSum;
    }

    private static int min(ArrayList<Integer> arr) {
        int n = arr.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > arr.get(i)) {
                min = arr.get(i);
            }
        }
        return min;

    }

    public static String largestOddNumber(String num) {
        int n = num.length();
        String str = "";
        for (int i = n - 1; i >= 0; i--) {
            int number = num.charAt(i) - '0';
            if (number % 2 == 1) {
                str = num.substring(i);
                break;
            }
        }
        return str;
    }

    public static boolean rotateString(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();
        if (n1 != n2) {
            return false;
        }
        for (int i = 0; i < n1; i++) {
            if (rotate(s, i).equals(goal)) {
                return true;
            }
        }
        return false;
    }

    private static String rotate(String str, int i) {
        return str.substring(i) + str.substring(0, i);
    }


    public static int maxProduct(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        int maxProduct = 0;

        int prefix[] = new int[n];
        Arrays.fill(prefix, 1);
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i] * arr[i - 1];
        }

        int suffix[] = new int[n];
        Arrays.fill(suffix, 1);
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            maxProduct = Math.max(maxProduct, prefix[i]);
            maxProduct = Math.max(maxProduct, suffix[i]);
        }
        return maxProduct;
    }

    public static void countChar(String str, char ch) {
        char arr[] = str.toCharArray();
        int n = arr.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ch) {
                c++;
            }
        }
        if (c > 0) {
            System.out.println(c);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        // int arr1[]={0,4,19,1,8,2,3,5};
        // System.out.println(minimumDeletions(arr1));
        // int [] nums1 = {4,1,2};
        // int nums2[] = {1,3,4,2};
        // int arr[]=nextGreaterElement(nums1,nums2);
        // for(int a:arr){
        // System.out.print(a+" ");
        // }
        // int nums[] = {5, 7, 7, 8, 8, 10};
        // int target = 8;
        // searchRange(nums, target);
        //
        // int [][]grid = {{9,1,7},{8,9,2},{3,4,6}};
        // System.out.println(findMissingAndRepeatedValues(grid));
        // int []nums = {1,2,3,4};
        // int arr[]=productExceptSelf(nums);
        // for(int a:arr){
        // System.out.print(a+" ");
        // }
        // int []nums1 = {1,2};
        // int nums2[] = {3,4};
        // System.out.println(findMedianSortedArrays(nums1,nums2));
        // int [] nums = {1,1,3,7};
        // int []queries = {1,3,2,4};
        // int x = 1;
        // int arr[]=occurrencesOfElement(nums,queries,x);
        // for(int i:arr){
        // System.out.print(i+" ");
        // }
        // int arr[]={1,2,3,4,5};
        // int arr1[]={5,4,3,2,1};
        // reverseFromK(arr,arr1,2);
        // int [][]nums = {{7,2,1},{6,4,2},{6,5,3},{3,2,1}};
        // System.out.println(matrixSum(nums));
        // String s = "dbvmfhnttvr";
        // int k = 5;
        // System.out.println(getLucky(s,k));
        // int [] nums = {4,3,2,7,8,2,3,1};
        // findDuplicates(nums);
        // System.out.println(countPrimes(100));
        // int [] nums = {-3,-2,-1,0,0,1,2};
        // System.out.println(maximumCount(nums));
        // int [] arr = {2,3,4,7,11};
        // int k = 5;
        // System.out.println(findKthPositive(arr,k));
        // int []nums = {2,3,1,1,4};
        // jump(nums);
        // String s = "aababcabc";
        // countGoodSubstrings(s);
        // int []arr={16, 17, 4, 3, 5, 2};
        // leaders(arr);
        // int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        // rotate(matrix);
        // System.out.println(isAnagram("erac","care"));
        // int []arr={1,2,1,3,5,6,4};
        // findPeakElement(arr);
        // int arr[]={3,1,2,4};
        // sumSubarrayMins(arr);
        // String num = "52";
        // largestOddNumber(num);
//    String s = "abcde";
//    String goal = "cdeab";
//    System.out.println(rotateString(s, goal));
//    int []arr={2,3,-2,4};
//    System.out.println(maxProduct(arr));
//    countChar("GoodMorning",'o');
    }
}