package GreedyAlgorithms;

public class BestTimeToBuyAndSellStock {
    public static int buyAndSellStock(int price[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        int n=price.length;
        for(int i=0;i<n;i++){
            if(buyPrice<price[i]){
                int profit=price[i]-buyPrice;
                maxProfit=Math.max(maxProfit,profit);
            }
            else{
                buyPrice=price[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int price[]={7, 6, 4, 3, 1};
        System.out.println(buyAndSellStock(price));
    }
}
