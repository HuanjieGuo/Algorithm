package secondOffer.dp;

/**
 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 */
public class Offer0014_2_CuttingRope {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int p = 1000000007;
        int a = n/3;
        int b = n%3;
        long rem = 1;
        for (int i=0;i<a-1;i++)
            rem = rem*3%p;
        if(b==0) return (int)(rem*3%p);
        if(b==1) return (int)(rem*4%p);
        return (int)(rem*3*2%p);
    }
}
