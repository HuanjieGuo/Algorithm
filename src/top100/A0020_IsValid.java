package top100;

import java.util.Stack;

public class A0020_IsValid {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char ch:chs){
            if(ch=='('||ch=='['||ch=='{')
                stack.push(ch);
            else {
                if(stack.size()==0) return false;
                switch (ch){
                    case ')':
                        if(stack.pop()!='(') return false;
                        break;
                    case ']':
                        if(stack.pop()!='[') return false;
                        break;
                    case '}':
                        if(stack.pop()!='{') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
