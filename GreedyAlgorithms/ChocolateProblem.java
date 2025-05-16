package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class ChocolateProblem {
    public static void main(String[] args) {
        int n=4;
        int m=6;
        Integer costVet[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};

        Arrays.sort(costVet, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;
        while (h<costHor.length && v<costVet.length){
            if(costVet[v]<=costHor[h]){// horizontal cut
                cost+=(costHor[h]*vp);
                hp++;
                h++;
            }
            else{// vertical piece
                cost+=(costVet[v]*hp);
                vp++;
                v++;
            }
        }
        while (h<costHor.length){
            cost+=(costHor[h]*vp);
            hp++;
            h++;
        }
        while (v<costVet.length){
            cost+=(costVet[v]*hp);
            vp++;
            v++;
        }

        System.out.println("Minimum cost :"+cost);
    }
}
