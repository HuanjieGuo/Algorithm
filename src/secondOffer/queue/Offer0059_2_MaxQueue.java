package secondOffer.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

 若队列为空，pop_front 和 max_value 需要返回 -1

 */
public class Offer0059_2_MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> maxDeque;

    public Offer0059_2_MaxQueue() {
        queue = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public int max_value() {
        if(maxDeque.size()==0) return -1;
        return maxDeque.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (maxDeque.size()!=0&&maxDeque.getLast()<value) maxDeque.removeLast();
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if(queue.size()==0) return -1;
        Integer popValue = queue.poll();
        if(popValue.equals(maxDeque.getFirst())) maxDeque.removeFirst();
        return popValue;
    }
}
