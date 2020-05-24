package leetcode;

public class Convert {
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
