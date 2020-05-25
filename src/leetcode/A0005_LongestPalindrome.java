package leetcode;

/**
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"
 */
public class A0005_LongestPalindrome {
    /**
     * 最长回文串
     * tips : 动态规划 + 判断条件 +  s.get(i)==s.get(j)&&isPalindrome[i+1][j-1]
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String max = "";
        boolean[][] isPalindrome = new boolean[s.length()+1][s.length()+1];
        for(int j = 0;j<s.length()+1;j++){
            for(int i=j;i>=0;i--){
                if(i==j||i==j-1){
                    isPalindrome[i][j] = true;
                }else if(isPalindrome[i+1][j-1]&&s.charAt(i)==s.charAt(j-1)){
                    isPalindrome[i][j] = true;
                }
                if(max.length()<j-i&&isPalindrome[i][j]){
                    max = s.substring(i,j);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(A0005_LongestPalindrome.longestPalindrome("aadaddadaioq"));
    };
}
