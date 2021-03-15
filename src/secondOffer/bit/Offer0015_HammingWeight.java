package secondOffer.bit;

/**
 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

  

 示例 1：

 输入：00000000000000000000000000001011
 输出：3
 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 示例 2：

 输入：00000000000000000000000010000000
 输出：1
 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 示例 3：

 输入：11111111111111111111111111111101
 输出：31
 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。

 */
public class Offer0015_HammingWeight {
    public static int hammingWeight_and(int n) {
        System.out.println(1<<31>>31);
        System.out.println(1<<31>>>31);
        int count = 0;
        while (n!=0){
            // 个位上面的异或！
            count += (n&1);
            //  >> 如果 1<<31 >> 31，变成    -1 符号位存在   1000000 00000000 00000000 00000001
            //  >>> 如果 1<<31 >>> 32 变成   1  0000000 00000000 00000000 00000001
            n>>>=1;
        }
        return count;
    }

    public static int hammingWeight_n_and_n1(int n) {
        int count = 0;
        while (n!=0){
            n &=(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight_n_and_n1(9));
    }
}
