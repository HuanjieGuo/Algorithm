package niuke;

/**
 * 最长公共子串
 */
public class A_LCS {
    // https://www.bilibili.com/video/BV1aK411J7b8?from=search&seid=7793818426453851295
    public static String LCS (String str1, String str2) {

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        // dp[0][]  dp[][0] 值全为0  空字符串

        //
        Integer recordMaxLength = 0;
        Integer recordMaxAEndIndex = 0;

        for(int i=0;i<str1.length();i++) {
            for (int j=0; j < str2.length(); j++)
                if (str1.charAt(i) == str2.charAt(j)) {
                    int count = dp[i][j] + 1;
                    dp[i + 1][j + 1] = count;
                    if (count > recordMaxLength) {
                        recordMaxLength = count;
                        recordMaxAEndIndex = i;
                    }
                }
        }
        if(recordMaxLength==0) return "-1";
        return str1.substring(recordMaxAEndIndex-recordMaxLength+1,recordMaxAEndIndex+1);
    }

    public static void main(String[] args) {
        System.out.println(LCS("1AB2345CD","12345EF"));
    }
}
