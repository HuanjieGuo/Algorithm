package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

  

 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

**/

public class A0015_ThreeSum {
    /**
     * 先排序  然后用二数和  双指针做
     * 复杂度 n2
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 复杂度 O(n * logn)
        Arrays.sort(nums);
        // 复杂度 O(n2)
        for(int i = 0;i<nums.length;i++){
            if(i>0){
                if(nums[i-1]==nums[i]){
                    continue;
                }
            }
            int target = -nums[i];
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[j]);
                    subResult.add(nums[k]);
                    if(result.size()==0) {
                        result.add(subResult);
                    }else if(!result.get(result.size()-1).equals(subResult)){
                        result.add(subResult);
                    }
                    j++;
                    k--;
                    while (nums[j-1]==nums[j] && j<k) j++;
                    while (nums[k]==nums[k+1] && j<k) k--;
                }else if(nums[j]+nums[k]<target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(data));
    }
}
