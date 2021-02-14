package niuke;

import leetcode.structure.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 题目描述
 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 示例1
 输入
 复制
 "ab"
 返回值
 复制
 ["ab","ba"]
 */
public class Permutation {
    ArrayList<Character> pre;
    ArrayList<Character> rest;
    ArrayList<String> result;
    public ArrayList<String> Permutation(String str) {
        pre = new ArrayList<>();
        rest = new ArrayList<>();
        result = new ArrayList<>();
        for(char ch:str.toCharArray())
            rest.add(ch);
        eachDepth();
        return result;
    }
    void eachDepth() {
        if (rest.size() == 0) {
            StringBuilder str = new StringBuilder();
            for (Character ch : pre)
                str.append(ch);
            result.add(str.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < rest.size(); i++) {
            Character ch = rest.get(i);
            if (set.contains(ch))
                continue;
            // 添加到set
            set.add(ch);
            // 前缀添加
            pre.add(ch);
            // rest 移除
            rest.remove(i);
            // 迭代
            eachDepth();
            // 复原
            pre.remove(pre.size() - 1);
            rest.add(i, ch);
        }
    }
}
