package offerAlgorithm;

/**

 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



 示例 1:

 输入: 12258
 输出: 5
 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


 提示：

 0 <= num < 231
 */
public class A_Offer_46_TranslateNum {
    /**
     *   能解释的话 dp[i+1] = dp[i] + dp[i-1]
     *   不能的话  dp[i+1] = dp[i]
     */
    public static int translateNum(int num) {
        String str = String.valueOf(num);
        // dp数组的大小有n+1个  因为空字符串占用了一个
        int[] dp = new int[str.length()+1];
        // 如何知道dp[0] 表示空字符串 状态
        // 如果2个字符的情况下，2个可以翻译，那么有2种情况， 而dp[1]=1 所以dp[0]=1
        dp[0] = dp[1] = 1;
        for(int i=1;i<str.length();i++){
            int number = Integer.valueOf(str.substring(i-1,i+1));
            if(number>=10&&number<=25){
                // 可翻译
                dp[i+1] = dp[i]+dp[i-1];
            }else {
                // 不能翻译
                dp[i+1] = dp[i];
            }
        }
        return dp[str.length()];
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(translateNum(123));
    }
}
