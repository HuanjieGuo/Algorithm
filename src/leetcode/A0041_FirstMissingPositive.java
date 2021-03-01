package leetcode;

/**
 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

  

 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？

  

 示例 1：

 输入：nums = [1,2,0]
 输出：3
 示例 2：

 输入：nums = [3,4,-1,1]
 输出：2
 示例 3：

 输入：nums = [7,8,9,11,12]
 输出：1
  

 提示：

 0 <= nums.length <= 300
 -231 <= nums[i] <= 231 - 1

 */
public class A0041_FirstMissingPositive {
    // 如果num[j]>=1 放回值-1的坐标
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        /**
         本处要新建空间，
         原因是[3,4,-1,1]
         i = 0;  [-1,4,3,1]
         i = 1; [-1,1,3,4]
         结束
         此时1的位置不正确！
         */
        int[] newNums = new int[len];
        for(int i=0;i<len;i++){
            int num = nums[i];
            if(num<=0) continue;
            if(num>len) continue;
            newNums[num-1] = num;
        }
        for(int i=0;i<len;i++)
            if(newNums[i]!=i+1) return i+1;
        return len+1;
    }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{3,4,-1,1});
    }
}
