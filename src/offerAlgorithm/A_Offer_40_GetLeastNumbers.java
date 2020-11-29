package offerAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

  

 示例 1：

 输入：arr = [3,2,1], k = 2
 输出：[1,2] 或者 [2,1]
 示例 2：

 输入：arr = [0,1,2,1], k = 1
 输出：[0]
  

 限制：

 0 <= k <= arr.length <= 10000
 0 <= arr[i] <= 10000
 */

public class A_Offer_40_GetLeastNumbers {
    /**
     大根堆， 满的时候从上面pop 再加入 靠重写priorityQueue实现
     */
    public static int[] getLeastNumbers(int[] arr, int k){
        if(k==0) return new int[0];
        // priorityQueue默认 小的在队列头，小根堆 。改写compare方法
        // 改写后  大的在队列前面，大根堆。
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // o1-o2 队列升序（默认情况）
                // o2-o1 队列降序
                return o2-o1;
            }
        });
        for(int ar:arr){
            // 满了
            if(queue.size()==k) {
                if(queue.peek()<=ar){
                    continue;
                }
                queue.poll();
            }
            queue.offer(ar);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++)
            res[i] = queue.poll();
        return res;
    }

    public static void main(String[] args) {
        getLeastNumbers(new int[1],1);
    }
}
