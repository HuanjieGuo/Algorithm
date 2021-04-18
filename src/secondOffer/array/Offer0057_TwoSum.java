package secondOffer.array;

import java.util.Arrays;

public class Offer0057_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int sum = nums[left]+nums[right];
            if(sum==target) return new int[]{nums[left],nums[right]};
            else if(sum>target) right--;
            else if(sum<target) left++;
        }
        return new int[0];
    }
}
