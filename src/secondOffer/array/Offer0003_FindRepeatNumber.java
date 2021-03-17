package secondOffer.array;

import java.util.HashSet;
import java.util.Set;

/**
 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 示例 1：

 输入：
 [2, 3, 1, 0, 2, 5, 3]
 输出：2 或 3


 */
public class Offer0003_FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)) return num;
            set.add(num);
        }
        return 0;
    }
    public int findRepeatNumber_swap(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]) return nums[i];
                int positionNum = nums[i];
                nums[i] = nums[nums[i]];
                nums[positionNum] = positionNum;
            }
        }
        return 0;
    }
}
