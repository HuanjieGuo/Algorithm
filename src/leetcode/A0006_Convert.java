package leetcode;

/**
 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);
 示例 1:

 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 示例 2:

 输入: s = "LEETCODEISHIRING", numRows = 4
 输出: "LDREOEIIECIHNTSG"
 解释:

 L     D     R
 E   O E   I I
 E C   I H   N
 T     S     G

 */

public class A0006_Convert {
    /**
     * Z字形输出
     * tips : 画图模拟, 记录转向变量 directionIsDown
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        String [] result = new String[numRows];
        for(int i=0;i<result.length;i++){
            result[i] = "";
        }
        boolean directionIsDown = true;
        int index = 0;
        for(int i=0;i<s.length();i++) {
            result[index] = result[index] + s.charAt(i);
            if(numRows!=1) {
                if (directionIsDown) {
                    index = index + 1;
                } else {
                    index = index - 1;
                }
            }
            if (index == 0 || index == numRows - 1) {
                directionIsDown = !directionIsDown;
            }
        }
        String string = "";
        for(String str:result){
            string += str;
        }
        return string;
    }

    public static void main(String[] args) {
        System.out.println(convert("AB",1));
    }
}
