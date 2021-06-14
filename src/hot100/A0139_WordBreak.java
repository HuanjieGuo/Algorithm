package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A0139_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet();
        for(String str:wordDict)
            wordSet.add(str);
        boolean[] dp = new boolean[s.length()+1];
        // "" 可以
        dp[0] = true;
        for(int i=1;i<dp.length;i++)
            for(int j=0;j<i;j++)
                // dp[j]指的是字符串j位前一位。 因为dp第一位是"".
                // 本处实际上是移动j，使下面条件满足
                // 1. [0,j-1]是已经验证过ok的
                // 2. [j,i) 字符串存在于单词表中
                if(dp[j]&&wordSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    // 只要找到一组，直接跳出
                    break;
                }
       return dp[s.length()];
    }

    public static void main(String[] args) {
//        String s = "catsandog";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak(s, wordDict));
    }
}
