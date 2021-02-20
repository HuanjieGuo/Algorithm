package leetcode;

/**
 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

 '.' 匹配任意单个字符
 '*' 匹配零个或多个前面的那一个元素
 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

  
 示例 1：

 输入：s = "aa" p = "a"
 输出：false
 解释："a" 无法匹配 "aa" 整个字符串。
 示例 2:

 输入：s = "aa" p = "a*"
 输出：true
 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 示例 3：

 输入：s = "ab" p = ".*"
 输出：true
 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 示例 4：

 输入：s = "aab" p = "c*a*b"
 输出：true
 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 示例 5：

 输入：s = "mississippi" p = "mis*is*p*."
 输出：false
  

 提示：

 0 <= s.length <= 20
 0 <= p.length <= 30
 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 保证每次出现字符 * 时，前面都匹配到有效的字符

 */
public class A0010_IsMatch {
//    public boolean isMatch(String s, String p) {
//        // 任意理解版本
//
//        // 如果匹配串为空 那么字符串也需要为空
//        if(p.isEmpty()) return s.isEmpty();
//
//        // 第一个节点能否匹配上
//        boolean first_match = !s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
//
//        // 如果剩余还有模式串   并且  模式串接下来一个等于*
//        if (p.length() >= 2 && p.charAt(1) == '*') {
//            // 第一种情况是模式串跳过前2个， 'a*'被看成''   或者   第一个匹配上同时接下来字符串的首字母也匹配上
//            return isMatch(s,p.substring(2))||(first_match&&isMatch(s.substring(1),p));
//        }else
//            // 剩余情况， 第一个相同，并且剩余也相同
//            return first_match&&isMatch(s.substring(1),p.substring(1));
//    }
        public boolean isMatch(String s, String p) {
            if(p.isEmpty()) return s.isEmpty();
            // 判断第一个是否相同
            boolean firstMatch = !s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
            // 判断p后面有无值,如果是* ,可能要消除
            if(p.length()>=2&&p.charAt(1)=='*')
                // 第一种是'a*' 看成''  第二种是第一个匹配上，s直接跳过一个再和原文p比较
                return isMatch(s.substring(2),p)||(firstMatch&&isMatch(s.substring(1),p));
            // 普通情况
            else return firstMatch&&isMatch(s.substring(1),p.substring(1));
        }

}
