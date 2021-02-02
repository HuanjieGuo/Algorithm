package niuke;

/**
 题目描述
 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 示例1
 输入
 复制
 "1","99"
 返回值
 复制
 "100"
 说明
 1+99=100
 */
public class BigNumberAdd {
    public String solve (String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length()-1;
        int j = t.length()-1;
        int carry  = 0;
        while (i>=0||j>=0||carry!=0){
            int x = i<0?0:s.charAt(i)-'0';
            int y = j<0?0:t.charAt(j)-'0';
            int sum = x+y+carry;
            stringBuilder.append(sum%10);
            carry = sum/10;
        }
        return stringBuilder.reverse().toString();
    }
}
