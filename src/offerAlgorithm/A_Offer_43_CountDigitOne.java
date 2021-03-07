package offerAlgorithm;

import java.util.Map;

/**
 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

  

 示例 1：

 输入：n = 12
 输出：5
 示例 2：

 输入：n = 13
 输出：6
  

 限制：

 1 <= n < 2^31

 */
public class A_Offer_43_CountDigitOne {
    public int countDigitOne(int n) {
        return f(n);
    }

    /**
     lc:  https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/javadi-gui-by-xujunyi/
     分为首位是1和首位不是1来做
     1. 首位是1， 如1234
          high = 1, pow = 1000, last = 234
        （1）0-999        f(pow-1)
         (2) 1000-1234
            1) 千位是1    last+1
            2) 其余位1    f(last)
         f(n) = f(pow-1)+(last+1)+f(last)
     2. 首位不是1，如3234
        high = 3, pow = 1000, last = 234
        (1) 0-999       f(pow-1)
        (2) 1000-1999
            1)千位是1     pow
            2)其余位是1   f(pow-1)
        (3) 2000-2999   f(pow-1)
        (4) 3000-3234   f(last)
        f(n) = high*f(pow-1)+pow+f(last)
     */
    int f(int n){
        if(n<=0) return 0;
        String str = String.valueOf(n);
        int high = str.charAt(0)-'0';
        int pow = (int)Math.pow(10,str.length()-1);
        int last = n-high*pow;
        if(high==1){
            return f(pow-1)+(last+1)+f(last);
        }else {
            return f(pow-1)*high+pow+f(last);
        }
    }
}
