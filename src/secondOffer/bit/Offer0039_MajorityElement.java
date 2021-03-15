package secondOffer.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Offer0039_MajorityElement {
    /**
     map 计数算法
     时间复杂度  O(n)
     空间复杂度  O(n)
     */
    public int majorityElement_Map(int[] nums) {
        int maxCount = 0;
        int mostNum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            int newCount =  map.getOrDefault(num,0)+1;
            map.put(num,newCount);
            if(newCount>maxCount){
                maxCount = newCount;
                mostNum = num;
            }
        }
        return mostNum;
    }

    /**
     排序法
     时间复杂度  O(N*logN)
     空间复杂度  1
     */
    public int majorityElement_Rank(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     摩尔投票法
     时间复杂度 ： O(n)
     空间复杂度 ： 1
     本题最佳
     */
    public int majorityElement_Moer(int[] nums) {
        Integer multiNum = null;
        int count = 0;
        for(int num:nums){
            if(multiNum==null){
                multiNum = num;
                count++;
            }else if(multiNum==num)
                count++;
            else {
                count--;
                if(count==0) multiNum = null;
            }
        }
        return multiNum;
    }

    public static void main(String[] args) {

    }
}
