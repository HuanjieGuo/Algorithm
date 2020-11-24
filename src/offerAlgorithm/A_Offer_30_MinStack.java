package offerAlgorithm;

import java.util.Stack;

/**
 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

  

 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.min();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.min();   --> 返回 -2.
  

 提示：

 各函数的调用总次数不超过 20000 次
 */

/**
 * 辅助栈只押入<=顶部的值， 用纸演算下!
 */
public class A_Offer_30_MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public A_Offer_30_MinStack() {
        init();
    }

    private void init(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.size()==0||minStack.peek()>=x) minStack.push(x);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
