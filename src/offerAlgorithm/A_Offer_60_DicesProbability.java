package offerAlgorithm;

/**
 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

  

 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

  

 示例 1:

 输入: 1
 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 示例 2:

 输入: 2
 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
  

 限制：

 1 <= n <= 11

 */
public class A_Offer_60_DicesProbability {
    public static double[] dicesProbability(int n) {
        int dp[][] = new int[n][6*n];
        for(int i=0;i<6;i++)
            dp[0][i] = 1;
        for(int i=1;i<n;i++)
            for(int col=0;col<6*i;col++)
                for(int num=1;num<=6;num++)
                    dp[i][col+num] += dp[i-1][col];
        int all = 0;
        for(int item:dp[n-1]) all+=item;
        double[] res = new double[5*n+1];
        for(int i=0;i<res.length;i++)
            res[i] = Double.valueOf(dp[n-1][i+n-1])/all;
        return res;
    }

    public static void main(String[] args) {
        dicesProbability(2);
    }
}
