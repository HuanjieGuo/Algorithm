package secondOffer.array;

/**
 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

  

 示例 1:

 输入: [0,1,3]
 输出: 2
 */
public class Offer0053_II_MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            // 只判断左边是否正常
            if(mid!=left&&nums[mid-1]!=mid-1){
                right = mid-1;
                continue;
            }
            // mid不正常
            if(nums[mid]!=mid) return mid;
            // 右边不正常
            left = mid+1;
        }
        return nums.length;
    }
}
