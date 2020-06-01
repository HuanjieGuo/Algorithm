package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

 注意：

 答案中不可以包含重复的四元组。

 示例：

 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

 满足要求的四元组集合为：
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]

 */
public class A0018_FourSum {
    /**
     * 两层for + 双指针  复杂度O(n3)
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0){
                if(nums[i]==nums[i-1]){
                    continue;
                }
            }
            for(int j=i+1;j<nums.length;j++){
                // 第一个数+第二个数就比目标大的话 不用看了
                if(j>i+1){
                    if(nums[j]==nums[j-1]){
                        continue;
                    }
                }
                int k=j+1;
                int l=nums.length-1;
                while (k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k++;
                        l--;
                        while (nums[k]==nums[k-1]&&k<l)k++;
                        while (nums[l]==nums[l+1]&&k<l)l--;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] data = {1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(data,-11));
    }
}
