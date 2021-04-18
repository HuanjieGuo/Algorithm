package top100;

import java.util.HashMap;
import java.util.Map;

public class A0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null) return new int[]{map.get(nums[i]),i};
            map.put(target-nums[i],i);
        }
        return new int[0];
    }
}
