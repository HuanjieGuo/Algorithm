package hot100;

import java.util.Arrays;

public class A0031_NextPermutation {
    public static void nextPermutation(int[] nums) {
        Integer last = nums[nums.length-1];
        int i = nums.length-2;
        for(;i>=0;i--){
            // 从后往前 找到前一个点比后一个点小的位置
            if(nums[i]<nums[i+1]){
                // 肯定能找到
                for(int j=nums.length-1;j>=0;j--){
                    // 交换
                    if(nums[j]>nums[i]){
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
                break;
            }
        }
        // 对后面的大->小数组  转换成小->大数组
        int left = i+1;
        int right = nums.length-1;
        while (left<right){
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,0,2,3,2,0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
