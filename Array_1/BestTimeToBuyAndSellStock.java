package Array_1;

public class BestTimeToBuyAndSellStock {
    public static int buyAndSellStock(int price[]){
        int maxSum=Integer.MIN_VALUE;
        int n=price.length;
        int buyPrice=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(price[i]>buyPrice){
                int profit=price[i]-buyPrice;
                maxSum=Math.max(maxSum,profit);
            }
            else{
                buyPrice=price[i];
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int price[]={7,1,5,3,6,4};
        System.out.println(buyAndSellStock(price));
    }
}
