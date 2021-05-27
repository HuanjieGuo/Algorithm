package hot100;

import java.util.*;

public class A0049_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<TreeMap,List<String>> map = new HashMap<>();
        for(String str:strs){
            TreeMap<Character,Integer> charMap = new TreeMap<>();
            for(Character ch:str.toCharArray())
                charMap.put(ch,charMap.getOrDefault(ch,0)+1);
            List<String> list = map.getOrDefault(charMap,new ArrayList<>());
            list.add(str);
            map.put(charMap,list);
        }
        return new ArrayList<>(map.values());
    }
}
