package hot100;

import java.util.HashMap;
import java.util.Map;

public class A0076_MinWindow {
public static String minWindow(String s, String t) {
    if(s==null||s.equals("")||t==null||t.equals("")) return "";
    // 本处restCount用于判断当前还缺多少个匹配，减少了遍历patternMap的时间！
    int left=0, right=0,restCount = t.length(),lengthS = s.length();
    String currentStr = null;
    int currentLength = -1;
    // 初始化
    Map<Character,Integer> winMap = new HashMap<>();
    Map<Character,Integer> pattenMap = new HashMap<>();
    for(Character ch:t.toCharArray())
        pattenMap.put(ch,pattenMap.getOrDefault(ch,0)+1);
    // 移动右指针
    while (right<lengthS){
        char ch = s.charAt(right);
        // 过滤无关的
        if(!pattenMap.containsKey(ch)){
            right++;
            continue;
        }
        // 有效的进入
        winMap.put(ch,winMap.getOrDefault(ch,0)+1);
        // 剩余需要寻找的字母-1
        if(winMap.get(ch)<=pattenMap.getOrDefault(ch,0)) restCount--;
        // 找完了后，左指针收缩
        while (restCount==0){
            if(currentLength==-1||currentLength>right-left+1) {
                currentStr = s.substring(left, right + 1);
                currentLength = right-left+1;
            }
            // 收缩左指针
            char leftChar = s.charAt(left);
            if(pattenMap.containsKey(leftChar)) {
                // 在里面，判断去除然后操作
                winMap.put(leftChar, winMap.get(leftChar) - 1);
                // 造成影响
                if (winMap.get(leftChar) < pattenMap.get(leftChar)) restCount++;
            }
            // 直接收缩leftChar
            left++;
        }
        right++;
    }
    return currentStr==null?"":currentStr;
}

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
