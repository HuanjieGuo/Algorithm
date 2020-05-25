package leetcode;


/**
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 **/
public class A0003_LengthOfLongestSubstring {
    /**
     * 无重复最大子串
     * tip:维护子串窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String windowString = "";
        for(int i=0;i<s.length();i++){
            int charIndexInWin = windowString.indexOf(s.charAt(i));
            if(charIndexInWin != -1){
                max = Math.max(max,windowString.length());
                windowString = windowString.substring(charIndexInWin+1,windowString.length());
            }
            windowString = windowString + s.charAt(i);
        }
        // 最后再次判断
        max = Math.max(max,windowString.length());
        return max;
    }
    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(A0003_LengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
