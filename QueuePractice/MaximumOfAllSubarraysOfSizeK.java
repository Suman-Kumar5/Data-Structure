package QueuePractice;

import java.util.*;

public class MaximumOfAllSubarraysOfSizeK {
    public static int[] printMax(int arr[],int k,int n){
        Deque<Integer> Qi = new LinkedList<>();
        int ans[]=new int[n-k+1];
        int i;
        for (i = 0; i < k; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            Qi.addLast(i);
        }
        int d=0;
        for (; i < n; ++i) {
            ans[d++]=arr[Qi.peek()];
            while ((!Qi.isEmpty()) && Qi.peek() <=i - k){
                Qi.removeFirst();
            }
            while ((!Qi.isEmpty()) && arr[i] >=arr[Qi.peekLast()]){
                Qi.removeLast();
            }
            Qi.addLast(i);
        }
        ans[d]=arr[Qi.peek()];
        return ans;
    }
    public static void main(String[] args) {
        int n=9;
        int K=3;
        int []arr= {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int ans[]= printMax(arr,K,n);
        for(int a:ans){
            System.out.print(a+" ");
        }
    }
}
