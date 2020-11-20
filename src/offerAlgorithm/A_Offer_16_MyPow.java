package offerAlgorithm;

/**
 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

  

 示例 1:

 输入: 2.00000, 10
 输出: 1024.00000
 示例 2:

 输入: 2.10000, 3
 输出: 9.26100
 示例 3:

 输入: 2.00000, -2
 输出: 0.25000
 解释: 2-2 = 1/22 = 1/4 = 0.25
  

 说明:

 -100.0 <x< 100.0
 n是 32 位有符号整数，其数值范围是[−2^31,2^31− 1] 。
 */
public class A_Offer_16_MyPow {
    public  double myPow(double x, int n) {
        if(x==0)
            return 0;
        if(n>=0)
            return power(x,n);
        // n<0
        return power(1/x,-n);
    }

    /**
     快速幂
     a^4 = a^2*a^2 = a^1*a^1*a^1*a^1 = a*a*a*a
     时间复杂度log2(n)
     */

    public double power(double x,int n){
        // n>=0
        if(n==0){
            return 1;
        }
        double r= power(x,n/2);
        // 判断奇偶
        if(((n&1)==1)){
            // 奇数
            return r*r*x;
        }
        return r*r;
    }

    public static void main(String[] args) {
        String a = "2147483648";
        System.out.println(Integer.valueOf(a));
    }

}
