package math;

/**
 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

  

 示例:

 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

 */
public class Offer_NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] a = new int[n];
        a[0] = 1;
        int idx_2 = 0;
        int idx_3 = 0;
        int idx_5 = 0;
        for(int i=1;i<n;i++){
            a[i] = Math.min(Math.min(a[idx_2]*2,a[idx_3]*3),a[idx_5]*5);
            if(a[i]==a[idx_2]*2) idx_2++;
            if(a[i]==a[idx_3]*3) idx_3++;
            if(a[i]==a[idx_5]*5) idx_5++;
        }
        return a[n-1];
    }

    public static void main(String[] args) {

    }
}
