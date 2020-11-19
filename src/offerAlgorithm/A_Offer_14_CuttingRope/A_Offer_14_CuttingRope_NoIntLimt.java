package offerAlgorithm.A_Offer_14_CuttingRope;

/**
 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

 示例 1：

 输入: 2
 输出: 1
 解释: 2 = 1 + 1, 1 × 1 = 1
 示例 2:

 输入: 10
 输出: 36
 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 提示：

 2 <= n <= 58

 */
public class A_Offer_14_CuttingRope_NoIntLimt {
    /**
     * 切成三段最好！
     关于为什么切分为3的优先级最高 可以利用均值不等式求出乘积最大值 L(m)=(n/m)^m
     对此式求导（可利用对数法），可以证明当 m=n/e 时，
     乘积取最大，此时每段绳子的长度为 n/(n/e)=e，自然对数e的值为2.718，
     1. 尽量分成每一段为3
     2. 如果分3后剩余2  直接乘
     3. 分三后剩余1，  count3-1 -> 2*2
     * @return
     */
    public int cuttingRope(int n) {
        if(n<4){
            return n-1;
        }
        int count3 = n/3;
        int rest = n%3;
        switch (rest){
            case 2:
                return (int) (Math.pow(3,count3)*2);
            case 1:
                return (int) (Math.pow(3,count3-1)*2*2);
            default:
                return  (int) (Math.pow(3,count3));
        }
    }

    /**
     * 动态规划
     *  记录1到n-1的最大积, max[i]*(n-1)计算出结果！
     * @param n
     * @return
     */
    public static int cuttingRopeDP(int n) {
        if(n<=3){
            return n-1;
        }
        int[] max = new int[n+1];
        max[2] = 2;
        max[3] = 3;
        for(int i=4;i<n+1;i++){
            for(int j=2;j<i;j++){
                max[i] = Math.max(max[i],(i-j)*max[j]);
            }
        }
        return max[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRopeDP(10));
    }
}
