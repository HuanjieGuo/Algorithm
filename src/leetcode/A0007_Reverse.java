package leetcode;

/**
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
  示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class A0007_Reverse {
    public static int reverse(int x) {
        boolean isPositive = (x>=0);
        String number = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
        while (!number.equals("")){
            if(number.charAt(0)=='0'){
                number = number.substring(1,number.length());
            }else {
                break;
            }
        }
        if(number.equals("")){
            return 0;
        }
        try {
            int resNum = Integer.valueOf(number);
            return isPositive?resNum:-resNum;
        }catch (Exception e){
            return 0;
        }
    }
    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }

}
