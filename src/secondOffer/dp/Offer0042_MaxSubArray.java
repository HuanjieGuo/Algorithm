package secondOffer.dp;


public class Offer0042_MaxSubArray {
    /**
     dp算法
     时间复杂度 O(N)
     空间复杂度 O(N)  本处可以优化成O(1) 在nums数组操作
     dp数组+max
     if (dp[i-1]<=0) dp[i] = num[i]
     else dp[i] = dp[i-1] + num[i]
     */
    public int maxSubArray_DP(int[] nums) {
        if (nums.length==0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<nums.length;i++) {
            if (dp[i - 1] <= 0) dp[i] = nums[i];
            else dp[i] = dp[i - 1] + nums[i];
            max = Math.max(dp[i],max);
        }
        return max;
    }

    /**
     暴力算法
     时间复杂度 O(N^2)
     空间复杂度 O(1)
     */
    public int maxSubArray_BF(int[] nums){
        if(nums.length==0) return 0;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum = nums[j]+sum;
                max = Math.max(sum,max);
            }
        }
        return max;
    }

}
