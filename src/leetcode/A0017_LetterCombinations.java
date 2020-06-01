package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 */


public class A0017_LetterCombinations {
    List<String> result = new ArrayList<>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    /**
     * 带着已经组合成的字符串，未处理的字符串
     * 递归调用  for 里面   老字符串+新CHAR , 未处理字符串-1
     * 类似dfs
     * @param combination
     * @param next_digits
     */
    public void backtrack(String combination, String next_digits) {
        if(next_digits.equals("")){
            result.add(combination);
        }else {
            String digest = phone.get(next_digits.substring(0,1));
            for(int i=0;i<digest.length();i++){
                backtrack(combination+digest.charAt(i),next_digits.substring(1,next_digits.length()));
            }
        }
    }
    /**
     * 回溯法
     * 时间复杂度，对于本题目 O(n^3)
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return result;
        }
        backtrack("",digits);
        return result;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new A0017_LetterCombinations().letterCombinations(s));
    }

}
