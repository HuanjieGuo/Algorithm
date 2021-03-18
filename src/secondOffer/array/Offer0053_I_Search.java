package secondOffer.array;

/**
 统计一个数字在排序数组中出现的次数。

  

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: 2
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: 0
  

 */
public class Offer0053_I_Search {
    public int search(int[] nums, int target) {
        int idx = binarySearch(nums,target);
        if(idx==-1) return 0;
        int l = idx;
        int r = idx;
        while (l-1>=0&&nums[l-1]==target) l--;
        while (r+1<=nums.length-1&&nums[r+1]==target) r++;
        return r-l+1;
    }
    int binarySearch(int[] nums, int target){
        if(nums.length==0) return -1;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target)right = mid-1;
            else if(nums[mid]<target) left = mid+1;
        }
        return -1;
    }
}
