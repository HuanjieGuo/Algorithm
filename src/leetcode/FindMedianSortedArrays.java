package leetcode;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.Array;
import java.util.*;

public class FindMedianSortedArrays {
    /**
     * 找两个有序LIST的中位数
     * TIP: 寻找第K小数,剔除后第一个便是
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> array1 = new ArrayList();
        List<Integer> array2 = new ArrayList();
        for(int num:nums1){
            array1.add(num);
        }
        for(int num:nums2){
            array2.add(num);
        }
        // 是否奇数
        boolean isOdd = ((nums1.length+nums2.length)%2==1);
        //
        int numberInRank = (nums1.length+nums2.length)/2 + 1 - (isOdd?0:1);
        while (true){
            if(numberInRank==1||array1.size()==0||array2.size()==0){
                break;
            }
            int maxNumber1 = Math.min(numberInRank/2,array1.size());
            int maxNumber2 = Math.min(numberInRank/2,array2.size());
//            System.out.println("寻找第 "+numberInRank);
//            System.out.println(array1);
//            System.out.println(array2);
//            System.out.println("a1最大去除"+maxNumber1);
//            System.out.println("a2最大去除"+maxNumber2);
            if(array1.get(maxNumber1-1)<array2.get(maxNumber2-1)){
                //删除掉1
                array1 = array1.subList(maxNumber1,array1.size());
                numberInRank = numberInRank  - maxNumber1  ;
            }else {
                //删除2
                array2 = array2.subList(maxNumber2,array2.size());
                numberInRank = numberInRank - maxNumber2  ;
            }
        }
//        System.out.println("寻找第 "+numberInRank);
//        System.out.println(array1);
//        System.out.println(array2);
        if(numberInRank!=1){
            List<Integer> array = array1.size()!=0?array1:array2;
            if(isOdd){
                return array.get(numberInRank-1);
            }else {
                return (array.get(numberInRank-1)+array.get(numberInRank))/2.0;
            }
        }else {
            List<Integer> rankList = new ArrayList();
            // 等于0的 取前4
            for(int i=0;i<Math.min(2,array1.size());i++){
                rankList.add(array1.get(i));
            }
            for(int i=0;i<Math.min(2,array2.size());i++){
                rankList.add(array2.get(i));
            }
            Collections.sort(rankList);
            if(isOdd){
                return rankList.get(0);
            }else {
                System.out.println(rankList.get(0)+"  "+rankList.get(1));
                return (rankList.get(0)+rankList.get(1))/2.0;
            }

        }
    }

    public static void main(String[] args) {
//        int[] data1 = {2,7, 11,12,13, 15,16,17,20};
//        int[] data1 = {2,7, 11,12,13, 15,16,17,20};
//        int[] data2 = {1,6,8,14,18,19,22};
        int[] data1 = {};
        int[] data2 = {1,2,3,4};
        System.out.println(FindMedianSortedArrays.findMedianSortedArrays(data1,data2));
    }
}
