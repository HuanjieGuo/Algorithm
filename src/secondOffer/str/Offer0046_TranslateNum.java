package secondOffer.str;

/**
 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

  

 示例 1:

 输入: 12258
 输出: 5
 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Offer0046_TranslateNum {
    public int translateNum(int num) {
        StringBuilder builder = new StringBuilder(String.valueOf(num));
        int[] dp = new int[builder.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=builder.length();i++){
            String numStr = builder.substring(i-2,i);
            if(numStr.compareTo("10")<0||numStr.compareTo("25")>0) dp[i] = dp[i-1];
            else dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[builder.length()];
    }
}
