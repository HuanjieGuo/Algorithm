package leetcode;

/**
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 如果数组中不存在目标值 target，返回 [-1, -1]。

 进阶：

 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
  

 示例 1：

 输入：nums = [5,7,7,8,8,10], target = 8
 输出：[3,4]
 示例 2：

 输入：nums = [5,7,7,8,8,10], target = 6
 输出：[-1,-1]
 示例 3：

 输入：nums = [], target = 0
 输出：[-1,-1]

 */
public class A0034_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int lens = nums.length;
        int left = 0;
        int right = lens -1;
        int targetIndex = -1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                targetIndex = mid;
                break;
            }else if(nums[mid]>target) right = mid-1;
            else left = mid+1;
        }
        if(targetIndex==-1) return new int[]{-1,-1};
        int start = targetIndex;
        int end = targetIndex;
        while (start>0&&nums[start-1]==target) start--;
        while (end<lens-1&&nums[end+1]==target) end++;
        return new int[]{start,end};
    }
}
