package leetcode;

public class LongestPalindrome {
    /**
     * 最长回文串
     * tips : 动态规划 + 判断条件 +  s.get(i)==s.get(j)&&isPalindrome[i+1][j-1]
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String max = "";
        boolean[][] isPalindrome = new boolean[s.length()+1][s.length()+1];
        for(int j = 0;j<s.length()+1;j++){
            for(int i=j;i>=0;i--){
                if(i==j||i==j-1){
                    isPalindrome[i][j] = true;
                }else if(isPalindrome[i+1][j-1]&&s.charAt(i)==s.charAt(j-1)){
                    isPalindrome[i][j] = true;
                }
                if(max.length()<j-i&&isPalindrome[i][j]){
                    max = s.substring(i,j);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(LongestPalindrome.longestPalindrome("aadaddadaioq"));
    };
}
