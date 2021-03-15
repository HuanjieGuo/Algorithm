package secondOffer.sort;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;

public class Offer0045_MinNumber {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            str[i] = String.valueOf(nums[i]);
        Comparator<String> comparator = (o1, o2) -> (o1+o2).compareTo(o2+o1);
        Arrays.sort(str,comparator);
        StringBuilder string = new StringBuilder();
        for(String st:str) string.append(st);
        return string.toString();
    }
}
