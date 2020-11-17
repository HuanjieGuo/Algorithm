package offerAlgorithm;

import java.util.Stack;

/**
 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

  

 示例 1：

 输入：
 ["CQueue","appendTail","deleteHead","deleteHead"]
 [[],[3],[],[]]
 输出：[null,null,3,-1]
 示例 2：

 输入：
 ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 [[],[],[5],[2],[],[]]
 输出：[null,-1,null,null,5,2]
 提示：

 1 <= values <= 10000
 最多会对 appendTail、deleteHead 进行 10000 次调用

 */
public class Offer_09_CQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public Offer_09_CQueue(){
        init();
    }
    public void init(){
        inStack = new Stack();
        outStack = new Stack();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        // outStack不为0
        if(outStack.size()!=0){
            return outStack.pop();
        }else {
            // outStack为0

            //本处需要用time记录 inStack.size(), 否则size变化出错
            int time = inStack.size();
            for(int i=0;i<time;i++){
                outStack.push(inStack.pop());
            }
            if(outStack.size()==0){
                return -1;
            }else {
                return outStack.pop();
            }
        }
    }

    public static void main(String[] args) {
    }
}
