package offerAlgorithm;

/**
 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

  

 示例 1：

 输入：nums = [4,1,4,6]
 输出：[1,6] 或 [6,1]
 示例 2：

 输入：nums = [1,2,10,4,1,4,3,3]
 输出：[2,10] 或 [10,2]
  

 限制：

 2 <= nums.length <= 10000

 */
public class A_Offer_56_1_SingleNumbers {
    /**
     	==  !=	等于/不等于
     	&	按位与
     	^	按位异或
     	|	按位或
     */
    public static int[] singleNumbers(int[] nums) {
        // 全部数字异或的结果
        // a^b^a = b!
        int ret = 0;
        int a=0;
        int b=0;
        for(int num:nums)
            ret ^= num;

        // 从第一位找异或后为1的位
        int h=1;
        while ((h&ret)==0){
            h<<=1;
        }

        //根据找到的位分组异或
        for(int num:nums)
            if((h&num)==0)
                a ^= num;
            else b^=num;
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        singleNumbers(new int[]{4,2,4,6});
    }
}
