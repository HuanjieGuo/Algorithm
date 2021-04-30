package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A0017_LetterCombinations {
    Map<Integer,char[]> map = new HashMap<>();
    List<String> combinations;
    StringBuilder currentStr;
    void initMap(){
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        initMap();
        combinations = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        currentStr = new StringBuilder();
        for(char ch:digits.toCharArray())
            list.add(ch-'0');
        recur(list);
        return combinations;
    }
    public void recur(List<Integer> list){
        if(list.size()==0) {
            combinations.add(currentStr.toString());
            return;
        }
        // 拿第一个数字,对应的所有字母
        int num = list.get(0);
        list = list.subList(1,list.size());
        for(char ch:map.get(num)){
            currentStr.append(ch);
            recur(list);
            currentStr.deleteCharAt(currentStr.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new A0017_LetterCombinations().letterCombinations("32"));
    }
}
