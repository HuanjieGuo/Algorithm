package niuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        // write code here
        for(int i=0;i<numbers.length;i++) {
            Integer idx = map.get(numbers[i]);
            if (idx != null) {
                int a[] = new int[]{i + 1,idx+1};
                Arrays.sort(a);
                return a;
            }else map.put(target-numbers[i],i);
        }
        return new int[]{};
    }
}
