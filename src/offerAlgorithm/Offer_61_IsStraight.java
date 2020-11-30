package offerAlgorithm;

import java.util.HashSet;
import java.util.Set;

/**
 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

  

 示例 1:

 输入: [1,2,3,4,5]
 输出: True
  

 示例 2:

 输入: [0,0,1,2,5]
 输出: True
  

 限制：

 数组长度为 5 

 数组的数取值为 [0, 13] .
 */
public class Offer_61_IsStraight {

    /**
     不管joker数量多少，都要满足max-min<5 同时没有重复元素
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Integer max=0;
        Integer min=14;
        for(int num:nums){
            if(num==0)
                continue;
            if(set.contains(num))
                return false;
            set.add(num);
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        return max-min<5;
    }
}
