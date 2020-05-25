package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

         

        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]

**/

/**
 * list中哪两个数的INDEX 相加等于需要数字
 * TIP :哈希表   KEY: SUM-NUMBER   VALUE:INDEX
 *
 */
public class A0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            boolean exist = map.keySet().contains(nums[i]);
            if(exist){
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
    public static void main(String[] args){
        A0001_TwoSum sumOfTwoNumber = new A0001_TwoSum();
        int[] data = {2,7, 11,12,13, 15};
        int[] result = sumOfTwoNumber.twoSum(data,25);
        for(int num:result){
            System.out.println(num);
        }
    };
}
