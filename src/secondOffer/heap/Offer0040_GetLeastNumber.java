package secondOffer.heap;

import java.util.Arrays;
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
public class Offer0040_GetLeastNumber {
    /**
     基于最大堆排序
     时间 O(n*log(K))
     空间 O(K)
     */
    public int[] getLeastNumbers_Heap(int[] arr, int k) {
        if(k==0) return new int[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int a:arr) {
            if (heap.size() >= k&&a<heap.peek()){
                heap.poll();
                heap.offer(a);
            }
            if(heap.size()<k) heap.offer(a);
        }
        int[] res = new int[k];
        int i=0;
        while (heap.size()!=0) res[i++] = heap.poll();
        return res;
    }

    /**
     通过快排变形(快搜)
     */
    boolean finish;

    public int[] getLeastNumbers_QuickSelect(int[] arr, int k) {
        quickSelect(arr,0,arr.length-1,k);
        return  Arrays.copyOf(arr,k);
    }
    void quickSelect(int[] arr,int start,int end,int k){
        if(start>end||finish) return;
        int pivot = arr[end];
        int left = start;
        int right = end;
        while (left<right){
            // 先左
            while (arr[left]<pivot&&left<right) left++;
            if(left!=right){
                arr[right] = arr[left];
                right--;
            }
            if(left==right) break;
            // 后右
            while (arr[right]>pivot&&left<right)right--;
            if(left!=right){
                arr[left] = arr[right];
                left++;
            }
        }
        arr[left] = pivot;
        if(left+1==k) finish=true;
        else if(k>left+1) quickSelect(arr,left+1,end,k);
        else if(k<left+1) quickSelect(arr,start,left-1,k);
    }


    public static void main(String[] args) {
        int[] arr = new Offer0040_GetLeastNumber().getLeastNumbers_QuickSelect(new int[]{0,0,1,2,4,2,2,3,1,4}, 8);
    }
}
