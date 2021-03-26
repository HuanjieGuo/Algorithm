package secondOffer.array;

/**
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

  

 示例：

 输入：nums = [1,2,3,4]
 输出：[1,3,2,4]
 注：[3,1,2,4] 也是正确的答案之一。
  

 */
public class Offer0021_Exchange {
    public int[] exchange(int[] nums) {
        if (nums.length==0) return new int[0];
        int right = nums.length-1;
        int left = 0;
        while (right>left)
            if(nums[right]%2==0) right--;
            else {
                // right奇数,left去找偶数对换
                if(nums[left]%2==0){
                    // 交换
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
                left++;
            }
        return nums;
    }
}
