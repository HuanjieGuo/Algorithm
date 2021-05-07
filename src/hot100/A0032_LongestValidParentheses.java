package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A0032_LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        char[] chs = s.toCharArray();
        if(len==0) return 0;
        Stack<Character> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int[] zeroone = new int[len];
        for(int i=0;i<len;i++){
            if(chs[i]=='('){
                list.add(i);
                stack.push('(');
            }else {
                if(stack.size()>0&&stack.peek()=='('){
                    int lenOfList = list.size();
                    stack.pop();
                    zeroone[list.get(lenOfList-1)] = 1;
                    zeroone[i] = 1;
                    list = list.subList(0,lenOfList-1);
                }else {
                    stack.push(')');
                }
            }
        }

        int idx = 0;
        int max = 0;
        int current = 0;
        while (idx<len){
            if(zeroone[idx]==1){
                current++;
            }else {
                max = Math.max(max,current);
                current = 0;
            }
            idx++;
        }
        max = Math.max(max,current);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}
