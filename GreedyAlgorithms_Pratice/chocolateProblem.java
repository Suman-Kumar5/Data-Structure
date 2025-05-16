package GreedyAlgorithms_Pratice;

import java.util.Arrays;
import java.util.Collections;

public class chocolateProblem {
    public static void main(String[] args) {
        int n=4;
        int m=6;
        Integer costVet[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVet,Collections.reverseOrder());

        int h=0;
        int v=0;
        int hp=1,vp=1;
        int cost=0;
        while (costHor.length>h && costVet.length>v){
            if(costVet[v]>=costHor[h]){
               cost+=(costVet[v]*hp);
               v++;
               vp++;

            }
            else{
                cost+=costHor[h]*vp;
                h++;
                hp++;
            }
        }
        while (costVet.length>v){
            cost+=(costVet[v]*hp);
            v++;
            vp++;
        }
        while (costHor.length>h){
            cost+=(costHor[h]*vp);
            h++;
            hp++;
        }
        System.out.println(cost);
    }
}
