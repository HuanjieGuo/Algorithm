package secondOffer.dp;

/**
 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

  

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

 */
public class Offer0063_MaxProfit {
    public int maxProfit(int[] prices) {
        int low = 1000000;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,prices[i]-low);
            if(prices[i]<low) low = prices[i];
        }
        return maxProfit;
    }
}
