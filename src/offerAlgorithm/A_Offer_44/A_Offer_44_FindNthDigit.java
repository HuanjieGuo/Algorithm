package offerAlgorithm.A_Offer_44;

/**
 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

 请写一个函数，求任意第n位对应的数字。

  

 示例 1：

 输入：n = 3
 输出：3
 示例 2：

 输入：n = 11
 输出：0
  

 限制：

 0 <= n < 2^31

 */
public class A_Offer_44_FindNthDigit {
    public int findNthDigit(int n){
        int digit = 1;
        long start = 1;
        long count = 9;
        // 1.确认位数
        while (n>count){
            n -= count;
            digit += 1;
            start *= 10;
            count = digit*start*9;
        }
        // 2.确认数字
        long num = start+(n-1)/digit;
        // 3.确认数字中的第几个位
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}
