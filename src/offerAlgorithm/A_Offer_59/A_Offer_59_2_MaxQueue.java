package offerAlgorithm.A_Offer_59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

 若队列为空，pop_front 和 max_value 需要返回 -1

 示例 1：

 输入:
 ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 [[],[1],[2],[],[],[]]
 输出: [null,null,null,2,1,2]
 示例 2：

 输入:
 ["MaxQueue","pop_front","max_value"]
 [[],[],[]]
 输出: [null,-1,-1]
  

 限制：

 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 1 <= value <= 10^5

 */
public class A_Offer_59_2_MaxQueue {
    Queue<Integer> queue;
    // 维护降序queue
    Deque<Integer> deque;
    public A_Offer_59_2_MaxQueue(){
        init();
    }
    public void init(){
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if(deque.size()==0)
            return -1;
        return deque.getFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (deque.size()!=0&&deque.getLast()<value)
            deque.removeLast();
        deque.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        Integer pop = queue.poll();
        // Integer 不能用==比较, equal!
        if(deque.getFirst().equals(pop))
            deque.removeFirst();
        return pop;
    }
}
