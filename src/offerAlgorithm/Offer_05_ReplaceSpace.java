package offerAlgorithm;

/**
 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

  

 示例 1：

 输入：s = "We are happy."
 输出："We%20are%20happy."
  

 限制：

 0 <= s 的长度 <= 10000

 */
public class Offer_05_ReplaceSpace {
    /**
     * 申请一个新空间
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        String newS = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            newS += ch==' '?"%20":ch;
        }
        return newS;
    }

    /**
     * 如果不想占用空间，用while ！
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(new Offer_05_ReplaceSpace().replaceSpace("We are happy."));
    }
}
