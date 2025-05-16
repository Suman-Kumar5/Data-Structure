package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class ConnectNRopeWithMinimumCost {
    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        // yaha per priority queue esliya
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int ans=0;
        while (pq.size()>1){
            int first= pq.poll();
            int second= pq.poll();
            int sum=first+second;
            pq.add(sum);
            ans+=sum;
        }
        System.out.println(ans);
    }
}
