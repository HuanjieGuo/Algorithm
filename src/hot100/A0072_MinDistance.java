package hot100;

public class A0072_MinDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        // 空和空匹配
        dp[0][0] = 0;
        // 插入
        for(int i=1;i<=len2;i++)
            dp[0][i] = dp[0][i-1]+1;
        // 删除
        for(int i=1;i<=len1;i++)
            dp[i][0] = dp[i-1][0]+1;
        // 正常
        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++)
                /**
                 i和j字符相同，操作次数等于 dp[i-1][j-1]
                 */
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                /**
                 i和j字符不同.
                 dp[i-1][j-1] 表示替换
                 dp[i-1][j] 表示删除
                 dp[i][j-1] 表示插入

                 word1为"horse", word2为"ros"
                 1. dp[i-1][j-1] 先将word1前4个字母horse转换成word2前2个字母ro, 再将word1第五个字母e替换成word2第三个字母s
                 2. dp[i][j-1] 先将word1前5个字母转成word2前2个字母ro,然后插入word2第三个字母s
                 3. dp[i-1][j] 先将word1前4个字母转成word2 即ros,然后删除最后一个
                 三个操作选择最小那个 + 1 就行！
                 */
                else dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
        return dp[len1][len2];
    }
}
