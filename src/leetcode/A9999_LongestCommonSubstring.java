package leetcode;


import java.util.Arrays;

/**
 str=acbcbcef，str2=abcbced，则str和str2的最长公共子串为bcbce，最长公共子串长度为5。
 */
public class A9999_LongestCommonSubstring {
    /**
     * 动态规划 时间复杂度（n^2） 空间复杂度(n^2)
     * @param str1
     * @param str2
     */
    static Integer[] longestCommonSubstring(String str1,String str2){
        Integer[] result = new Integer[3];
        int longest = 0;
        int x = -1;
        int y = -1;
        int[][] lengthTable = new int[str1.length()][str2.length()];
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    if(i==0||j==0){
                        lengthTable[i][j]=1;
                    }else {
                        lengthTable[i][j]=lengthTable[i-1][j-1]+1;
                    }
                    if(lengthTable[i][j]>longest) {
                        longest = lengthTable[i][j];
                        y = i+1-longest;
                        x = j+1-longest;
                    }
                }
            }
        }
        result[0] = y;
        result[1] = x;
        result[2] = longest;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestCommonSubstring("abcdefg","1323")));
    }
}
