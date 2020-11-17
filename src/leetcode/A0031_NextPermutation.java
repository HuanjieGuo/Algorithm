package leetcode;

import java.util.Arrays;

/**
 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 找出这个数组排序出的所有数中，刚好比当前数大的那个数

 比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，比123大的那个数 也就是132

 如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，那么就返回1，2，3排序后所有数中最小的那个，也就是1，2，3 -> [1,2,3]

 */
public class A0031_NextPermutation {
    /**
     * 时间复杂度是O(n)
     * 指针后往前   判断是否  i<i+1。
     * 如果是  另一个指针从后开始   判断哪个值大于0
     * 换位
     * i+1到length-1全部换位
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        for(int i=length-2;i>=0;i--){
            if (nums[i] < nums[i+1]) {
                //寻找大于的那个数
                for(int j=length-1;j>i;j--){
                    if(nums[j]>nums[i]){
                        // 换位
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        // 反转
                        for(int k=0;k<(length-(i+1))/2;k++){
                            int temp2 = nums[k+i+1];
                            nums[k+i+1] = nums[length-k-1];
                            nums[length-k-1] = temp2;
                        }
                        return;
                    }
                }

            }
        }
        // 直接反转
        for(int i=0;i<length/2;i++){
            int temp = nums[i];
            nums[i] = nums[length-i-1];
            nums[length-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        //"aabbaabbaabb"
        //      ["bb","aa","bb","aa","bb"]
        nextPermutation(new int[]{3,2,1});
    }
}
