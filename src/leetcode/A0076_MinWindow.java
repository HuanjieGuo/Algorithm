package leetcode;

import java.util.HashMap;
import java.util.Map;

public class A0076_MinWindow {
    public static String minWindow(String s, String t) {
        if(s.equals("")) return "";
        Map<Character, Integer> mapT = new HashMap<>();
        // 搞定T map
        for (char ch : t.toCharArray())
            mapT.put(ch, 1 + mapT.getOrDefault(ch, 0));
        int left = 0;
        int right = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        mapS.put(s.charAt(right),1);
        String shortStr = null;
        while (left <= s.length() - 1 || right <= s.length() - 1) {
            boolean isOk = true;
            for (Character character : mapT.keySet()) {
                if (mapS.getOrDefault(character, 0) < mapT.get(character)) {
                    isOk = false;
                    break;
                }
            }
            //如果不满足条件，移动右指针
            if (!isOk) {
                // right最多加到右边
                if(right==s.length()-1)break;
                if (right < s.length() - 1) {
                    right++;
                    char rightChar = s.charAt(right);
                    if(mapT.containsKey(rightChar))mapS.put(rightChar,mapS.getOrDefault(rightChar,0)+1);
                }
                continue;
            }
            // 满足条件
            if (shortStr == null) {
                shortStr = s.substring(left, right + 1);
            } else {
                // 比较后替换
                shortStr = (right - left + 1) < shortStr.length() ? s.substring(left, right + 1) : shortStr;
            }
            // 判断是否要剔除
            char leftChar = s.charAt(left);
            if(mapT.containsKey(leftChar)) mapS.put(leftChar,mapS.get(leftChar)-1);
            left++;
            while (left<right){
                char ch = s.charAt(left);
                if(!mapT.containsKey(ch)){
                    // 不包括
                    left++;
                }else {
                    // 包括
                    if(mapS.get(ch)-1>=mapT.get(ch)) {
                        left++;
                        mapS.put(ch,mapS.get(ch)-1);
                    }
                    else break;
                }
            }
        }
        return shortStr == null ? "" : shortStr;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("acbbaca", "aba"));
    }

}
