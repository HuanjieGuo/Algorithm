package secondOffer.map;

import java.util.HashMap;
import java.util.Map;

public class Offer0050_FirstUniqChar {
    public char firstUniqChar_map(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for(Character ch:s.toCharArray())
            map.put(ch,!map.containsKey(ch));
        for(Character ch:s.toCharArray())
            if(map.get(ch)) return ch;
        return ' ';
    }
}
