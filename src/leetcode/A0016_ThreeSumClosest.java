package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0016_ThreeSumClosest {
    /**
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

    例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

    与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
    **/

    /**
     * 排序后 -> 用双指针
     * nlogn + n2 = n2
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer result = nums[0]+nums[1]+nums[2];
        for(int i = 0;i<nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(result-target))result = sum;
                if(sum<target) j++;
                if(sum>target) k--;
                if(sum==target) return sum;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] data = {1,1,1,0};
        System.out.println(threeSumClosest(data,100));
    }
}
