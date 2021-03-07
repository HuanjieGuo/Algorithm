package offerAlgorithm;

import java.util.Comparator;
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
public class A_Offer_41_MedianFinder {
    /**
     思路：
     分普通班和尖子班
     普通班人数-尖子班人数     x = [0,1]
     进来先进普通班
     看看普通班最优秀的人和尖子班最差的人是否需要换位
     返回普通班最优秀的
     或者(普通班最优秀的+尖子班最差的)/2
     */
    /** initialize your data structure here. */
    PriorityQueue<Integer> normalClass;
    PriorityQueue<Integer> wonderfulCalss;
    public A_Offer_41_MedianFinder() {
        normalClass = new PriorityQueue<>((o1, o2) -> o2-o1);
        wonderfulCalss = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 保证普通班比优秀班多1
        // 进来先进普通班
        normalClass.add(num);
        // 判断大小
        if(normalClass.size()-wonderfulCalss.size()>1)
            wonderfulCalss.add(normalClass.poll());
        // 如果普通班的最高分比尖子班的最低分高，换位
        if(normalClass.size()!=0&&wonderfulCalss.size()!=0){
            while (wonderfulCalss.peek()<normalClass.peek()){
                int normalTop = normalClass.poll();
                int wonderLow = wonderfulCalss.poll();
                normalClass.offer(wonderLow);
                wonderfulCalss.offer(normalTop);
            }
        }

    }

    public double findMedian() {
        if(normalClass.size()-wonderfulCalss.size()==1) return normalClass.peek();
        if(normalClass.size()==wonderfulCalss.size()){
            if (normalClass.size()==0) return 0.0;
            return (normalClass.peek()+wonderfulCalss.peek())/2.0;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        A_Offer_41_MedianFinder finder = new A_Offer_41_MedianFinder();
//        finder.normalClass.offer(1);
//        finder.normalClass.offer(2);
//        System.out.println(finder.normalClass.poll());




    }
}
