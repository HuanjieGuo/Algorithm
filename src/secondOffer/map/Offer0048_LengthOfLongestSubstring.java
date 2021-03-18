package secondOffer.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

  

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 */
public class Offer0048_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len==0) return 0;
        int max = 0;
        // idx of it
        Map<Character,Integer> map = new HashMap<>();
        int ahead = 0;
        int behind = 0;
        while (ahead<s.length()){
            char ch = s.charAt(ahead);
            // 如果已经存在，并且坐标大于behind 让behind放到那里
            if(map.containsKey(ch)&&map.get(ch)>=behind) behind = map.get(ch)+1;
            // 存进新值
            map.put(ch,ahead);
            max = Math.max(max,ahead-behind+1);
            ahead++;
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
