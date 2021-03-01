package leetcode;

public class A0044_IsMatch {
    static public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for(int i=1;i<m+1;i++)
            for(int j=1;j<n+1;j++){
                if(p.charAt(j-1)=='?'
                        ||s.charAt(i-1)==p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                if(p.charAt(j-1)=='*')
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];

            }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("acdcb","a*c?b"));
    }

}
