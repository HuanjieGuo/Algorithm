package leetcode;

import java.util.Stack;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true

 */
public class A0020_IsValid {
    /**
     * 栈解法  时间复杂度O(n) 栈存入对应右括号  POP比较是否相同
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{')  stack.push('}');
            else if(s.charAt(i)=='[')  stack.push(']');
            else if(s.charAt(i)=='(')  stack.push(')');
            else if(stack.empty()||stack.pop()!=s.charAt(i)) return false;
        }
        return stack.empty();
    }
}
