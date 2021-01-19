package niuke;

/**
 题目描述
 请实现有重复数字的升序数组的二分查找。
 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 示例1
 输入
 复制
 5,4,[1,2,4,4,5]
 返回值
 复制
 3
 说明
 输出位置从1开始计算
 */
public class UpperBound {
    /**
     * 大于等于
     * @param n
     * @param v
     * @param a
     * @return
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        int last = n+1;
        if (n==0) return last;
        // last index
        int left = 0;
        int right = a.length-1;
        int pivot;
        while (left<=right){
            pivot = (left+right)/2;
            if(a[pivot]>=v) {
                last = pivot+1;
                right = pivot-1;
            }else {
                left = pivot+1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(upper_bound_(100,1,new int[]{2,3,4,4,4,7,7,8,10,10,11,12,13,14,15,15,17,18,19,23,24,24,24,24,25,26,26,26,27,27,28,29,29,30,33,36,38,38,40,40,41,43,43,43,44,46,46,47,51,52,52,53,54,56,57,57,57,58,58,61,61,61,62,64,64,66,66,67,67,67,70,72,74,74,74,75,75,78,78,78,79,79,80,83,83,83,83,84,84,86,88,89,89,90,91,91,92,93,93,96}));
    }
}
