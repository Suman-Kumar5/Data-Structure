package GreedyAlgorithms_Pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoin {
    public static void main(String[] args) {
        int coin[]={1,2,5,10,20,50,100,500,2000};
        ArrayList<Integer> coins=new ArrayList<>();
        Arrays.sort(coin);
        int n=590;
        int ans=0;
        for(int i=coin.length-1;i>=0;i--){
            if(n>=coin[i]){
                while (n>=coin[i]){
                    n-=coin[i];
                    coins.add(coin[i]);
                    ans++;
                }
            }
        }
        System.out.println(ans);
        System.out.println(coins);
    }
}
