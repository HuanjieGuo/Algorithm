package top100;

public class A0004_FindMedianSortedArrays {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        // 让nums1为短的
//        if(nums1.length>nums2.length){
//            int[] tmp = nums1;
//            nums1 = nums2;
//            nums2 = tmp;
//        }
//        int m = nums1.length;
//        int n = nums2.length;
//
//        // 分割线左边的所有元素满足的个数, 防止溢出等价写法 m + (n - m + 1)/2;
//        int totalLeft = (m+n+1)/2;
//
//        // 在nums1的区间[0,m]里查找恰当的分割线，
//        // 使得 num1[i-1] <= num2[j] && num2[j-1]<=[i]
//        int left = 0;
//        int right = m;
//
//        while (left<right){
//            int i = (left+right+1)/2;
//            int j = totalLeft - i;
//            if(nums1[i-1]>nums2[j]){
//                // 下一轮搜索区间 [left, i-1]
//                right = i-1;
//            }else {
//                // 下一轮搜索区间[i,right]
//                left = i;
//            }
//        }
//        int i = left;
//        int j = totalLeft - i;
//        int num1LeftMax = i==0?Integer.MIN_VALUE:nums1[i-1];
//        int num1RightMin = i==m?Integer.MAX_VALUE:nums1[i];
//        int num2LeftMax = j==0?Integer.MIN_VALUE:nums2[j-1];
//        int num2RightMin = j==n?Integer.MAX_VALUE:nums2[j];
//        if(((m+n)%2)==1) return Math.max(num1LeftMax,num2LeftMax);
//        else return (double)((Math.max(num1LeftMax,num2LeftMax)+Math.min(num1RightMin,num2RightMin)))/2;
//    }

    //
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 让num1为小的
        if(m>n) return findMedianSortedArrays(nums2,nums1);
        // 计数情况下，把中位数放在左边
        int totalLeft = (m+n+1)/2;
        // num1 初始左搜索和右搜索
        int left = 0;
        int right = m;
        while (left<right){
            // nums1 的右边起点,本处让i最起码为1
            int i = (left+right+1)/2;
            int j = totalLeft - i;
            if(nums1[i-1]>nums1[j])
                right = i - 1;
            else left = i;
        }
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i==0?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin = i==m?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax = j==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin = j==n?Integer.MAX_VALUE:nums2[j];
        if((n+m)%2==1) return Math.max(nums1LeftMax,nums2LeftMax);
        else return (double)(Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums1RightMin,nums2RightMin))/2;
    }
}
