package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class A0128_LongestConsecutive {
    public int longestConsecutive_double_set(int[] nums) {
        int maxLen = 0;
        // 快速判断原始数组中是否存在某个元素
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        // 判断元素是否已经被并入过别的区间
        HashSet<Integer> haveJudgeSet = new HashSet<>();
        for(int num:set){
            if(haveJudgeSet.contains(num))continue;
            int len = 1;
            // 本次后失效
            haveJudgeSet.add(num);
            int l = num-1;
            int r = num+1;
            // 向左查询
            while (set.contains(l)&&!haveJudgeSet.contains(l)){
                len++;
                haveJudgeSet.add(l);
                l--;
            }
            // 向右查询
            while (set.contains(r)&&!haveJudgeSet.contains(r)){
                len++;
                haveJudgeSet.add(r);
                r++;
            }
            // 更新最大值
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
    public static int longestConsecutive_single_map(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int num:nums)
            map.put(num,false);
        int maxLen = 0;
        for(int num:map.keySet()){
            if(map.get(num)) continue;
            // 移除本数
            map.put(num,true);
            int len = 1;
            int l = num-1;
            int r = num+1;
            while (map.containsKey(l)&&!map.get(l)){
                len++;
                map.put(l,true);
                l--;
            }
            while (map.containsKey(r)&&!map.get(r)){
                len++;
                map.put(r,true);
                r++;
            }
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
    public static int longestConsecutive_single_set(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        int maxLen = 0;
        // 本处不能用set迭代，会报错 concurrentModify 错误
        for(int num:nums){
            if(!set.contains(num))continue;
            int len = 1;
            int l = num-1;
            int r = num+1;
            while (set.contains(l)){
                len++;
                set.remove(l);
                l--;
            }
            while (set.contains(r)){
                len++;
                set.remove(r);
                r++;
            }
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }


    public static void main(String[] args) {
    }
}
