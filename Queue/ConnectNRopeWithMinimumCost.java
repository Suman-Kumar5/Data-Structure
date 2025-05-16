package Queue;

import java.util.PriorityQueue;

public class ConnectNRopeWithMinimumCost {
    public static int minCost(int []arr){
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            p.add(arr[i]);
        }
        int ans=0;
        while (p.size()>1){
            int first=p.poll();
            int second=p.poll();
            int sum=first+second;
            p.add(sum);
            ans+=sum;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        System.out.println(minCost(arr));
    }
}
