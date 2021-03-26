package secondOffer.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Offer0038_Permutation {
    StringBuilder current;
    ArrayList<String> resultStrs;
    int length;
    public String[] permutation(String s) {
        if(s==null||s.length()==0) return new String[0];
        length = s.length();
        resultStrs = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);
        current = new StringBuilder();
        helper(str);
        String[] strings = new String[resultStrs.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = resultStrs.get(i);
        }
        return strings;
    }
    void helper(StringBuilder str){
        if(current.length()==length) {
            resultStrs.add(current.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(set.contains(ch)) continue;
            set.add(ch);
            current.append(ch);
            str.deleteCharAt(i);
            helper(str);
            current.deleteCharAt(current.length()-1);
            str.insert(i,ch);
        }
    }

}
