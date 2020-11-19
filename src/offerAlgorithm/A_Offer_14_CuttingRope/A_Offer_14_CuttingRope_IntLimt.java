package offerAlgorithm.A_Offer_14_CuttingRope;

/**
 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

  

 示例 1：

 输入: 2
 输出: 1
 解释: 2 = 1 + 1, 1 × 1 = 1
 示例 2:

 输入: 10
 输出: 36
 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
  

 提示：

 2 <= n <= 1000

 */
public class A_Offer_14_CuttingRope_IntLimt {
    public int cuttingRope(int n) {
        if(n<4){
            return n-1;
        }
        long result = 1;
        // 本处 n>4 很妙，让余数只能成为 2，3！
        while (n>4){
            result = result * 3 % 1000000007;
            n -= 3;
        }
        return (int)(result*n %1000000007);
    }
}
