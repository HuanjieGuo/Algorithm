package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

  

 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class A0003_LengthOfLongestSubstring {
    // 双指针 + Map
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int longest = 0;
        int left = 0;
        int right = 0;
        Map<Character,Integer> chatIdxMap = new HashMap<>();
        while (left<=right){
            if(chatIdxMap.containsKey(s.charAt(right))
                    &&chatIdxMap.get(s.charAt(right))>=left) left = chatIdxMap.get(s.charAt(right))+1;
            longest = Math.max(longest,right-left+1);
            chatIdxMap.put(s.charAt(right),right);
            right++;
            if(right==s.length()) break;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
