package secondOffer.dp;

/**
 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 在本题中，匹配是指字符串的所有字符匹配整个模式。
 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

 */
public class Offer0019_IsMatch {
    public boolean isMatch_dp(String s, String p) {
        int m = s.length()+1;
        int n = p.length()+1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for(int j=2;j<n;j+=2)
            dp[0][j] = dp[0][j-2]&&p.charAt(j-1)=='*';
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                if(p.charAt(j-1)=='*'){
                    // * 三种情况
                    // 1. * 取0个
                    if(dp[i][j-2]) dp[i][j] = true;
                    // 2. * 取1个
                    else if(dp[i-1][j]&&s.charAt(i-1)==p.charAt(j-2)) dp[i][j] = true;
                    // 3. *前面是'.'
                    else if(dp[i-1][j]&&p.charAt(j-2)=='.') dp[i][j] =true;
                }else {
                    // 非* 两种情况
                    // 1. 普通
                    if(dp[i-1][j-1]&&s.charAt(i-1)==p.charAt(j-1)) dp[i][j] = true;
                    // 2. 匹配串是'.'
                    else if(dp[i-1][j-1]&&p.charAt(j-1)=='.') dp[i][j] = true;

                }
            }
        return dp[m-1][n-1];
    }
}
