package Heaps;
import java.util.*;
public class KthLargestElementInAStream {
    public static void main(String[] args) {
       int  stream[] = {10, 20, 11, 70, 50, 40, 100, 5};
       int n= stream.length;
       int k=3;
       int res[]=new int[n-k+1];
       int j=1;
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       
       for(int i=0;i<k;i++){
           pq.add(stream[i]);
       }
       res[0]= pq.peek();
       for(int i=k;i<n;i++){
          pq.add(stream[i]);
          if(pq.size()>k){
              pq.remove();
          }
          res[j++]= pq.peek();
       }
       for(int i=0;i< res.length;i++){
           System.out.print(res[i]+" ");
       }
    }
}
