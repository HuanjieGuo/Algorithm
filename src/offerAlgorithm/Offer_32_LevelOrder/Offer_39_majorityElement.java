package offerAlgorithm.Offer_32_LevelOrder;

import java.util.HashMap;
import java.util.Map;

/**
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

  

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

  

 示例 1:

 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 输出: 2

 */
public class Offer_39_majorityElement {
    /**
     * map法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int halfLength = nums.length/2+1;
        for(int num:nums){
            Integer time = map.get(num);
            if(time==null) time = 0;
            map.put(num,time+1);
            if(time+1>=halfLength)
                return num;
        }
        return 0;
    }

    /**
     * 摩尔投票法（因为要大于一半，所以相互抵消！）
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Integer electNum = null;
        int count = 0;
        for (int num:nums){
            if(count==0) {
                electNum = num;
                count++;
                continue;
            }
            // count != null
            if(electNum==num) count++;
            else count--;
        }
        return electNum;
    }

}
