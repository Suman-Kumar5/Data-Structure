package GreedyAlgorithms;

import java.util.Arrays;

public class MinimumSumAbsoluteDifference {
    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]={2,1,3};
        Arrays.sort(a);
        Arrays.sort(b);
        int minSum=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>=b[i]){
                minSum+=Math.abs(a[i]-b[i]);
            }
        }
        System.out.println(minSum);
    }
}
