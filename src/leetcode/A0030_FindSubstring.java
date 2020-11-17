package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

  

 示例 1：

 输入：
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出：[0,9]
 解释：
 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。
 示例 2：

 输入：
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 输出：[]

 */
public class A0030_FindSubstring {
    /**
     * 移动+滑动窗口方案
     * 比如单词word   一共要测试4种情况， w  o r d 分别是开头
     * 时间复杂度 n * m(单词长度)
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s==null||s.length()==0||words==null||words.length==0) return res;
        Map<String,Integer> subMap = new HashMap<>();
        for(String str:words){
            subMap.put(str,subMap.getOrDefault(str,0)+1);
        }
        int wordLength = words[0].length();
        int wordCount = words.length;
        int currentSize;
        Map<String,Integer> currentWin;
        for(int k=0;k<wordLength;k++) {
            currentSize = 0;
            currentWin = new HashMap<>();
            for (int i = k; i+wordLength<=s.length(); i += wordLength) {
                String currentWord = s.substring(i, i + wordLength);
                // 新进来不存在
                if (!subMap.keySet().contains(currentWord)) {
                    currentSize = 0;
                    currentWin = new HashMap();
                    continue;
                }
                // 进来之前，窗口已经满了
                if (currentSize == wordCount) {
                    String removeWord = s.substring(i - wordLength * wordCount, i - wordLength * (wordCount - 1));
                    //最前面一个移除
                    if (currentWin.get(removeWord) == 1) {
                        currentWin.remove(removeWord);
                    } else {
                        currentWin.put(removeWord, currentWin.get(removeWord) - 1);
                    }
                    currentSize -= 1;
                }
                // 添加
                currentWin.put(currentWord, currentWin.getOrDefault(currentWord, 0) + 1);
                currentSize += 1;

                if (currentWin.equals(subMap)) {
                    res.add(i - wordLength * (wordCount - 1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //"aabbaabbaabb"
          //      ["bb","aa","bb","aa","bb"]
        System.out.println(findSubstring("aabbaabbaabb", new String[]{"bb","aa","bb","aa","bb"}));
    }
}
