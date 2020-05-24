package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * list中哪两个数的INDEX 相加等于需要数字
 * TIP :哈希表   KEY: SUM-NUMBER   VALUE:INDEX
 */
public class SumOfTwoNumber {
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
        SumOfTwoNumber sumOfTwoNumber = new SumOfTwoNumber();
        int[] data = {2,7, 11,12,13, 15};
        int[] result = sumOfTwoNumber.twoSum(data,25);
        for(int num:result){
            System.out.println(num);
        }
    };
}
