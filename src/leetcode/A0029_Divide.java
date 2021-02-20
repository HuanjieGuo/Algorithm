package leetcode;

/**
 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

 返回被除数 dividend 除以除数 divisor 得到的商。

 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2


 */
public class A0029_Divide {
    // 可以简单概括为： 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7

    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(divisor==1) return dividend;
        // 整数整数上限是7结尾
        // 负数整数下限是8结尾
        if(divisor==-1) return dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;
        int sign = 1;
        // 本处a,b 用long 可以避免很多边界问题！
        long a = dividend;
        long b = divisor;
        if((a>0&&b<0)||(a<0&&b>0))
            sign = -1;
        a = a>0?a:-a;
        b = b>0?b:-b;
        int result = div(a,b);
        if(sign==1) return result;
        else return -result;
    }
    int div(long a,long b){
        if(a<b) return 0;
        long tb = b;
        int count = 1;
        // 本处tb可能溢出 如果不为long
        while (tb+tb<=a){
            tb = tb+tb;
            count = count+count;
        }
        return count+div(a-tb,b);
    }

    public static void main(String[] args) {
        System.out.println(new A0029_Divide().div(-2147483648,2));
    }
}
