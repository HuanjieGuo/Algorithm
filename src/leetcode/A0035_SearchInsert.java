package leetcode;

/**
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
 输出: 2
 示例 2:

 输入: [1,3,5,6], 2
 输出: 1
 示例 3:

 输入: [1,3,5,6], 7
 输出: 4
 示例 4:

 输入: [1,3,5,6], 0
 输出: 0

 */
public class A0035_SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int pivot = (left+right)/2;
            if(target==nums[pivot]) return pivot;
            if(target>nums[pivot]) {
                left = pivot+1;
                // 判断
                if(left==nums.length||target<nums[left]) return left;
            }else {
                // 小于pivot
                right = pivot-1;
                if(right==-1) return 0;
                if(target>nums[right]) return pivot;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }
}
