package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class indianCoin {

    // which greedy approach can work coin system that system is called canonical coin System
    public static void main(String[] args) {
        int coin[]={1,2,5,10,20,50,100,500,2000};
        ArrayList<Integer> a=new ArrayList<>();
        Arrays.sort(coin);
        int value=590;
        int ans=0;
        for(int i= coin.length-1;i>=0 ;i--){
            if(coin[i]<=value){
                while (coin[i]<=value){
                    ans++;
                    value-=coin[i];
                    a.add(coin[i]);
                }
            }
        }
        System.out.println(ans);
        System.out.println(a);
    }
}
