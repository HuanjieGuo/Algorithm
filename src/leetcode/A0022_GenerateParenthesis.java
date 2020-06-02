package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

  

 示例：

 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 */
public class A0022_GenerateParenthesis {
    List<String> res = new ArrayList<>();
    int n_total;
    /**
     * 树 + 剪枝 复杂度2.^n
     * 右大于左的减去
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        n_total = n;
        if(n==0){
            return res;
        }
        dfs("",0,0);
        return res;
    }

    void dfs(String curStr,int left,int right){
        if(left==n_total&&right==n_total){
            res.add(curStr);
            return;
        }
        // 剪枝
        if(left<right){
            return;
        }
        if(left<n_total){
            dfs(curStr+"(",left+1,right);
        }
        if(right<n_total){
            dfs(curStr+")",left,right+1);
        }

    }
}
