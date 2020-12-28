package offerAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

  

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
  

 提示：

 s.length <= 40000

 */
public class A_Offer_48_LengthOfLongestSubstring {
    /**
     双指针+哈希表
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chs = s.toCharArray();
        int start=0,end = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<chs.length;i++){
            if(map.get(chs[i])!=null
                    && map.get(chs[i])>=start)
                start = map.get(chs[i])+1;
            end++;
            map.put(chs[i],i);
            max = Math.max(max,end-start);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
