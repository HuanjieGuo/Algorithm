package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。
 */
public class A0049_GroupAnagrams {
    /**
     本哈希算法复杂度有略微高。
     另一种思路(待实现): 用质数表示26个字母，把字符串的各个字母相乘，
     这样可保证字母异位词的乘积必定是相等的。A
     其余步骤就是用map存储（这个用质数表示真的很骚啊！！!）
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map,List<String>> listMap = new HashMap<>();
        for(String str:strs){
            Map<Character,Integer> map = new HashMap();
            for(char ch:str.toCharArray())
                map.put(ch, map.getOrDefault(ch,0)+1);

            List<String> list = listMap.get(map);
            if(list==null) list = new ArrayList<>();
            list.add(str);
            listMap.put(map,list);
        }
        List<List<String>> finalList = new ArrayList<>();
        for(List list:listMap.values()){
            finalList.add(list);
        }
        return finalList;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
