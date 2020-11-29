package offerAlgorithm.A_Offer_53;

/**
 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

  

 示例 1:

 输入: [0,1,3]
 输出: 2
 示例 2:

 输入: [0,1,2,3,4,5,6,7,9]
 输出: 8
  

 限制：

 1 <= 数组长度 <= 10000

 */
public class A_Offer_53_2_MissingNumber {
    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int pivot = (left+right)/2;
            if(nums[pivot]!=pivot){
                // 左边
                right = pivot-1;
            }else {
                //右边
                left = pivot+1;

            }
        }
        // 判断是否缺头
        if(nums[0]!=0)
            return 0;
        // 判断是否缺尾
        else if(nums[nums.length-1]== nums.length-1)
            return nums.length;
        // 直接返回
        return left;
    }

    public static void main(String[] args) {
        System.out.println(A_Offer_53_2_MissingNumber.missingNumber(new int[]{0,2,3}));
    }
}
