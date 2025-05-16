package Array_1;

public class BestTimeToBuyAndSellStock_2 {
    public static void getMaxProfit(int []price){
        int maxProfit=Integer.MIN_VALUE;
        int buyPrice=Integer.MAX_VALUE;
        int n=price.length;
        for(int i=0;i<n;i++){
            if(price[i]>buyPrice){
                int profit=price[i]-buyPrice;
                maxProfit=Math.max(profit,maxProfit);
            }
            else{
                buyPrice=price[i];
            }
        }
        System.out.println("Max Profit: "+maxProfit);
    }
    public static void main(String[] args) {
        int prices []= {7, 1, 5, 3, 6,  4};
        getMaxProfit(prices);
    }
}
