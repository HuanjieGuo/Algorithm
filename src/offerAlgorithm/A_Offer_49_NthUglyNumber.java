package offerAlgorithm;

/**
 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

  

 示例:

 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 说明:  

 1 是丑数。
 n 不超过1690。
 */
public class A_Offer_49_NthUglyNumber {
    int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 三个指针
        int p2=0,p3=0,p5=0;
        for(int i=1;i<n;i++){
            dp[i]=Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);
            // 本处如果是在30， 可能出现三个子序列指向同个值，需要同时移动指针
            if(dp[i]==dp[p2]*2) p2++;
            if(dp[i]==dp[p3]*3) p3++;
            if(dp[i]==dp[p5]*5) p5++;
        }
        return dp[n-1];
    }
}
