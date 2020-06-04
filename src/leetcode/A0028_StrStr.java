package leetcode;

import leetcode.structure.KMP;
import leetcode.structure.ListNode;

/**
 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:

 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

 */
public class A0028_StrStr {
    /**
     * 暴力算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        int string_length = haystack.length();
        int sub_length = needle.length();
        for(int i=0;i<=string_length-sub_length;i++){
            // 长度不够时提前结束
            for(int j=0;j<sub_length;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                if(j==sub_length-1){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * kmp搜索
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrKMP(String haystack, String needle) {
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    public static void main(String[] args) {
        A0028_StrStr a0028_strStr = new A0028_StrStr();

        // 构建字符串
        String haystack = "";
        for(int i=0;i<10000;i++){
            haystack += "aaaaa";
        }
        haystack += "y";

        // 构建匹配字符串
        String needle = "";
        for(int i=0;i<10000;i++){
            needle += "aa";
        }
        needle += "y";
        Long time = System.currentTimeMillis();

        //
        System.out.println("KMP");
        System.out.println(a0028_strStr.strStrKMP(haystack,needle));
        System.out.println(System.currentTimeMillis()-time+"ms");

        System.out.println("BF");
        time = System.currentTimeMillis();
        System.out.println(a0028_strStr.strStr(haystack,needle));
        System.out.println(System.currentTimeMillis()-time+"ms");
    }

}
