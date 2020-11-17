package offerAlgorithm;

/**
 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 示例 1：

 输入：n = 2
 输出：2
 示例 2：

 输入：n = 7
 输出：21
 示例 3：

 输入：n = 0
 输出：1
 提示：

 0 <= n <= 100

 */
public class Offer_10_2_numWaysStair {
    /**
     * 动态规划
     * 执行效率 ： n
     * @param n
     * @return
     */
    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        int waysTwoStairAgo = 1;
        int waysOneStairAgo = 1;
        for(int i=1;i<n;i++){
            int total  = (waysOneStairAgo + waysTwoStairAgo) % 1000000007;
            waysTwoStairAgo = waysOneStairAgo;
            waysOneStairAgo = total;
        }
        return waysOneStairAgo;
    }


    /**
     * 递归，比较慢，算法复杂度 2^n
     * @param n
     * @return
     */
    int ways(int n){
        if(n==0||n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        return (ways(n-1)+ways(n-2))%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(new Offer_10_2_numWaysStair().numWays(4));
    }
}
