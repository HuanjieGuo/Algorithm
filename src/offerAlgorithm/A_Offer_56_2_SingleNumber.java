package offerAlgorithm;

/**
 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

  

 示例 1：

 输入：nums = [3,4,3,3]
 输出：4
 示例 2：

 输入：nums = [9,1,7,9,7,9,7]
 输出：1
  

 限制：

 1 <= nums.length <= 10000
 1 <= nums[i] < 2^31

 */
public class A_Offer_56_2_SingleNumber {
    public static int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        int bitMask = 1;
        for (int i = 31; i >= 0; i--) {
            for (int num : nums)
                // 本处 & 的结果不一定为01！！！！ 需要用++ 而不是直接累加
                if ((num & bitMask) != 0) bitSum[i]++;
            bitMask <<= 1;
        }
        int result = 0;
        for(int bit:bitSum){
            // 先移动，如果放后面  最后多移动一次！
            result<<=1;
            result ^= bit%3;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3,70,3,3}));
    }
}
