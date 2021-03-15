package secondOffer.heap;

import java.util.PriorityQueue;

/**
 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

 例如，

 [2,3,4] 的中位数是 3

 [2,3] 的中位数是 (2 + 3) / 2 = 2.5

 设计一个支持以下两种操作的数据结构：

 void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 double findMedian() - 返回目前所有元素的中位数。
 示例 1：

 输入：
 ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 [[],[1],[2],[],[3],[]]
 输出：[null,null,null,1.50000,null,2.00000]
 示例 2：

 输入：
 ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 [[],[2],[],[3],[]]
 输出：[null,null,2.00000,null,2.50000]
  

 限制：

 最多会对 addNum、findMedian 进行 50000 次调用。

 */
public class Offer0041_MedianFinder {
    PriorityQueue<Integer> wonderfulClass;
    PriorityQueue<Integer> normalClass;

    public Offer0041_MedianFinder() {
        wonderfulClass = new PriorityQueue<>();
        // 普通班最大堆
        normalClass = new PriorityQueue<>((o1, o2) -> o2-o1);
    }

    public void addNum(int num) {
        normalClass.add(num);
        //
        if(normalClass.size()-wonderfulClass.size()>1){
            wonderfulClass.offer(normalClass.poll());
        }
        while (wonderfulClass.size()!=0&&normalClass.peek()>wonderfulClass.peek()){
            wonderfulClass.offer(normalClass.poll());
            normalClass.offer(wonderfulClass.poll());
        }
    }

    public double findMedian() {
        if(normalClass.size()==0) return 0;
        if(normalClass.size()!=wonderfulClass.size()) return normalClass.peek();
        else return (normalClass.peek()+wonderfulClass.peek())/2.0;
    }

}
