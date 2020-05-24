package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最大子串
 * tip:维护子串窗口
 */
public class LengthOfLongestSubstring {
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
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
