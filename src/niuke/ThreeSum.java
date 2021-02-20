package niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 题目描述
 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 注意：
 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 解集中不能包含重复的三元组。
 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)

 示例1
 输入
 复制
 [-2,0,1,1,2]
 返回值
 复制
 [[-2,0,2],[-2,1,1]]
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = num.length;
        if(len<3) return result;
        // n * logn
        Arrays.sort(num);
        //
        for(int i=0;i<len-2;i++){
            // 本处记得判断是否上个一样
            if(i>0&&num[i]==num[i-1])
                continue;
            int left = i+1;
            int right = len-1;
            if(num[i]+2*num[left]>0) continue;
            if(num[i]+2*num[right]<0) continue;
            while (left<right){
                int sum = num[i]+num[left]+num[right];
                if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }else {
                    // 相等
                    ArrayList<Integer> set = new ArrayList<>();
                    set.add(num[i]);
                    set.add(num[left]);
                    set.add(num[right]);
                    result.add(set);
                    left++;
                    right--;
                    while (left<right&&num[left]==num[left-1]) left++;
                    while (left<right&&num[right]==num[right+1]) right--;
                }
            }
        }
        return result;
    }
}
