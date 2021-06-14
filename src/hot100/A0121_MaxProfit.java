package hot100;

public class A0121_MaxProfit {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int profit = 0;
        for(int price:prices) {
            if (price < low) low = price;
            profit = Math.max(profit, price - low);
        }
        return profit;
    }
}
