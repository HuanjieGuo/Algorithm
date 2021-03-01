package leetcode;

/**
 接雨水问题

 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

  

 示例 1：


 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 输出：6
 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 示例 2：

 输入：height = [4,2,0,3,2,5]
 输出：9
  

 提示：

 n == height.length
 0 <= n <= 3 * 104
 0 <= height[i] <= 105

 */

/**
 题解
 https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 评论1的双指针
 */
public class A0042_Trap {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax=0,rightMax = 0;
        int sum = 0;
        while (left<=right)
            if(leftMax<rightMax){
                // 左边能自己最大值就这样了
                sum += Math.max(0,leftMax-height[left]);
                leftMax = Math.max(leftMax,height[left]);
                left++;
            }else {
                sum += Math.max(0,rightMax-height[right]);
                rightMax = Math.max(rightMax,height[right]);
                right--;
            }
        return sum;
    }

    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
