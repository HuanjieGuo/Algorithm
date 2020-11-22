package offerAlgorithm;

/**
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

  

 示例：

 输入：nums = [1,2,3,4]
 输出：[1,3,2,4]
 注：[3,1,2,4] 也是正确的答案之一。
  

 提示：

 1 <= nums.length <= 50000
 1 <= nums[i] <= 10000

 */
public class Offer_21_Exchange {
    /**
     * 双指针,头尾一起
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int head = 0;
        int behind = nums.length-1;
        while (head<behind){
            if(nums[head]%2==1){
                // 奇数，下一个
                head++;
                continue;
            }else {
                // 前面的偶数
                // 后面的数是奇数
                if(nums[behind]%2==1){
                    // 交换
                    int temp = nums[head];
                    nums[head] = nums[behind];
                    nums[behind] = temp;
                    head++;
                    behind--;
                    continue;
                }else {
                    // 后面的数是偶数
                    behind--;
                    continue;
                }
            }
        }
        return nums;
    }
}
