package niuke;

/**
 题目描述
 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。

 给定字符串A以及它的长度n，请返回最长回文子串的长度。

 示例1
 输入
 复制
 "abc1234321ab",12
 返回值
 复制
 7
 */
public class A_GetLongestPalindrome {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        // dp matrix to check if a[i]==a[j]
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        // d is the length gap between start and end
        // 算法的核心，先执行了d=0 d=1的所有情况，后面都能直接依据给出值进行判定
        for(int d=0;d<n;d++)
            // 本处n-d的设计注意
            // i start
            for(int i=0;i<n-d;i++){
                // j end
                int j = i+d;
                if(A.charAt(i)==A.charAt(j))
                    // 核心代码 同个或相邻系统直接判定true
                    if(d<=1) dp[i][j] = true;
                    // 有间隔的看里层
                    else dp[i][j] = dp[i+1][j-1];
                if(dp[i][j]) max=Math.max(max,d+1);
            }
        return max;
    }
}
