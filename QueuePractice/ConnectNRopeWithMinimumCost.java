package QueuePractice;

import java.util.PriorityQueue;

public class ConnectNRopeWithMinimumCost {
    public static int minCost(int arr[]){
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            q.add(arr[i]);
        }
        while (q.size()>1){
            int first=q.poll();
            int second=q.poll();
            int sum=first+second;
            q.add(sum);
            ans+=sum;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        System.out.println(minCost(arr));
    }
}
