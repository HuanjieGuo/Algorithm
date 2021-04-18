package secondOffer.array;

import java.util.HashMap;
import java.util.Map;

public class Offer0061_IsStraight {
    public boolean isStraight(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num:nums) {
            max = Math.max(max,num);
            if(num!=0)min = Math.min(min,num);
            if(num!=0&&map.keySet().contains(num)) return false;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int zeroNum = map.getOrDefault(0,0);
        if(zeroNum>=4) return true;
        return max-min<5;
    }
}
