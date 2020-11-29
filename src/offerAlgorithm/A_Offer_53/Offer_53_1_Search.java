package offerAlgorithm.A_Offer_53;

import java.util.HashMap;
import java.util.Map;

/**
 统计一个数字在排序数组中出现的次数。

  

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: 2
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: 0
  

 限制：

 0 <= 数组长度 <= 50000

 */
public class Offer_53_1_Search {
    /**
     排序数组
     二分查找( while )
     */
    public static int search1(int[] nums, int target) {
        if(nums.length==0) return 0;
        int left = 0;
        int right = nums.length-1;
        Integer sear = null;
        while (left<=right){
            int pivot = (left+right)/2;
            if(nums[pivot]==target){
                sear = pivot;
                break;
            }
            if(nums[pivot]>target)
                // 在左边
                right = pivot-1;
            else
                //在右边
                left = pivot+1;
        }
        if(sear==null) return 0;
        left = sear;
        right = sear;
        while(left>=0&&nums[left]==target) left--;
        while (right<nums.length&&nums[right]==target)right++;
        return right-left-1;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        System.out.println(search1(nums,1));
    }
}
