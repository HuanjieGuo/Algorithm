package hot100;

public class A0034_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int idx = -1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) {
                idx = mid;
                break;
            }else if(nums[mid]>target) right = mid-1;
            else left = mid+1;
        }
        if(idx==-1) return new int[]{-1,-1};
        left = idx;
        right = idx;
        while (left>=1&&nums[left-1]==target) left--;
        while (right<=len-2&&nums[right+1]==target) right++;
        return new int[]{left,right};
    }

}
