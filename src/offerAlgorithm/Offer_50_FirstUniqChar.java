package offerAlgorithm;

import java.util.HashMap;
import java.util.HashSet;

public class Offer_50_FirstUniqChar {
    /**
     hash表存是否第一次出现
     再循环s读hash表
     */
    public char firstUniqChar(String s) {
        char [] chars = s.toCharArray();
        HashMap<Character,Boolean> map = new HashMap();
        for(char ch:chars)
            map.put(ch,!map.containsKey(ch));
        for(char ch:chars)
            if(map.get(ch)) return ch;
        return ' ';
    }
}
