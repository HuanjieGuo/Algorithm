package offerAlgorithm;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Offer_32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        return dpFunction(s);
    }


    /**
     * 双指针算法
     先从左往右，right>left时  left = right = 0  其余时候left=right, max = Math.max(max,left*2)
     再从左往右，right<left时  left = right = 0  其余时候left=right, max = Math.max(max,left*2)
     */
    public int leftAndRightIdx(String s){
        char[] chs = s.toCharArray();
        int left =0;
        int right = 0;
        int max = 0;
        for(char ch:chs) {
            if (ch == '(') left++;
            else right++;
            if(left==right) max = Math.max(max,left*2);
            if(right>left){ left=0; right=0;}
        }
        left = 0;
        right = 0;
        for(int i=chs.length-1;i>=0;i--) {
            if (chs[i] == '(') left++;
            else right++;
            if(left==right) max = Math.max(max,left*2);
            if(left>right){ left=0; right=0;}
        }
        return max;
    }

    /**
     栈方法
     假如输入 ")(()))"
     初始化   数组[0,0,0,0,0,0]
     入栈，栈存左括号坐标
     一旦右括号匹配上  出栈 左括号和有括号坐标设置为0
     栈为空时，')'直接丢弃，坐标设置为1
     得到数组 [1,0,0,0,0,1]
     计算多少个 0 连续  遇到0当前长度+1，遇到1当前长度=0， 时刻保留最大值
     */
    public static int useStack(String s){
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int[] array = new int[chs.length];
        for(int i=0;i<chs.length;i++){
            if(stack.size()==0&&chs[i]==')') {
                array[i]=1;
                continue;
            }
            if(chs[i]=='('){
                array[i] = 1;
                stack.push(i);
            }else {
                // ')'
                array[stack.pop()] = 0;
                array[i] = 0;
            }
        }
        // 100001
        int max = 0;
        int current = 0;
        for(int i:array)
            if(i==1) current = 0;
            else {
                current++;
                max = Math.max(current,max);
            }
        return max;
    }

    /**
     dp 算法思路 (链接很详细)
     https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     */
    static int dpFunction(String str){
        char[] chs = str.toCharArray();
        int len = chs.length;
        if(len==0) return 0;
        int[] dp =new int[len];
        for(int i=1;i<len;i++)
            if(chs[i]=='(') dp[i]=0;
            else {
                // chs[i] = ')'
                if(chs[i-1]=='(')
                    dp[i] = (i-2>=0?dp[i-2]:0)+2;
                else {
                    // chs[i] = ')' chs[i-1] = ')'
                    if(i-dp[i-1]-1>=0&&chs[i-dp[i-1]-1]=='('){
                        dp[i] = dp[i-1]+2;
                        if(i-dp[i-1]-2>=0&&chs[i-dp[i-1]-2]==')') {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }

        int max = 0;
        for(int i:dp) max = Math.max(max,i);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Offer_32_LongestValidParentheses().longestValidParentheses("()()))))()()("));
    }

}
