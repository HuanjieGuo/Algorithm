package hot100;

public class A0005_LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            dp[i][i] = true;
        String longestStr = s.substring(0,1);
        int longestLen = 1;
        for(int len=1;len<s.length();len++){
            for(int start=0;start<s.length()-len;start++){
                if(s.charAt(start)==s.charAt(start+len)
                        &&(len==1||dp[start+1][start+len-1])) {
                    dp[start][start + len] = true;
                    if(len+1>longestLen){
                        longestLen = len+1;
                        longestStr = s.substring(start,start+len+1);
                    }
                }
                else dp[start][start+len] = false;
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
