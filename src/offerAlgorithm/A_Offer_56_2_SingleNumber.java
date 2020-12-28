package offerAlgorithm;

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
