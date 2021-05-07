package hot100;

public class A0033_Search {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<=nums[mid]){
                // 左边有序
                if(target>=nums[left]&&target<nums[mid]) right = mid-1;
                else left = mid+1;
            }else {
                // 右边有序
                if(target>nums[mid]&&target<=nums[right]) left = mid+1;
                else right = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));
    }
}
