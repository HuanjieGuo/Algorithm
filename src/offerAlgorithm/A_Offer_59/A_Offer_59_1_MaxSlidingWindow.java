package offerAlgorithm.A_Offer_59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
  

 提示：

 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class A_Offer_59_1_MaxSlidingWindow {
    /**
     1.维护递减数列deque
     2.注意移除window的值是否和deque第一个相等，如果相等 deque移除
     3. 每轮返回deque.first
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length+1-k];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            // 移除最尾，递减
            while (deque.size()!=0&&deque.getLast()<nums[i])
                deque.removeLast();
            deque.add(nums[i]);
            // 溢出  移除头
            if(i>=k&&nums[i-k]==deque.getFirst())
                deque.removeFirst();
            // 直接返回
            if(i>=k-1)
                res[i+1-k] = deque.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,1,2,0,5};
        maxSlidingWindow(arr,3);
    }
}
