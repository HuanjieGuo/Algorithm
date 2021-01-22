package niuke;

import java.util.Stack;

public class A_IsVaild {
    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char ch:chars)
            if(ch=='('||ch=='['||ch=='{') stack.push(ch);
            else if(ch==')'){
                if(stack.size()!=0&&stack.peek()=='(') stack.pop();
                else return false;
            }
            else if(ch==']'){
                if(stack.size()!=0&&stack.peek()=='[') stack.pop();
                else return false;
            }
            else if(ch=='}'){
                if(stack.size()!=0&&stack.peek()=='{') stack.pop();
                else return false;
            }
            return stack.size()==0;
        // write code here
    }

}
