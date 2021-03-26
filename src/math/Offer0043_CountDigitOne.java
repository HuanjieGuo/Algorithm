package math;

/**
 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

  

 示例 1：

 输入：n = 12
 输出：5

 */
public class Offer0043_CountDigitOne {
    public int countDigitOne(int n) {
        if(n<10) return 1;
        int base = 1;
        while (n/base>=10) base *= 10;
        int high = n/base;
        int low = n - high*base;
        if(high==1){
            return countDigitOne(base-1)+(low+1)+countDigitOne(low);
        }else {
            return high*countDigitOne(base-1)+base+countDigitOne(low);
        }
    }

    public static void main(String[] args) {
        new Offer0043_CountDigitOne().countDigitOne(12);
    }
}
