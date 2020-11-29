package offerAlgorithm.Offer_57_2;

import java.util.ArrayList;
import java.util.List;

/**

 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



 示例 1：

 输入：target = 9
 输出：[[2,3,4],[4,5]]
 示例 2：

 输入：target = 15
 输出：[[1,2,3,4,5],[4,5,6],[7,8]]


 限制：

 1 <= target <= 10^5
 */
public class A_Offer_57_2_FindContinuousSequence {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int left=1;
        // 右边界
        int right = 1;
        int sum = 1;
        // 至少两个数
        while(left<=target/2){
            if(sum<target){
                right++;
                sum = sum+right;
            }else if(sum>target){
                sum = sum-left;
                left++;
            }else {
                // sum = target
                int size = right - left + 1;
                int[] array = new int[size];
                for (int i = left; i <= right; i++)
                    array[i - left] = i;
                list.add(array);
                sum = sum-left;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
    }
}

