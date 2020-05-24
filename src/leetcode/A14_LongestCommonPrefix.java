package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A14_LongestCommonPrefix {
    /**
     编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:

     所有输入只包含小写字母 a-z 。
     **/


    /**
     * 假设str平均长度m
     * 暴力破解
     * 时间复杂度 O(m*n)
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String common = strs[0];
        for(String str:strs){
            while (str.indexOf(common)!=0){
                common = common.substring(0,common.length()-1);
                if(common.equals("")){
                    break;
                }
            }
            if(common.equals("")){
                break;
            }
        }
        return common;
    }

    /**
     * sort 先排序后比较第一个和最后一个
     * 时间复杂度 O( mnlog(n) )
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        String pre = strs[0];
        String end = strs[strs.length-1];
        while (pre.indexOf(end)!=0){
            end = end.substring(0,end.length()-1);
        }
        return end;
    }

    public static void main(String[] args) {
        String str = "ABD";
        System.out.println(str.indexOf(""));
    }


}
