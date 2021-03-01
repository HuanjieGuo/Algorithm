package leetcode;

import java.util.*;

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
    ArrayList<String> list;
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
     递归实现
     */
    public List<String> letterCombinations(String digits) {
        if(digits==null) return null;
        list = new ArrayList<>();
        if(digits.length()==0) return list;
        recur("",digits);
        return list;
    }

    void recur(String currentStr,String digits){
        if(digits.length()==0){
            list.add(currentStr);
            return;
        }
        String numStr = phone.get(digits.substring(0,1));
        for(char ch:numStr.toCharArray()){
            recur(currentStr+ch,digits.substring(1));
        }
    }
    /**
     队列实现
     */
    public List<String> letterCombinationsByQueue(String digits) {
        int len = digits.length();
        List<String> list = new ArrayList();
        if(digits==null) return null;
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        while (digits.length()!=0){
            // 2
            String str = phone.get(digits.substring(0,1));
            while (queue.peek().length()!=len+1-digits.length()) {
                String one = queue.poll();
                for(char ch:str.toCharArray())
                    queue.offer(one+ch);
            }
            digits = digits.substring(1);
        }
        if(queue.peek().equals("")) return list;
        while (queue.peek()!=null)
            list.add(queue.poll());
        return list;
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println(new A0017_LetterCombinations().letterCombinations(s));
    }

}
