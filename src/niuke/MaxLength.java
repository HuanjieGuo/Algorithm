package niuke;

import java.util.HashMap;
import java.util.Map;

public class MaxLength {
    public int maxLength (int[] arr) {
        // write code here
        int max = 0;
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int start=0,end =0;end<arr.length;end++) {
            if (indexMap.get(arr[end])!=null
                &&indexMap.get(arr[end])>=start)
                start = indexMap.get(arr[end])+1;
            indexMap.put(arr[end],end);
            max = Math.max(max,end-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxLength().maxLength(new int[]{1,2,3,1,4,5,7,1}));
    }
}
