package leetcode;

/**
 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。

 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

  

 示例 1：

 输入：nums = [4,5,6,7,0,1,2], target = 0
 输出：4
 示例 2：

 输入：nums = [4,5,6,7,0,1,2], target = 3
 输出：-1
 示例 3：

 输入：nums = [1], target = 0
 输出：-1
  

 提示：

 1 <= nums.length <= 5000
 -10^4 <= nums[i] <= 10^4
 nums 中的每个值都 独一无二
 nums 肯定会在某个点上旋转
 -10^4 <= target <= 10^4

 */
public class A0033_SpiralSearch {
    // 算法思想，永远可以丢弃一半的数据！
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = len-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            // left <= right,
            // mid might be left!
            if(nums[left]<=nums[mid]){
                //左边有序
                if(nums[left]<=target&&target<nums[mid]) right = mid-1;
                else left = mid+1;

            }else {

                // 右边有序
                if(nums[mid]<target&&target<=nums[right]) left = mid+1;
                else right = mid - 1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a = new A0033_SpiralSearch().search(new int[]{3,1},1);
        System.out.println(a);
    }
}
