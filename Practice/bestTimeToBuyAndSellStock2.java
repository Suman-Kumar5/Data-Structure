package Practice;

public class bestTimeToBuyAndSellStock2 {
    public static int buyAndSellStock(int price[]){
        int n=price.length;
        int maxProfit=0;
        int buyPrice=Integer.MAX_VALUE;
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
        int price[]={7,1,5,3,6,4};
        System.out.println(buyAndSellStock(price));
    }
}
